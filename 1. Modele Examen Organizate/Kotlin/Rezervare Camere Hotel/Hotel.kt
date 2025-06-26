import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.FileOutputStream

class Hotel {

    private val rooms: MutableList<Room> = mutableListOf()

    init {
        for (roomNumber in 1..50) {
            rooms.add(Room(roomNumber, RoomState.EMPTY))
        }
    }

    fun printRooms() {
        if (rooms.isEmpty()) {
            println("Empty hotel")
            return
        }

        rooms.forEach {
            println("${it.number} has state: ${it.roomState}")
        }
    }

    fun reserveRoom(number: Int) = runBlocking {
        val room = rooms.firstOrNull { it.number == number }

        if (room != null) {
            when(room.roomState) {
                RoomState.EMPTY -> {
                    room.roomState = RoomState.OCCUPIED
                    return@runBlocking true
                }
                RoomState.OCCUPIED -> {
                    return@runBlocking false
                }
            }
        }

        return@runBlocking false
    }

    fun saveData() {
        val file = File("rooms.txt")

        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()

        val outputStream = FileOutputStream(file)

        rooms.forEach {
            outputStream.write("Room ${it.number} is occupied: ${it.roomState == RoomState.OCCUPIED}\n".toByteArray())
        }

        outputStream.close()
    }
}
