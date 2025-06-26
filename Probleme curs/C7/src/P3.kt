//Conversie tablouri
public inline fun<R> IntArray.map(transform: (Int) ->R): List<R>{
    return mapTo(ArrayList<R>(size),transform)
}
public inline fun <R,C: MutableCollection<in R>>IntArray.mapTo(destination: C,transform: (Int) ->R):C{
    for(item in this)
        destination.add(transform(item))
    return destination
}

/*public inline fun<R>CharArray.flatMap(transform:(Char)->Iterable<R>):List<R>{
    return flatMapTo(ArrayList<R>(),transform)
}
public inline fun<R,C: MutableCollection<in R>>CharArray.flatMapTo(destination: C,transform:(Char)->Iterable<R>){
    for(element in this){
        val list=transform(element)
        destination.addAll(list)
    }
    return destination
}
*/

fun main(args: Array<String>){
    //val strings =ints.map{element ->"Item "+element.toString()}
    //println("Converteste elemente IntArray intr-un string: ${strings.joinToString(",")}")

    val charArray = charArrayOf('a','b','c')
    val tripleCharArray = charArray.flatMap{c->charArrayOf(c,c,c).asIterable()}
    println("tripleaza fiecare element din chararray: ${tripleCharArray.joinToString(",")}")


}