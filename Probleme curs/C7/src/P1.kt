import sun.invoke.empty.Empty
import java.io.Serializable
import java.util.*
import javax.xml.soap.*
import kotlin.Comparator

//Polimorfism limitat superior
fun <T: Comparable<T>>min(first: T,second: T):T{
    val k= first.compareTo(second)
    return if(k <= 0) first else second
}

//Limitari multiple
fun <T>minSerializable(first: T,second: T): T where T: Comparable<T>,T: Serializable {
    val k=first.compareTo(second)
    return if(k <= 0) first
            else second
}

fun main(args: Array<String>) {
    val a: Int = min(4, 5)
    val b: String = min("e", "c")
    println(a)
    println(b)
    println()

    val c: Int= minSerializable(5,6)
    val d: String=minSerializable("g","a")
    println(c)
    println(d)
    
}

