//Functii pentru taiere submultimi -drop

fun main(args:Array<String>){
    val dimLista=20
    val lista1 =listOf(2,1,1,7,6,-8,9,-12)
    val lista =1.until(dimLista).toList()
    val catTaiStanga=8
    val catTaiDreapta=9
    val taiDinStanga =lista.drop(catTaiStanga)
    val taiDinDreapta =lista.dropLast(catTaiDreapta)
    var extragSubinterval= lista.drop(catTaiStanga).drop(catTaiDreapta)
    var extragereSelectiva =lista1.dropWhile{e->e>0}
    println("lista originala $lista")
    println("elimin subinterval stang [1..${catTaiStanga}] ->${taiDinStanga}")
    println("elimin subinterval drept [dim lista-${catTaiDreapta}...dim lista]->${taiDinDreapta}")
    println("Extragere submultime de le ${catTaiStanga} la ${catTaiDreapta} -> ${extragSubinterval}")
    println("Extragere selectiva pe baza predicat - $extragereSelectiva")
}