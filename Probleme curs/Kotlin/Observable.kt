//Observable
import kotlin.properties.Delegates

class Loser{
    var nume: String by Delegates.observable("inca nu am nume"){
        proprietate,valoareVeche,valoareNoua -> println("$valoareVeche -$valoareNoua")
    }
}
fun main(){
    val utilizator=Loser()
    utilizator.nume="Cel mai prost din curtea scolii"
    utilizator.nume="Inca si mai prost"
    utilizator.nume="Bun de avansare"
}