//Delegates.notNull
import kotlin.properties.Delegates

class Loser{
    var nume: String by Delegates.notNull()
    fun initializare(nume:String){
        this.nume=nume
    }
}
fun main(){
    val utilizator=Loser()
    utilizator.initializare("bibistrocel")
    println(utilizator.nume)
}