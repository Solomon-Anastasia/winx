//Mapare corutine pe thread-uri

import kotlin.system.*
import javax.xml.bind.JAXBElement

suspend fun createCoroutines(amount:Int){
    val jobs= ArrayList<Job>()
    for(i in 1..amount){
        jobs += JAXBElement.GlobalScope.launch {
            println("Am pornit $i in ${Thread.currentThread().name}")
            delay(1000)
            println("S-a terminat $i din ${Thread.currentThread().name}")
        }
    }
    jobs.forEach{it.join}
}


fun main(args:Array<String>)=runBlocking{
    println("${Thread.activeCount()} fire de executie active la pornire")
    val time =measureTimeMillis{
        createCoroutines(10_00)
    }
    println("${Thread.activeCount()} fire de executie active la sfarsit")
    println("Procesul a durat $time ms")
}