class RemoteButton(private val command: Command) {
    fun press() {
        command.execute()
    }

    fun pressUndo() {
        command.undo()
    }
}