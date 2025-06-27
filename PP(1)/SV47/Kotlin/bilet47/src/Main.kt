import kotlin.random.Random

fun main() {

    val A = mutableSetOf<Int>()
    val B = mutableSetOf<Int>()

    while (A.size < 20) {
        A.add(Random.nextInt(1, 101))
    }

    while (B.size < 20) {
        B.add(Random.nextInt(1, 101))
    }

    val AxB = A.flatMap{a -> B.map {b -> Pair(a, b)}}.toSet()
    val BxB  = B.flatMap{a -> B.map {b -> Pair(a, b)}}.toSet()

    val AxB_reunit_BxB = AxB.union(BxB)

    val result = hashMapOf(
        "Produs cartezian AxB " to AxB,
        "Produs cartezian BxB " to BxB,
        "Reuniunea AxB cu BxB " to AxB_reunit_BxB
    )

    result.forEach{(key, value)->
        println("$key : $value")
    }
 }