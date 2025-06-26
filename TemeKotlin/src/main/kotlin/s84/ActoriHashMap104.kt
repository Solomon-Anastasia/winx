package s84

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor

// ------------------ Operation Interface ------------------
interface Operation {
    val key: String
    val value: Int
    fun apply(current: Int?): Int
}

// ------------------ Operation Implementations ------------------
class AddOperation(override val key: String, override val value: Int) : Operation {
    override fun apply(current: Int?) = (current ?: 0) + value
}

class SubOperation(override val key: String, override val value: Int) : Operation {
    override fun apply(current: Int?) = (current ?: 0) - value
}

class MulOperation(override val key: String, override val value: Int) : Operation {
    override fun apply(current: Int?) = (current ?: 1) * value
}

class DivOperation(override val key: String, override val value: Int) : Operation {
    override fun apply(current: Int?): Int {
        if (value == 0) return current ?: 0
        return (current ?: (value * value)) / value
    }
}

// ------------------ Actor Messages ------------------
sealed class MapActorMessage
data class Perform(val op: Operation) : MapActorMessage()
data object Stop : MapActorMessage()

// ------------------ Actor Definition ------------------
@OptIn(ObsoleteCoroutinesApi::class)
fun CoroutineScope.mapActor(map: MutableMap<String, Int>) = actor<MapActorMessage> {
    for (msg in channel) {
        when (msg) {
            is Perform -> {
                val current = map[msg.op.key]
                map[msg.op.key] = msg.op.apply(current)
            }

            Stop -> channel.close()
        }
    }
}

// ------------------ Main ------------------
fun main() = runBlocking {
    val sharedMap = mutableMapOf<String, Int>()
    val actor = mapActor(sharedMap)

    val jobs = listOf(
        launch { actor.send(Perform(AddOperation("a", 10))) },
        launch { actor.send(Perform(MulOperation("a", 5))) },
        launch { actor.send(Perform(SubOperation("b", 3))) },
        launch { actor.send(Perform(AddOperation("b", 10))) },
        launch { actor.send(Perform(MulOperation("c", 4))) },
        launch { actor.send(Perform(DivOperation("c", 2))) },
    )

    jobs.forEach { it.join() }

    actor.send(Stop)
    delay(200)

    println("Final map: $sharedMap")
}

