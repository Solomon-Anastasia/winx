import java.text.SimpleDateFormat
import java.util.*

//Async

fun main() = runBloking{
    val deferred1=async{computation1()}
    val deferred2 =async{computation2()}
    printCurrentTime("Astept efectuarea calculelor..")
    val result = deferred1.await() +deferred2.await()
    printCurrentTime("Valoarea calculata este $result")
}
suspend fun computation1(): Int{
    delay(1000L)
    printCurrentTime("Am terminat de calculat prima valoare")
    return 131
}
suspend fun computation2():Int{
    delay(2000L)
    printCurrentTime("Am terminat al doilea calcul")
    return 9
}
fun printCurrentTime(message:String){
    val time =(SimpleDateFormat("hh:mm:ss")).format(Date())
    println("[$time] $message")
}