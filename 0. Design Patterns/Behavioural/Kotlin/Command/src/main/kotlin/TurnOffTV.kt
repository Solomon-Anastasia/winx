class TurnOffTV(private val device: Device) : Command {
    override fun execute() {
        device.turnOff()
    }

    override fun undo() {
        device.turnOn()
    }
}