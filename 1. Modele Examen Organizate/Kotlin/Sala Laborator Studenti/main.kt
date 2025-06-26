import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception


interface ISala{
    fun setObiecte(recuzite : List<IObiecte>)
    fun intraPersoana(persoana : IStudent)
    fun iesePersoana(persoana : IStudent)
    fun adaugaObiecte(recuzita : IObiecte)
    fun stergeObiecte(recuzita : IObiecte)
    fun persoaneInSala()
    fun ObiecteInSala()
    fun logSala()

}

interface IObiecte{
    fun folositaDe(persoana : IStudent?)
}

interface IStudent{
    fun intraSala(sala : ISala)
    fun ieseSala(sala : ISala)
    fun folosesteObiecte(Obiecte : IObiecte)
    fun opresteFolosireaObiecte(Obiecte: IObiecte)
}

class SalaDeLaborator(private val numeSala : String) : ISala{
    val Obiecte = mutableListOf<IObiecte>()
    val persoane = mutableListOf<IStudent>()
    var logText = ""

    override fun setObiecte(recuzite: List<IObiecte>) {
        recuzite.forEach {
            adaugaObiecte(it)
        }
    }

    override fun intraPersoana(persoana: IStudent) {
        persoane.add(persoana)
        logText += " Intra: ${persoana}\n"
    }

    override fun iesePersoana(persoana: IStudent) {
        persoane.remove(persoana)
        logText += " Iese: ${persoana}\n"
    }

    override fun adaugaObiecte(ob: IObiecte) {
        Obiecte.add(ob)
        logText += " A fost adaugata: ${ob}\n"
    }

    override fun stergeObiecte(ob: IObiecte) {
        Obiecte.remove(ob)
        logText += " A fost scoasa: ${ob}\n"
    }

    override fun persoaneInSala() {
        println("Persoane in $numeSala:")
        persoane.forEach {
            println("\t$it")
        }
    }

    override fun ObiecteInSala() {
        println("Recuzite in $numeSala:")
        Obiecte.forEach {
            println("\t$it")
        }
    }

    override fun logSala() {
        println("Log pentru sala $numeSala:")
        println(logText)
    }

}

class Student(private val numeStudent : String, private val grupa : String) : IStudent{
    override fun intraSala(sala: ISala) {
        sala.intraPersoana(this)
        println("A intrat un student in sala")
    }

    override fun ieseSala(sala: ISala) {
        sala.iesePersoana(this)
        println("A iesit un student din sala")
    }

    override fun folosesteObiecte(ob: IObiecte) {
        try {
            ob.folositaDe(this)
            println("Studentul a folosita ${ob.toString()}")
        }catch(e : Exception){
            println(e)
        }
    }

    override fun opresteFolosireaObiecte(ob: IObiecte) {
        ob.folositaDe(null)
        println("studentul a terminat cu ${ob.toString()}")
    }


}


class Calculator(private val numarStatie : Int) : IObiecte{
    private var persoana : IStudent? = null
    override fun folositaDe(persoana: IStudent?) {
        if(persoana == null) {
            this.persoana = null
            return
        }
        if(this.persoana != null)
            throw Exception("$persoana deja foloseste $this")
        else
            this.persoana = persoana
    }

    override fun toString(): String {
        return "Calculator: $numarStatie"
    }

}
class Scaun(private val nrScaun: Int): IObiecte{
    private var persoana : IStudent? = null
    override fun folositaDe(persoana: IStudent?) {
        if(persoana == null) {
            this.persoana = null
            return
        }
        if(this.persoana != null)
            throw Exception("$persoana deja foloseste $this")
        else
            this.persoana = persoana
    }

    override fun toString(): String {
        return "Scaun: $nrScaun"
    }
}


fun main(args: Array<String>) =runBlocking{
    val laborator1 : ISala = SalaDeLaborator("C43")
    var student1=Student("abc","1234")

    val calc1 = Calculator(1)
    val calc2 = Calculator(2)
    val calc3 = Calculator(3)
    val scaun1=Scaun(1)
    val scaun2=Scaun(2)
    val scaun3=Scaun(3)

    laborator1.setObiecte(listOf<IObiecte>(
        calc1,
        calc2,
        calc3,
        scaun1,
        scaun2,
        scaun3
    ))

    launch {
        delay(1000L)
        println("corutina: ")
        student1.intraSala(laborator1)
    }
    launch{
        delay(2000L)
        println("corutina: ")
        student1.folosesteObiecte(scaun1)
    }
    launch{
        delay(3000L)
        println("corutina: ")
        student1.folosesteObiecte(calc1)
    }
    launch {
        delay(4000L)
        println("corutina: ")
        student1.opresteFolosireaObiecte(calc1)
    }
    launch {
        delay(5000L)
        println("corutina: ")
        student1.opresteFolosireaObiecte(scaun1)
    }
    launch {
        delay(6000L)
        println("corutina: ")
        student1.ieseSala(laborator1)
    }


    println("gata")



}