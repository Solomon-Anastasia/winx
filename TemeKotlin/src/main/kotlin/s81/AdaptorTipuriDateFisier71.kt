package s81

import java.io.File

// --- Target Interface ---
interface DataWriter {
    fun write(fileName: String)
}

// --- Adapter for String ---
class StringAdapter(private val data: String) : DataWriter {
    override fun write(fileName: String) {
        File(fileName).writeText(data)
    }
}

// --- Adapter for Int (or other primitives) ---
class IntAdapter(private val data: Int) : DataWriter {
    override fun write(fileName: String) {
        File(fileName).writeText(data.toString())
    }
}

// --- Adapter for Collections (List, Set, Map) ---
class CollectionAdapter(private val data: Any) : DataWriter {
    override fun write(fileName: String) {
        val output = when (data) {
            is Collection<*> -> data.joinToString(separator = "\n")
            is Map<*, *> -> data.entries.joinToString(separator = "\n") { "${it.key} => ${it.value}" }
            else -> "Unsupported collection type"
        }
        File(fileName).writeText(output)
    }
}

// --- Client class using Adapters ---
object FileWriterClient {
    fun writeToFile(obj: Any, fileName: String) {
        val writer: DataWriter = when (obj) {
            is String -> StringAdapter(obj)
            is Int -> IntAdapter(obj)
            is Collection<*> -> CollectionAdapter(obj)
            is Map<*, *> -> CollectionAdapter(obj)
            else -> throw IllegalArgumentException("Unsupported data type: ${obj::class}")
        }
        writer.write(fileName)
    }
}

// --- Main usage example ---
fun main() {
    FileWriterClient.writeToFile("Hello Adapter!", "string.txt")
    FileWriterClient.writeToFile(12345, "int.txt")
    FileWriterClient.writeToFile(listOf("apple", "banana", "cherry"), "list.txt")
    FileWriterClient.writeToFile(mapOf(1 to "one", 2 to "two"), "map.txt")
}
