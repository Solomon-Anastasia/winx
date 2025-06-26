//Functii de extensie-conflict de nume
class Sclav{
    fun munca()="*munca la birt*"
    private fun odihna()="*odihna la vecina*"
}
fun Sclav.munca()="munca cu mila"
fun<T>Sclav.munca(t:T)="*muncesc azi?nuuu $t*"
fun Sclav.odihna()="odihna in sant"

fun main(){
    val sclav=Sclav()
    println(sclav.munca())
    println(sclav.munca("de maine ma apuc"))
    print(sclav.odihna())
}