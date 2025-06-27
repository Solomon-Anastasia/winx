import kotlin.random.Random

fun main() {
    val A = mutableSetOf<Int>()
    val B = mutableSetOf<Int>()

    while(A.size < 20) {
        A.add(Random.nextInt(1, 101))
    }

    while(B.size < 20) {
        B.add(Random.nextInt(1, 101))
    }

    val A_reunit_B = A.union(B)
    val B_intersectat_A = B.intersect(A)

    val produs = A_reunit_B.flatMap { a -> B_intersectat_A.map { b-> Pair(a,b)}}.toSet()

    val result = mutableMapOf(
        "A reunit cu B " to A_reunit_B,
        "B intersectat cu A" to B_intersectat_A,
        "(A reunit cu B) x (B intersectat cu A) " to produs
    )

    result.forEach{(key, value) ->
        println("$key : $value ")
    }
}