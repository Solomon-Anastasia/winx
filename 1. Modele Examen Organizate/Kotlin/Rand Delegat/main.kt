import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedWriter
import java.io.FileWriter
import java.lang.IllegalArgumentException
import kotlin.properties.Delegates

fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    return (start..end).random()
}
class delegat{
    var cuprinsa_in_interval: Int by Delegates.vetoable(10)
    {
        proprietate,valoareVeche,valoareNoua->if(valoareNoua>3 && valoareNoua<10) true
        else throw IllegalArgumentException("Conditia este sa fie intre 3 si 10")
    }
}

fun main() = runBlocking {
    var x = delegat()
    var writer = BufferedWriter(FileWriter("nou.txt"))
    launch {
        while (true) {

            delay(1000L)
            x.cuprinsa_in_interval = rand(0, 10)
            writer.write(x.cuprinsa_in_interval.toString())
            writer.write(" ")
            writer.flush()


        }
    }
    writer.write("Valori cuprinse intre 3 si 10: ")
    writer.flush()


}