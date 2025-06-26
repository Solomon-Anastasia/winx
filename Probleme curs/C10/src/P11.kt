import kotlin.system.measureTimeMillis

//Canale neblocante /ConflatedChanel
fun main(args: Array<String>) = runBlocking{
    val time =measureTimeMillis{
        val channel =Channel<Int>(Channel.UNLIMITED) // Channel.CONFLATED
        val sender =launch{// fara val seader
            repeat(10){//5
                channel.send(it)
                println("Am primit $it")
            }
        }
        for(i in 1..8){ //1..5
            println(channel.receive())
        }
    }
    println("Procesul a durat ${time} ms")
}