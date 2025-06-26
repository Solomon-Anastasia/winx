class TextHolder {
    private var currentText = ""

    fun addToText(text : String) {
        currentText += text
    }

    fun save() : Memento {
        return Memento(currentText)
    }

    fun restore(memento : Memento) {
        this.currentText = memento.getText()
    }

    fun getText() : String {
        return currentText
    }
}