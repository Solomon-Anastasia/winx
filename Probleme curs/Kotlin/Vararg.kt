//Vararg

fun calculMedie(listaNumere:List<Int>):Float{
    var suma=0.0f
    for(element in listaNumere){ suma +=element }
    return (suma/listaNumere.size)
}
fun calculMedieParametrii(vararg lista_parametri: Int):Float{
    var suma=0.0f
    for(element in lista_parametri){
        suma +=element
    }
    return (suma/lista_parametri.size)
}
fun <T>enumerareCaOLista(vararg parametri_intrare:T):List<T>{
    val rezultat=ArrayList<T>()
    for(element in parametri_intrare){ rezultat.add(element)}
    return rezultat
}
fun main(args: Array<String>){
    val tablou =arrayListOf(1,2,3,4)
    val rezultat =calculMedie(tablou)
    print("\nMedia este ${rezultat}")
    val rezultat1 =calculMedieParametrii(1,2,3)
    print("\nMedia1 este ${rezultat1}")
    val rezultat3 =enumerareCaOLista(1,2,3,4,5,6,7,8,9)
    print("\nTransformare enumerare in lista ${rezultat3}")
    print("\nMedia1 este ${calculMedieParametrii(*rezultat3.toIntArray())}")
    val tablou1=intArrayOf(1,2,3,4)
    val rezultat4=calculMedieParametrii(5,6,7,8,9,*tablou1)
    print("\nMedia1 este ${rezultat4}")
}