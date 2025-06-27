package s83

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock

// --- Base class defining operations ---
open class OperationProcessor(protected val map: MutableMap<Int, Int>, protected val lock: ReentrantLock) {
    open fun operate() {
        // default no-op
    }

    fun printMap() {
        println(map)
    }
}

// --- Subclass for addition ---
class Adder(map: MutableMap<Int, Int>, lock: ReentrantLock) : OperationProcessor(map, lock) {
    override fun operate() {
        lock.withLock {
            for (k in map.keys) {
                map[k] = map[k]!! + 1
            }
            println("Addition done by ${Thread.currentThread().name}")
        }
    }
}

// --- Subclass for subtraction ---
class Subtractor(map: MutableMap<Int, Int>, lock: ReentrantLock) : OperationProcessor(map, lock) {
    override fun operate() {
        lock.withLock {
            for (k in map.keys) {
                map[k] = map[k]!! - 1
            }
            println("Subtraction done by ${Thread.currentThread().name}")
        }
    }
}

// --- Subclass for multiplication ---
class Multiplier(map: MutableMap<Int, Int>, lock: ReentrantLock) : OperationProcessor(map, lock) {
    override fun operate() {
        lock.withLock {
            for (k in map.keys) {
                map[k] = map[k]!! * 2
            }
            println("Multiplication done by ${Thread.currentThread().name}")
        }
    }
}

// --- Subclass for division ---
class Divider(map: MutableMap<Int, Int>, lock: ReentrantLock) : OperationProcessor(map, lock) {
    override fun operate() {
        lock.withLock {
            for (k in map.keys) {
                map[k] = map[k]!! / 2
            }
            println("Division done by ${Thread.currentThread().name}")
        }
    }
}

// --- Main function ---
fun main() {
    val sharedMap = ConcurrentHashMap<Int, Int>()
    for (i in 1..5) {
        sharedMap[i] = i * 10
    }

    val lock = ReentrantLock()

    // Create processors
    val adder = Adder(sharedMap, lock)
    val subtractor = Subtractor(sharedMap, lock)
    val multiplier = Multiplier(sharedMap, lock)
    val divider = Divider(sharedMap, lock)

    // Launch threads for each operation
    val threads = listOf(
        thread { adder.operate() },
//        thread { subtractor.operate() },
        thread { multiplier.operate() },
//        thread { divider.operate() }
    )

    threads.forEach { it.join() }

    println("\nFinal shared map:")
    sharedMap.forEach { (k, v) -> println("$k -> $v") }
}
