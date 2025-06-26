import java.io.File
import java.lang.reflect.Proxy
import java.util.Scanner

interface student{
    fun afiseazaStare()
}

class Integralist(val nume : String, val prenume : String, val grupa : String, val dictionary : Map<String, Int>) : student{
    override fun afiseazaStare(){
        print("Studentul ${nume} ${prenume} din grupa ${grupa} este integralist si are mediile: ")
        dictionary.forEach{
                key, value -> print(key + "-> ${value}, ")
        }
        println()
    }
}

class Restantier(val nume : String, val prenume : String, val grupa : String, val dictionary : Map<String, Int>) : student{
    override fun afiseazaStare(){
        print("Studentul ${nume} ${prenume} din grupa ${grupa} este restantier si are mediile: ")
        dictionary.forEach{
                key, value -> print(key + "-> ${value}, ")
        }
        println()
    }
}

class Repetent(val nume : String, val prenume : String, val grupa : String, val dictionary : Map<String, Int>) : student{
    override fun afiseazaStare(){
        print("Studentul ${nume} ${prenume} din grupa ${grupa} este repetent si are mediile: ")
        dictionary.forEach{
                key, value -> print(key + "-> ${value}, ")
        }
        println()
    }
}

class Unavailable() : student{
    override fun afiseazaStare(){
        print("Nu exista acest tip de student.")
    }
}

class StudentCreator(){
    fun createStudent(type : String, nume : String, prenume : String, grupa : String, dictionary : Map<String, Int>) : student{
        when(type){
            "integralist" -> return Integralist(nume,prenume,grupa,dictionary)
            "restantier" -> return Restantier(nume,prenume,grupa,dictionary)
            "repetent" -> return Repetent(nume,prenume,grupa,dictionary)
            else -> return Unavailable()
        }
    }
}

class ProxyStudent(var realStudent : student,var  parola : String) : student{

    override fun afiseazaStare(){
        if(realStudent is Integralist)
            realStudent.afiseazaStare()
        else
        {
            print("Pentru a vedea starea studentului trebuie sa introduci parola: ")
            val pw = readLine()!!
            if(pw == parola){
                realStudent.afiseazaStare()
            }
            else {
                println("Parola gresita. Nu ai acces la datele studentului")
            }
            println()
        }

    }

}

fun main(){
    var studentCreator = StudentCreator()

    var lines : List<String> = File("studenti.txt").readLines()
    var studenti = mutableListOf<student>()

    var proxyStudents = mutableListOf<ProxyStudent>()

    var cuvinte : List<String>

    lines.forEach{line -> cuvinte = line.split(" "); var nume = cuvinte[0]; var prenume = cuvinte[1];
        var grupa = cuvinte[2]; var dictionary = mutableMapOf<String,Int>();
        var noteMici = 0
        dictionary[cuvinte[3]] = cuvinte[4].toInt(); dictionary[cuvinte[5]] = cuvinte[6].toInt();
        dictionary[cuvinte[7]] = cuvinte[8].toInt(); dictionary[cuvinte[9]] = cuvinte[10].toInt()
        dictionary[cuvinte[11]] = cuvinte[12].toInt();

        dictionary.forEach{
            key, value ->
            if(value < 5){
                noteMici += 1
            }
        }

        if(noteMici == 0)
        {
            val student = studentCreator.createStudent("integralist",
                nume, prenume, grupa, dictionary); studenti.add(student)

        }
        else{
            if(noteMici > 4){
                val student = studentCreator.createStudent("repetent",
                    nume, prenume, grupa, dictionary); studenti.add(student)
            }
            else
            {
                val student = studentCreator.createStudent("restantier",
                    nume, prenume, grupa, dictionary); studenti.add(student)
            }
        }

    }

    for(index in studenti.indices){
        proxyStudents.add(ProxyStudent(studenti[index],index.toString()))
    }

    proxyStudents.forEach{
        student -> student.afiseazaStare()
    }
}