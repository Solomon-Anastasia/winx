//Functii de nivel superior

fun procesareNrPare(numar:Int,procesare:(Int)->Int):Int{
    if(numar%2==0){
        return procesare(numar)
    }else{
        return numar
    }
}
fun main(args: Array<String>){
    var nr1=4
    var nr2=5
    println("Apel cu ${nr1} si operatia (it*2): ${procesareNrPare(nr1,{it*2})}")
    println("Apel cu ${nr2} si operatia (it*2): ${procesareNrPare(nr2,{it*2})}")

}