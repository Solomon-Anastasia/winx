package s88

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock

// Abstract Operation
abstract class Operation(protected val map: MutableMap<String, Double>, val lock: ReentrantLock) {
    abstract fun execute(key1: String, key2: String, resultKey: String)
}

// Add
class Add(map: MutableMap<String, Double>, lock: ReentrantLock) : Operation(map, lock), Runnable {
    override fun execute(key1: String, key2: String, resultKey: String) {
        lock.withLock {
            val result = map.getValue(key1) + map.getValue(key2)
            map[resultKey] = result
            println("Add: $key1 + $key2 = $result")
        }
    }

    override fun run() {
        execute("a", "b", "sum")
    }
}

// Subtract
class Subtract(map: MutableMap<String, Double>, lock: ReentrantLock) : Operation(map, lock), Runnable {
    override fun execute(key1: String, key2: String, resultKey: String) {
        lock.withLock {
            val result = map.getValue(key1) - map.getValue(key2)
            map[resultKey] = result
            println("Subtract: $key1 - $key2 = $result")
        }
    }

    override fun run() {
        execute("a", "b", "diff")
    }
}

// Multiply
class Multiply(map: MutableMap<String, Double>, lock: ReentrantLock) : Operation(map, lock), Runnable {
    override fun execute(key1: String, key2: String, resultKey: String) {
        lock.withLock {
            val result = map.getValue(key1) * map.getValue(key2)
            map[resultKey] = result
            println("Multiply: $key1 * $key2 = $result")
        }
    }

    override fun run() {
        execute("a", "b", "product")
    }
}

// Divide
class Divide(map: MutableMap<String, Double>, lock: ReentrantLock) : Operation(map, lock), Runnable {
    override fun execute(key1: String, key2: String, resultKey: String) {
        lock.withLock {
            val result = map.getValue(key1) / map.getValue(key2)
            map[resultKey] = result
            println("Divide: $key1 / $key2 = $result")
        }
    }

    override fun run() {
        execute("a", "b", "quotient")
    }
}

// Main
fun main() {
    val sharedMap = mutableMapOf("a" to 20.0, "b" to 5.0)
    val lock = ReentrantLock()

    val operations = listOf(
        Add(sharedMap, lock),
        Subtract(sharedMap, lock),
        Multiply(sharedMap, lock),
        Divide(sharedMap, lock)
    )

    val threads = operations.map { thread { it.run() } }
    threads.forEach { it.join() }

    println("Final map: $sharedMap")
}
