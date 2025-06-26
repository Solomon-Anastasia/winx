//Optimizare in functie de numarul core

fun main(args: Array<String>)=runBloking{
    println("${Thread.activeCount()} fire de executie active la pornire")
    val time = mesureTimeMillis{
        createCoroutines(10_0)
    }
    println("${Thread.activeCount()} fire de executie active la sfarsit")
    println("Procesul a durat $time ms")
}
suspend fun createCoroutines(amount:Int){
    val backgroundPool: CoroutineDispatcher by lazy{
        val numProcessors =Runtime.getRuntime().avaibleProcessors()
        when{
            numProcessors <= 2 ->newFixedThreadPoolContext(2,"background")
            else -> newFixedThreadPoolContext(numProcessors,"background")
        }
    }
    val jobs =ArrayList<Job>()
    for (i in 1..amount){
        jobs += GlobalScope.launch(backgroundPool){
            println("Am pornit $i in ${Thread.currentThread().name}")
            delay(1000)
            println("S-a terminat $i din ${Thread.currentThread().name}")
        }
    }
    jobs.forEach{
        it.join()
    }
}