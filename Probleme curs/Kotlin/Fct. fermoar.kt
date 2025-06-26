//functia fermoar

fun main(args:Array<String>){
    val lista1=listOf(1,2,3,4,5)
    val lista2=listOf(
        "element 1",
        "element 2",
        "element 3",
        "element 4",
        "element 5"
    )
    val listaRezultat =lista1.zip(lista2)
    println("utilizare zipWithNext -> ${lista1.zipWithNext()}")
    println(listaRezultat)
}