//Actori
sealed class CounterMsg
object IncCounter: CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>):CounterMsg()

fun CoroutineScope.counterActor()=actor<CounterMsg>{
    var counter =0
    for(msg in channel){
        when(msg){
            is IncCounter ->counter++
            is GetCounter ->msg.response.complete(counter)
        }
    }
}
val counter = counterActor()
GlobalScope.massiveRun{counter.send(IncCounter)}

val response =CompletableDeferred<Int>()
counter.send(GetCounter(response))
println("Counter = ${response.await()}")
counter.close()