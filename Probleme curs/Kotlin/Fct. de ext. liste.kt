//Functii de extensie pentru liste

fun <T>List<T>.tail():List<T> =this.drop(1)
infix fun<T>T.prependTo(list:List<T>):List<T> =listOf(this)+list
fun <T>List<T>.destructured():Pair<T,List<T>> =first() to tail()

fun main(){
    val intregi =listOf(11,5,3,8,1,9,6,2)
    println(intregi.tail())
    println(intregi.prependTo(intregi))
    println(intregi.destructured())
}