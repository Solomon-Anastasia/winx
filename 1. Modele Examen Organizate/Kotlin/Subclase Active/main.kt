
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import sun.awt.Mutex

import java.io.File
import java.util.concurrent.locks.ReentrantLock

var globalVar = mutableListOf<Pair<Int, Int>>()
private val mutex= Mutex()
private val lock= ReentrantLock()
open class Command(): Thread()
{
    open fun execute(list: MutableList<Pair<Int,Int>>) {}
}
class Invoker(listd: MutableList<Pair<Int,Int>>)
{
    var list=mutableListOf<Command>()
    var hm=listd
    fun setCommands(command:Command)
    {
        this.list.add(command)
    }
    fun executeCommands()
    {
        for (command in this.list)
        {
             var thread=Thread{command.execute(globalVar)}
            thread.start()
        }
    }

}
class sort(): Command()
{

    override fun execute(map: MutableList<Pair<Int,Int>>){
        mutex.lock()

        try {
            var f = globalVar.sortedWith(compareBy({ it.first }, { it.second })).toMutableList()
            println(f)
            globalVar=f
        }
        finally{mutex.unlock()}
    }
}
class eliminare(): Command()
{


    override fun execute(mp: MutableList<Pair<Int,Int>>) {
        lock.lock()
        try{
            Thread.sleep(3000L)
            var f=globalVar.toSet().toList().toMutableList()
            println(f)
            globalVar=f
        }
        finally{
            lock.unlock()
        }

    }

}
fun main()= runBlocking {


    val Dictionar = mutableListOf<Pair<Int,Int>>()
    val filename = "src/main/kotlin/hash"
    val lines: List<String> = File(filename).readLines()
    lines.forEach { line -> var list = line.split(" "); var n= Pair(list[0].toInt(),list[1].toInt()); Dictionar.add(n)}

    globalVar=Dictionar
    var base=Invoker(globalVar)

    base.setCommands(sort())
    base.setCommands(eliminare())
    base.executeCommands()

    delay(4000L)
    println(globalVar)

}

