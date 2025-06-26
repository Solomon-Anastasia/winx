package s108

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import kotlinx.coroutines.*

// ------------------ Memoization Utility ------------------
class Memoizer<T, R>(private val func: (T) -> R) {
    private val cache = ConcurrentHashMap<T, R>()

    fun call(arg: T): R {
        return cache.computeIfAbsent(arg) { func(it) }
    }
}

// ------------------ Recursive Sequence ------------------
// P(i) = P(i-1) + P(i-2), with P(0) = 0, P(1) = 1
fun main() = runBlocking {
    lateinit var memoizer: Memoizer<Int, Long>

    val recursiveFib: (Int) -> Long = { i ->
        when (i) {
            0 -> 0
            1 -> 1
            else -> memoizer.call(i - 1) + memoizer.call(i - 2)
        }
    }

    memoizer = Memoizer(recursiveFib)

    val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
    val jobs = (0..20).map { i ->
        async(dispatcher) {
            println("P($i) = ${memoizer.call(i)}")
        }
    }

    jobs.awaitAll()
    dispatcher.close()
}

