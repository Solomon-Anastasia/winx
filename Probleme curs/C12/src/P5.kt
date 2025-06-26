//Functii de extensie si functii membre

open class Canina{
    open fun vorbeste()="Un animal din clasa Caninelor face: ham ham!"
}
fun mesajScris(canina:Canina){
    println(canina.vorbeste())
}
class Caine:Canina(){
    override fun vorbeste()="Un caine face: vauf vauf!"
}
fun mesajScris1(canina:Canina){
    println(canina.vorbeste1())
}
fun Caine.vorbeste()="Din functia extensie Un caine face haf haf"
fun Canina.vorbeste1()="functie extensie specifica cainelui"
fun main(args:Array<String>){
    mesajScris(Canina())
    mesajScris(Caine())
    mesajScris1(Caine())
}