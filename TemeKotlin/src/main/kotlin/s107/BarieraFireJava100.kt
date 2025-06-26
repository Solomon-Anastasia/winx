package s107

import java.util.concurrent.ConcurrentHashMap

// ------------------ Custom Barrier ------------------
class ThreadBarrier(private val totalThreads: Int) {
    private var waitingThreads = 0
    private val lock = Object()

    fun await() {
        synchronized(lock) {
            waitingThreads++
            if (waitingThreads < totalThreads) {
                lock.wait()
            } else {
                lock.notifyAll()
            }
        }
    }
}

// ------------------ Worker Task ------------------
class SumWorker(
    private val id: Int,
    private val map: MutableMap<String, Int>,
    private val keys: List<String>,
    private val barrier: ThreadBarrier
) : Runnable {

    override fun run() {
        var sum = 0
        for (key in keys) {
            sum += map.getOrDefault(key, 0)
        }

        println("Thread-$id partial sum = $sum")

        // Wait at the barrier
        barrier.await()

        println("Thread-$id passed barrier.")
    }
}

// ------------------ Main ------------------
fun main() {
    val map = ConcurrentHashMap<String, Int>()
    for (i in 0 .. 10) {
        map["k$i"] = i + 1
    }

    val numThreads = 3
    val barrier = ThreadBarrier(numThreads)

    val threads = List(numThreads) { i ->
        val keys = map.keys.toList().slice(i * 3 until minOf((i + 1) * 3, map.size))
        Thread(SumWorker(i, map, keys, barrier))
    }

    threads.forEach { it.start() }
    threads.forEach { it.join() }

    println("All threads have completed.")
}
