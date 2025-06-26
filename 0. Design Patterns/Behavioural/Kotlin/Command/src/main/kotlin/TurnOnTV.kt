class TurnOnTV(private val device: Device) : Command {
    override fun execute() {
        device.turnOn()
    }

    override fun undo() {
        device.turnOff()
    }
}