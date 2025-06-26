import java.lang.NumberFormatException
import java.util.*

fun main() {
    val hotel = Hotel()

    var command = ""

    var shouldExit = false

    while (!shouldExit) {
        command = readLine()!!

        when (command) {
            "show" -> {
                hotel.printRooms()
            }
            "reserve" -> {
                println("Enter room number:")
                val roomNumberString = readLine()!!
                println("Reserving room number $roomNumberString")

                var roomNumber: Int
                try {
                    roomNumber = roomNumberString.toInt()
                } catch (e: NumberFormatException) {
                    println("Invalid number")
                    continue
                }

                if (hotel.reserveRoom(roomNumber)) {
                    println("Reserved")
                } else{
                    println("The room was occupied. Cannot reserve")
                }
            }
            "exit" -> {
                shouldExit = true
            }
        }
    }

    hotel.saveData()

}

val queue = ArrayDeque<String>()

fun Hotel.receptioner() {

}

fun Hotel.addToWaitingList() {

}
