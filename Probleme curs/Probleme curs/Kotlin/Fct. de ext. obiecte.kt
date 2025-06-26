//Functii de extensie pt obiecte

object Constructor {}
fun Constructor.casaNouaCaramida()="casa pe pamant"
class Proiectant{
    companion object{}
    object Birou{}
}
fun Proiectant.Companion.prototipNou()="montaj test"
fun Proiectant.Birou.mapaDeLucrari()=listOf("Proiect casa","Proiect bloc")
fun main(){
    println(Constructor.casaNouaCaramida())
    println(Proiectant.prototipNou())
    Proiectant.Birou.mapaDeLucrari().forEach(::println)
}