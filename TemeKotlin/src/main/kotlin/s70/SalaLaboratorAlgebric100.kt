package s70

// ------------------ Lab Object Abstraction ------------------
interface LabObject {
    val name: String
    fun use()
    fun inspect()
}

// ------------------ Concrete Lab Objects ------------------
class Computer(override val name: String) : LabObject {
    override fun use() = println("Using computer $name")
    override fun inspect() = println("Inspecting computer $name")
}

class Chair(override val name: String) : LabObject {
    override fun use() = println("Sitting on chair $name")
    override fun inspect() = println("Inspecting chair $name")
}

class Desk(override val name: String) : LabObject {
    override fun use() = println("Working at desk $name")
    override fun inspect() = println("Inspecting desk $name")
}

// ------------------ Algebraic List (ADT) ------------------
sealed class LabList {
    abstract fun forEach(action: (LabObject) -> Unit)
}

data class Node(val obj: LabObject, val next: LabList) : LabList() {
    override fun forEach(action: (LabObject) -> Unit) {
        action(obj)
        next.forEach(action)
    }
}

data object Empty : LabList() {
    override fun forEach(action: (LabObject) -> Unit) {}
}

// ------------------ Laboratory ------------------
class Laboratory(private var objects: LabList = Empty) {
    fun add(obj: LabObject) {
        objects = Node(obj, objects)
    }

    fun operateAll() {
        println("Operating all objects:")
        objects.forEach { it.use() }
    }

    fun inspectAll() {
        println("Inspecting all objects:")
        objects.forEach { it.inspect() }
    }
}

// ------------------ Main ------------------
fun main() {
    val lab = Laboratory()
    lab.add(Computer("Comp-01"))
    lab.add(Chair("Chair-01"))
    lab.add(Desk("Desk-01"))

    lab.inspectAll()
    println("---")
    lab.operateAll()
}
