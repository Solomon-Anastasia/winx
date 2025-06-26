//Canale de comunicare

fun main(args: Array<String>) = runBlocking{
    val time =mesureTimeMillis{
        val channel =Channel<Int>()
        val sender =launch{
            repeat(10){
                channel.send(it)
                println("Am trimis $it")
            }
        }
        for(i in 1..10){
            channel.receive()
        }
    }
    println("procesul a durat ${time} ms")
}