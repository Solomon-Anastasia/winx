// Lambda Examples


val foo = { x: Int -> x + 5 }

fun List<Int>.multiply5() : List<Int>{
    return this.map{it -> it * 5}
}