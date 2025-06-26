//Functia filtru

import kotlin.math.*

fun main(args:Array<String>){
    val lista=1.until(15).toList()
    val lista1=(1..15).map{it}
    val sublistaImpare =lista.filter{it%2==0}
    println("Sublista care contine numai numerele pare este -> $sublistaImpare")
    val listaPatrate =lista1.filter{
        val radacinaPatrata =sqrt(it.toDouble()).roundToInt()
        radacinaPatrata *radacinaPatrata==it
    }
    println("FilteredListPSSquare ->$listaPatrate")
}