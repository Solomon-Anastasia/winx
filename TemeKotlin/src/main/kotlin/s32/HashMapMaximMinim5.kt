package s32

import java.io.File
import java.util.concurrent.ConcurrentHashMap
import kotlin.concurrent.thread

// --- Base class defining operations ---
open class OperationProcessor(protected val map: MutableMap<Int, String>) {
    open fun operate() {
        // default no-op
    }

    fun printMap() {
        println(map)
    }
}

// --- Subclass to find max value (lexicographically) ---
class MaxFinder(map: MutableMap<Int, String>) : OperationProcessor(map) {
    override fun operate() {
        val max = map.values.maxOrNull()
        println("Max value: $max (found by ${Thread.currentThread().name})")
    }
}

// --- Subclass to find min value (lexicographically) ---
class MinFinder(map: MutableMap<Int, String>) : OperationProcessor(map) {
    override fun operate() {
        val min = map.values.minOrNull()
        println("Min value: $min (found by ${Thread.currentThread().name})")
    }
}

// --- Subclass to count occurrences of each value ---
class OccurrenceCounter(map: MutableMap<Int, String>) : OperationProcessor(map) {
    override fun operate() {
        val counts = map.values.groupingBy { it }.eachCount()
        println("Occurrences (by ${Thread.currentThread().name}):")
        counts.forEach { (k, v) -> println("$k -> $v") }
    }
}

// --- Subclass to remove duplicates ---
class DuplicateRemover(map: MutableMap<Int, String>) : OperationProcessor(map) {
    override fun operate() {
        val uniqueValues = map.values.toSet()
        map.clear()
        uniqueValues.forEachIndexed { index, v -> map[index] = v }
        println("Duplicates removed by ${Thread.currentThread().name}")
    }
}

// --- Main function ---
fun main() {
    // Initialize map from file data
    val map = ConcurrentHashMap<Int, String>()
    val lines = File("data.txt").readText().split(" ")
    lines.forEachIndexed { index, value ->
        map[index] = value
    }

    println("Initial map:")
    map.forEach { (k, v) -> println("$k -> $v") }

    // Create processor objects
    val maxFinder = MaxFinder(map)
    val minFinder = MinFinder(map)
    val counter = OccurrenceCounter(map)
    val remover = DuplicateRemover(map)

    // Launch threads (active objects with fine-grained threads)
    val threads = listOf(
        thread { maxFinder.operate() },
        thread { minFinder.operate() },
        thread { counter.operate() },
        thread { remover.operate() }
    )

    threads.forEach { it.join() }

    println("\nFinal map after duplicate removal:")
    map.forEach { (k, v) -> println("$k -> $v") }
}
