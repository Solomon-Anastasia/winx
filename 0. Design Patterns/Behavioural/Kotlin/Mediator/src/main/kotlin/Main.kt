fun main() {
    val turnControl12 = TurnControl()
    val cesna = AvionCivil("Germania", turnControl12, true)
    val boeing = AvionPasageri("Boieng69", turnControl12, false,120)
    val smurdu = Elicopter("Elicopter Smurd 12", turnControl12,true,"medical")

    turnControl12

    cesna.land()
    boeing.land()
    smurdu.land()

}