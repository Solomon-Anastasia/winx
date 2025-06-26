class TurnUpTV(private val device: Device) : Command {
    override fun execute() {
        device.volumeUp()
    }

    override fun undo() {
        device.volumeDown()
    }
}