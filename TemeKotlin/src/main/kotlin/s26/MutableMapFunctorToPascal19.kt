package s26

import kotlinx.coroutines.*
import java.util.concurrent.ConcurrentHashMap

// --- Extension function to convert String to PascalCase ---
fun String.toPascalCase(): String {
    return this.split(" ")
        .joinToString("") { it.replaceFirstChar { c -> c.uppercase() } }
}

// --- Functor class with map chaining functionality (in-place mutation) ---
class MapProcessor<T>(private val map: MutableMap<Int, T>) {

    fun map(transform: (T) -> T): MapProcessor<T> {
        map.entries.forEach { it.setValue(transform(it.value)) }
        return this
    }

    fun getMap(): MutableMap<Int, T> = map
}

// --- Main coroutine test ---
fun main() = runBlocking {
    val data: MutableMap<Int, String> = ConcurrentHashMap(
        mapOf(
            1 to "hello world",
            2 to "kotlin coroutines",
            3 to "open ai chat gpt",
            4 to "multithreaded processing"
        )
    )

    val jobs = List(5) { index ->
        launch {
            println("Coroutine $index starting processing")
            val processor = MapProcessor(data)

            processor
                .map { "Test $it" }
                .map { it.toPascalCase() }

            println("Coroutine $index finished processing: ${processor.getMap()}")
        }
    }

    jobs.forEach { it.join() }

    println("\nFinal processed map:")
    data.forEach { (k, v) -> println("$k -> $v") }
}
