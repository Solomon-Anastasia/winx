package s53

import java.util.concurrent.ConcurrentHashMap

fun main() {
    // Generate collection A
    val A = (1..200) // using a higher range to get enough valid N results
        .mapNotNull { n ->
            val x = (8 * n - 18).toDouble() / (2 * n - 9)
            if (x % 1 == 0.0 && x > 0) x.toInt() else null
        }
        .take(100)

    // Generate collection B
    val B = (1..200)
        .mapNotNull { n ->
            val x = (9 * n * n - 48 * n + 16).toDouble() / (3 * n - 8)
            if (x % 1 == 0.0) x.toInt() else null
        }
        .take(100)

    println("Collection A (first 10): ${A.take(10)}")
    println("Collection B (first 10): ${B.take(10)}")

    // Compute AxB (Cartesian product)
    val AxB = A.flatMap { a ->
        B.map { b -> Pair(a, b) }
    }

    // Compute B ∩ A (intersection)
    val intersection = B.intersect(A.toSet())

    // Combine AxB and B∩A
    val combined = mutableListOf<Any>()
    combined.addAll(AxB)
    combined.addAll(intersection)

    // Store in HashMap
    val resultMap = ConcurrentHashMap<Int, Any>()
    combined.forEachIndexed { index, value ->
        resultMap[index] = value
    }

    // Display
    println("\n--- Result HashMap ---")
    resultMap.forEach { (k, v) ->
        println("$k -> $v")
    }
}
