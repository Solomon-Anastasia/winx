package test

fun <T: Comparable<T>> min(first: T, second: T): T {
    val k = first.compareTo(second)
    return if (k <= 0) first else second
}

fun main() {
    var k: Int = 10
    val kk: Int = 3

    k = min(k, kk)
    println(k)
}