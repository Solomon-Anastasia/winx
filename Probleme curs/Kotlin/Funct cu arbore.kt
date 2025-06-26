//Functor cu arbore
class ArboreBinar<T>(var value: T){
    var stanga: ArboreBinar<T>? =null
    var dreapta: ArboreBinar<T>? =null
    fun <U>map(f:(T)->U):ArboreBinar<U>{
        val arbore =ArboreBinar<U>(f(value))
        if(stanga !=null) arbore.stanga =stanga?.map(f)
        if(dreapta !=null) arbore.dreapta=dreapta?.map(f)
        return arbore
    }
    fun AfisezParteaSuperioara()="(${stanga?.value},$value,${dreapta?.value}"
}
fun main(args:Array<String>){
    val barb =ArboreBinar(6)
    barb.stanga=ArboreBinar(20)
    barb.dreapta=ArboreBinar(9)
    println(barb.AfisezParteaSuperioara())
    val barb1=barb.map{it*50.0}
    println(barb1.AfisezParteaSuperioara())
}