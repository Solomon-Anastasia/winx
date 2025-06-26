class Caretaker {
    private val history = ArrayDeque<Memento>()
    private var textHolder = TextHolder()

    fun write(text : String) {
        history.addFirst((textHolder.save()))
        textHolder.addToText(text)
    }

    fun undo() {
        if (history.isNotEmpty()) {
            textHolder.restore(history.removeFirst())
            show()
        }
    }

    fun show() {
        println(textHolder.getText())
    }
}