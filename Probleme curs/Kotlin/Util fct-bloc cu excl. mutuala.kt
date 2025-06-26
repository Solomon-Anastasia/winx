import java.util.concurrent.*

//Utilizarea functiilor/blocurilor cu excluziune mutuala
fun main(args: Array<String>){
    val g=gigel()
    val executor = Executors.newFixedThreadPool(5)
    for( i in 0..9){
        val worker =Runnable{
            println("sunt in firul "+i)
            g.synchronizedMethod()
            g.methodWithSynchronizedBlock()
        }
        executor.execute(worker)
    }
    executor.shutdown()
    while(!executor.isTerminated){}
    println("S-au terminat toate firele din piscina")
}
class gigel{
    @Synchronized
    fun synchronizedMethod(){
        println("Sunt in metoda sincronizata ${Thred.currentThread()}")
    }
    fun methodWithSynchronizedBlock(){
        println("Zona fara sincronizare: ${Thread.currentThread()}")
        synchronized(this){
            println("Sectiunea cu sincronizare: ${Thread.currentThread()}")
        }
    }
}