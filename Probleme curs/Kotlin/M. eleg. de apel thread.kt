import java.lang.Thread.*

//Metoda eleganta de apel thread

fun main(args: Array<String>){
    val thread1 =thread(start=true,name="Speedy",priority=MAX_PRIORITY){
        println("Thread-ul ${Thread.currentThread()} s-a executat")
    }
    val thread2 =thread(start=true,name="Turtle",priority=MIN_PRIORITY){
        println("Thread-ul ${Thread.currentThread()} s-a executat")
    }
}
public fun thread(start: Boolean = true, isDaemon:Boolean=false,contextClassloader:Classloader?=null,name:String?=null,priority:Int=-1,block:()->Unit):Thread{
    val thread= object:Thread(){
        public override fun run(){
            block()
        }
    }
    if(isDaemon) thread.isDaemon=true
    if(priority>0) thread.priority =priority
    if(name != null) thread.name=name
    if(contextClassloader != null) thread.contextClassloader=contextClassloader
    if(start) thread.start()
    return thread
}