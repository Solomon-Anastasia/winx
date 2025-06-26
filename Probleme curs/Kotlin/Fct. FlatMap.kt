//Functia FlatMap
fun main(args:Array<String>){
    val lista1=List(10){
        (26..120).shuffled().first()
    }
    val listaBatutaCuCiocanul =lista1.flatMap{
        it.rangeTo(it+2*it).toList()
    }
    println("lista dupa aplicarea flat Map este $listaBatutaCuCiocanul")
}