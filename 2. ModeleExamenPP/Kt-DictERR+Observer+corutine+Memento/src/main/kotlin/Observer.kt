abstract class Observer(protected val subject: Subject, protected val caretaker: Caretaker) {
    protected val dict=mapOf("wrk" to "work", "cod3" to "code", "cart" to "chart")
    abstract fun update(word: String)
}