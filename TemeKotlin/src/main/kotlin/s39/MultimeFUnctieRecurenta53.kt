package s39

import kotlin.random.Random

fun main() {
    // --- Generate set A with 100 random even numbers ---
    val A = List(100) { Random.nextInt(1, 10) }

    println("First 10 elements in A: ${A.take(10)}\n")

    // --- Calculate b_n = sum of squares up to n ---
    val b = mutableListOf<Int>()
    var sum = 0

    for (i in A.indices) {
        sum += A[i] * A[i]
        b.add(sum)
    }

    // --- Display results ---
    println("b_n values (first 10):")
    for (i in 0 until 10) {
        println("b_${i + 1} = ${b[i]}")
    }

    // Optional: print all results
    // b.forEachIndexed { index, value -> println("b_${index+1} = $value") }
}
