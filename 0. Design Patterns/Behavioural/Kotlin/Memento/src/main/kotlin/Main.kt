fun main() {
    val editor = Caretaker()

    editor.write("bla")
    editor.show()
    editor.write(" arara")
    editor.show()
    editor.write(" vsdfsdfss")
    editor.show()
    editor.undo()
    editor.undo()
    editor.undo()
    editor.undo()
}