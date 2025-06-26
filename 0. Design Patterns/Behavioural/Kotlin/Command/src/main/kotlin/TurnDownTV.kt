class TurnDownTV(private val device: Device) : Command {
    override fun execute() {
        device.volumeDown()
    }

    override fun undo() {
        device.volumeUp()
    }
}