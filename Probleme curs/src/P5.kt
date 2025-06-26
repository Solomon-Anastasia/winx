/*import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class Controller{
    private var clicks: Int =0
    fun enableHook() {
        //eroare button... de ce? naiba stie...
        button.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent){clicks++}
        })
    }
}
*/
//clase pentru gestiune avansata de date
interface Printable{fun print():Unit}
public enum class Word:Printable{
    HELLO{
        override fun print(){
            println("Word is HELLO")
        }
    },
    BYE{
        override fun print(){
            println("Word is BYE")
        }
    }
}

//Metode statice si obiecte companion
fun showFirstCharacter(input:String):Char{
    if(input.isEmpty()) throw IllegalArgumentException()
    return input.first()
}
object Singleton{
    private var count=0
    fun doSomething():Unit{
        println("Calling a doSomething (${++count} call/-s in total)")
    }
}

fun main(args: Array<String>){
    val w=Word.HELLO
    w.print()
    val x=Word.BYE
    x.print()
    val a=showFirstCharacter("Kotlin is cool!")
    println(a)
    Singleton.doSomething()
}