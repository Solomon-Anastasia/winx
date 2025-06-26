import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main()= runBlocking {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val subject=Subject()
    val caretaker=Caretaker()
    var task=launch {
        val words= File("text.txt").readText().split(' ')
        val observer=ConcreteObserver(subject,caretaker)
        subject.register(observer)
        words.forEach { subject.notifyAll(it) }
    }
    task.join()
    task=launch {
        var ok = true
        while (ok && caretaker.getNumberOfMementos() > 0) {
            print("Se poate face undo la ${caretaker.getNumberOfMementos()} corecturi.\n-1=Nu doresc, index_corectura=Indexul corecturii la care se vrea a se da undo\n Raspunsul dumneavoastra: ")
            val ind = br.readLine().toInt()

            if (ind !in 0 until caretaker.getNumberOfMementos())
                ok = false
            else subject.restoreState(caretaker.getMemento(ind))
        }
        println("Lista finala de cuvinte: ${subject.getWords()}")
    }
    task.join()
}