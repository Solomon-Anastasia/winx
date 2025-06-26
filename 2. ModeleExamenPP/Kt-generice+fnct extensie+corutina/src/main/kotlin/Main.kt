import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.io.File

fun <T,R>List<T>.ap(fab:List<(T)->R>):List<R> = fab.flatMap { this.map(it) }


fun main()= runBlocking {
    val numbers= File("text.txt").readText().split(' ').map{ it.toInt() }
    val functii=listOf<(Int)->Int>({i->i/3},{i->i*5})
    val task=async{ numbers.ap(functii) }
    val newNumbers=task.await()
    println(newNumbers)
}