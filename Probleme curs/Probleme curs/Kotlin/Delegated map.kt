data class Carte(val delegate:Map<String,Any?>){
    val nume:String by delegate
    val autori:String by delegate
    val numarPagini:Int by delegate
    val dataPublicarii:String by delegate
    val editura:String by delegate
}
fun main(){
    val mapCarte1=mapOf(
        Pair("nume","povesti corecte politic de adormit copii"),
        Pair("autori","James Finn Gaener"),
        Pair("pageCount",200),
        Pair("dataPublicarii","01/06/2006"),
        Pair("editura","Humanitas")
    )
    val mapCarte2=mapOf(
        "nume" to "critica ratiunii pure",
        "autori" to "Immanuel Kant",
        "numarPagini" to 250,
        "dataPublicarii" to "12/05/1998",
        "editura" to "IRI"
    )
    val cartea1=Carte(mapCarte1)
    val cartea2=Carte(mapCarte2)
    println("prima Carte \n$cartea1 \nA doua Carte \n$cartea2")
}