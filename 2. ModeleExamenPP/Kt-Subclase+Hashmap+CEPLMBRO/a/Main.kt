import HashMapProcessor.HashMapProcessorFactory
import java.io.File


fun main(){
    val map=HashMap(File("hash_map.txt").readLines().map { Pair(it.split("->")[0],it.split("->")[1]) }.toMap())
    val fact=HashMapProcessorFactory()
    val runnables=map.map { fact.create(it.value,it.key).get_runnable_object() }
    val threads=runnables.map { Thread(it) }
    threads.forEach { it.start() }
    threads.forEach { it.join() }
}