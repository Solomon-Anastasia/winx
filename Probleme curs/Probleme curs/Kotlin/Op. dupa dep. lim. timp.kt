//Oprire dupa depasirea limitei de timp

fun main(){
    puturos()
}
fun puturos(){
    runBlocking{
        val job =launch{
            try{
                withTimeout(1000L){
                    repeat(30){ i-> println("calculez $i ...")
                    delay(300L)}
                }
            }catch(e: TimeoutCancellationException){
                println("Sunt un lenes si ma opresc")
            }
        }
    }
}
//Depasirea limitei de timp fara exceptii
fun main(){
    if(null ==lenes())
        println("Ma opresc din lene")}
fun lenes():String?{
    var status:String?=""
        runBlocking{
            val status1 =withTimeoutOrNull1(1000L){
                repeat(30){ i-> println("Calcul numarul $i ...")
                    delay(300L)
                }
                "Gata"
            }
            status=status1
        }
    return status
}
