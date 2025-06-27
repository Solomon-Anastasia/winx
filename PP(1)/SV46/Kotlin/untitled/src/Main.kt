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

    val AxB = A.flatMap{a->B.map{b->Pair(a,b)}}.toSet()
    val BxA = B.flatMap{a->A.map{b->Pair(a,b)}}.toSet()

    val AxB_intersectat_BxA = AxB.intersect(BxA)

    val result = hashMapOf(
        "AxB" to AxB,
        "BxA" to BxA,
        "(AxB) interesectat (BxA)" to AxB_intersectat_BxA
    )

    result.forEach { (key, value) ->
        println("$key : $value")
    }
}