import javafx.application.Application.launch

//Oprirea fortata a unei corutine

fun main()=runBlocking{
    val job =launch{
        repeat(30){ i->println("Calculam ceva $1 ...")
        delay(300L)}
    }
    delay(1000L)
    println("main: utilizatorul a cerut oprirea calculelor")
    job.cancelAndJoin()
    println("main: Operatiunea in curs a fost abandonata")
}