fun generareSetA(limit : Int) : Set<Double> {

    return generateSequence(1) { it + 1}
        .map { n -> (8 * n - 18).toDouble() / (2 * n - 9) }
        .take(limit)
        .toSet()
}

fun generateSetB(limit : Int) : Set<Double> {
    return generateSequence(1) { it + 1 }
        .map {n -> (9 * n * n - 48 * n  + 16).toDouble() / (3 * n - 8 )}
        .take(limit)
        .toSet()
}

fun main() {
    val A = generareSetA(100)
    val B = generateSetB(100)

    val AxB = A.flatMap { a -> B.map { b -> Pair(a, b) } }.toSet()
    val B_intersectat_A = B.intersect(A)
    val reuniune = AxB.union(B_intersectat_A)

    val result = hashMapOf(
        "Multimea A " to A,
        "Multimea B " to B,
        "A x B " to AxB,
        "B intersectat cu A " to B_intersectat_A,
        "(A x B) reunit cu (B intersectat cu A) " to reuniune
    )

    result.forEach { (key, value) ->
    println("$key : $value")
}

}
