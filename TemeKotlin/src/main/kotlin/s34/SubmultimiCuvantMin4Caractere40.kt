package s34

import java.io.File

fun main() {
    // --- Step 1. Create or read the input file ---
    val fileName = "data.txt"

    // Example content (create if not exists)
    val file = File(fileName)
    if (!file.exists()) {
        file.writeText("Kotlin is a powerful programming language. Lambda expressions are concise.")
    }

    // --- Step 2. Read file content ---
    val content = file.readText()
    println("Original text:\n$content\n")

    // --- Step 3. Process words using lambda ---
    val processed = content.split("\\s+".toRegex())
        .map { word ->
            if (word.length >= 4) word.drop(2) else word
        }
        .joinToString(" ")

    // --- Step 4. Print result ---
    println("Processed text:\n$processed")
}
