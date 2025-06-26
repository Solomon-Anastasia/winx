fun main() {
    val tv = TV()

    val onCommand = TurnOnTV(tv)
    val offCommand = TurnOffTV(tv)
    val vUpCommand = TurnUpTV(tv)
    val vDownCommand = TurnDownTV(tv)

    val onButton = RemoteButton(onCommand)
    val offButton = RemoteButton(offCommand)
    val volumeUpButton = RemoteButton(vUpCommand)
    val volumeDownButton = RemoteButton(vDownCommand)

    onButton.press()
    offButton.press()
    offButton.pressUndo()

    for (i in 1..50)
        volumeUpButton.press()

    for (i in 1..10)
        volumeDownButton.press()
}