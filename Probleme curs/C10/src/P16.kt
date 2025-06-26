import kotlin.system.measureTimeMillis

//Memoizare Fibbonaci cu map

fun main(args: Array<String>){
    val k=8
    val time = measureTimeMillis{
        println("Fibbonaci($k)="+memfib(k).toString())
    }
    println("Procesul a durat ${time} ms")
    println(map)
}
val map = mutableMapOf<Int,Long>()
fun memfib(k:Int):Long{
    return map.getOrPut(k){
        when(k){
            0->1
            1->1
            else ->memfib(k-1)+memfib(k-2)
        }
    }
}