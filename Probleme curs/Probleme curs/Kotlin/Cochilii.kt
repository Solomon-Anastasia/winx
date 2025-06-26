import java.util.*
import kotlin.collections.ArrayList

//Cochilii
fun <T>itWorks(list: List<T>):Unit{
    println("Java class Type: ${list.javaClass.canonicalName}")
}

fun main(args: Array<String>){
    val jlist=ArrayList<String>()
    jlist.add("sample")
    itWorks(jlist)
    itWorks(Collections.singletonList(1))

    //Exemplu Array
    val intArray = arrayOf(1,2,3,4)
    println("Int array: ${intArray.joinToString(",")}")
    println("Element at index 1 is: ${intArray[1]}")
    
}