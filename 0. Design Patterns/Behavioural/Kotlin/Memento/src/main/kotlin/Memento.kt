class Memento(private val textToSave : String) {
    fun getText() : String {
        return textToSave
    }
}