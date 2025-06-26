//Vetoable
import kotlin.properties.Delegates
class Looser{
    var valoareCrescatoare: Int by Delegates.vetoable(0){
        proprietate,valoareVeche,valoareNoua ->
        if(valoareVeche >valoareNoua) true
        else throw IllegalArgumentException("Noua valoare trebuie sa fie mai mare decat cea veche")
    }
}
fun main(){
    var x=Looser()
    x.valoareCrescatoare=10
    x.valoareCrescatoare=12
    try{
        x.valoareCrescatoare=6
    }catch(e:java.lang.IllegalArgumentException){
        println("Ai un prieten in vizita prin program?")
    }
    x.valoareCrescatoare=15
    println(x.valoareCrescatoare)
}