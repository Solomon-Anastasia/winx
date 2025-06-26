class TV : Device {
    private var volume = 0

    override fun turnOn() {
        println("TV on")
    }

    override fun turnOff() {
        println("TV off")
    }

    override fun volumeUp() {
        volume++
        println("Volume is $volume")
    }

    override fun volumeDown() {
        volume--
        println("Volume is $volume")
    }
}