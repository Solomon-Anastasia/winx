//Deadlock

lateinit var jobA: Job
lateinit var jobB: Job

fun main(args: Array<String>)=runBlocking{
    jobA =launch{
        println("Sunt in A")
        jobB.join()
        println("S-a terminat B")
    }
    jobB=launch{
        println("Sunt in B")
        jobA.join()
        println("S-a terminat A")
    }
}
