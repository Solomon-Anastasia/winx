//Functori cu liste

fun List<Int>.convertLaStr():List<String> = if(size >0) {
    val ListaNoua = ArrayList<String>(size)
    for (element in this) {
        ListaNoua.add(procesare(procesareLambda(element, 5)).toString())
    }
    ListaNoua
}else{
    emptyList()
}
val procesareLambda ={x:Int,y:Int ->x-y}
fun procesare(x:Int):Int{
    return x+5
}
fun main(args:Array<String>){
    val ListaIntregi =listOf(271,3,17,23,51)
    println(ListaIntregi.convertLaStr())
}