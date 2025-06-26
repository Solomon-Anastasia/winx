import java.util.ArrayList

interface Command{
    fun execute(list: ArrayList<Int>)
}

class Command1 : Command{
    override fun execute(list: ArrayList<Int>) {
        var max = list.maxOrNull()
        list.remove(max)
        println("Command 1 executed: max = $max")
    }
}

class Command2 : Command{
    override fun execute(list: ArrayList<Int>) {
        var min = list.minOrNull()
        list.remove(min)
        println("Command 2 executed: min = $min")
    }
}

class CommandManager
{
    var commands = ArrayList<Command>()

    fun add(command: Command)
    {
        commands.add(command)
    }

    fun execute(list: ArrayList<Int>)
    {
        commands.forEach {
            it.execute(list)
        }
    }
}

fun main()
{
    var list = ArrayList<Int>(listOf(23,12,4,1,2,6,43,21,7,32))
    var command1 = Command1()
    var command2 = Command2()

//    command1.execute(list)
//    command1.execute(list)
//    command2.execute(list)

    var commands = CommandManager()
    commands.add(command1)
    commands.add(command1)
    commands.add(command2)
    commands.add(command1)

    commands.execute(list)



}