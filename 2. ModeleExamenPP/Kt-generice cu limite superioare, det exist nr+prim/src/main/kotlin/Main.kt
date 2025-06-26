fun List<Number>.allPrimes():Boolean
{
    return !this.any{it !is Int || !it.isPrime()}
}

fun Int.isPrime():Boolean{
    if(this<0)
        return false
    if(this in 1..2)
        return true
    return !2.until(this/2+1).any{this%it==0}
}

fun main()
{
    val lists=listOf(
        listOf(1,2,3,4,5),
        listOf(1.0,2.0,3.0),
        listOf(1,3,7,11))
    lists.forEachIndexed { index, list ->
        println("List $index: $list -> all are primes: ${list.allPrimes()}")
    }

}