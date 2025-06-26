import java.util.*

//wait(),notify() and notifyAll() la piata

class TaranOrasean(private val maxItems: Int){
    @Volatile private var items=0
    private val rand = Random()
    private val lock = java.lang.Object()
    fun produce() =synchronized(lock){
        while(items >= maxItems){ lock.wait() }
        items++
        println("Am produs $items: alimente in ${Thread.currentThread()}")
        lock.notifyAll()
    }
    fun consume() =synchronized(lock){
        while(items <= 0){ lock.wait() }
        items--
        println("Am utilizat $items: alimente in ${Thread.currentThread()}")
        lock.notifyAll()
    }
}
fun main(args: Array<String>){
    println("starting: ${Thread.currentThread()}")

    val example =TaranOrasean(5)

    for(i in 0..14){
        thread(start=true){
            if(i<5){ example.consume()}
            else{ example.produce()}
        }
    }
    println("S-a inchis piata: ${Thread.currentThread()}")
}