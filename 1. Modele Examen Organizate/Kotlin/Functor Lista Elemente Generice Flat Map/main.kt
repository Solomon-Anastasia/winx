

class RevertFlatMap<T>(val list: List<T>){
    fun map() : List<Pair<T,T>>{
        var list1=list.filterIndexed { index, i -> index%2==0 } as MutableList<T>
        var list2=list.filterIndexed { index, i -> index%2==1 } as MutableList<T>
        var pairs=list1.zip(list2)
        println("Lista impartita in perechi: "+pairs)
        return pairs
    }
}
fun Tupla(list: MutableList<Int>){
    var list1=list.filterIndexed { index, i -> index%2==0 } as MutableList<Int>
    var list2=list.filterIndexed { index, i -> index%2==1 } as MutableList<Int>
    var pairs=list1.zip(list2)
    println("Lista impartita in perechi: "+pairs)
}
fun main() {
    Tupla(mutableListOf(1, 2, 3, 4))
    println(listOf(RevertFlatMap(mutableListOf(1, 2, 3, 4))))
    //println(listOf(RevertFlatMap(mutableListOf(1, 2, 3, 4).map()))) -_-
}
