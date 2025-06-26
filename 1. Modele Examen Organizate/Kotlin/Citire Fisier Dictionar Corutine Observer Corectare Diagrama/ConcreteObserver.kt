import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class ConcreteObserver(subject: Subject, caretaker: Caretaker): Observer(subject,caretaker)
{
    override fun update(word: String) {
        val correctedWord=dict[word]
        if(correctedWord != null){
            print("Cuvantul $word pare gresit. Varianta corecta ar putea fi ${dict[word]}." +
                    "\nDoriti corectarea lui? 1-Da 0-Nu\nRaspunsul dumneavoastra: ")
            if(BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()==1)
            {
                subject.addWord(correctedWord)
                caretaker.add(subject.saveState())
            }
            else subject.addWord(word)
        }
        else subject.addWord(word)
    }
}