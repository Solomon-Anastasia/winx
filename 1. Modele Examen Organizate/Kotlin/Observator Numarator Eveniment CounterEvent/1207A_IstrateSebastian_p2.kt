import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Editor {
    var events: EventManager = EventManager()

    fun update(n: Int){
        events.notifyAll(n)
    }
}

class EventManager {
    private var observers = mutableListOf<Observer>()

    fun attach(o: Observer) {
        observers.add(o)
    }

    fun detach(o: Observer) {
        observers.remove(o)
    }

    fun notifyAll(n: Int) {
        for (i in observers) {
            i.update(n)
        }
    }
}

interface Observer{
    fun update(n: Int)
}

class Numarator(private var n: Int): Observer {
    override fun update (n: Int) {
        this.n = n + 1
        println("Incremented $n to ${this.n}")
    }
}

fun main() = runBlocking<Unit> {
    val editor: Editor = Editor()
    val a = Numarator(5)
    editor.events.attach(a)

    launch {
        val job1 = async { editor.update(6) }
        val job2 = async { editor.update(7) }

        job1.start()
        job2.start()
    }
}