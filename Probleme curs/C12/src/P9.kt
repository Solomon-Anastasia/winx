//Functia map

fun main(args:Array<String>){
    val list1 =listOf<Int>(7,15,24,19,8,45,65,55)
    val list2=List(10){
        (1..12).shuffled().first()
    }
    val list3=(1..15).map{it}
    val transformareList =list1.map{it*2}
    println("list1=${list1}")
    println("Transformare lista1 cu map -> $transformareList")
    println("list2=${list2}")
    println("list3=${list3}")

}