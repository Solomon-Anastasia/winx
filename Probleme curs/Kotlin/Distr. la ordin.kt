//Distrugere la ordin
class Activity: CoroutineScope by CoroutineScope(Dispatchers.Default){
    fun destroy(){
        cancel()
    }
    fun doSomething(){
        repeat(10){ i-> launch{
            delay((i+1)*200L)
            println("Coroutina $i s-a terminat")
        }}
    }
}
fun main() =runBloking<Unit>{
    val activity =Activity()
    activity.doSomething()
    println("Pornim corutinele")
    delay(500L)
    println("Distrug activitatile")
    activity.destroy()
}