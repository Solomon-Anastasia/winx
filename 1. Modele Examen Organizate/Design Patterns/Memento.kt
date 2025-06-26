
data class Memento(var x: Int, var y: Int)

class Player(var x: Int, var y: Int)
{
    fun createSave(saves: Saves)
    {
        saves.addSave(Memento(x,y))
    }

    fun loadSave(saves: Saves)
    {
        var aux: Memento = saves.gettSave()

        this.x = aux.x
        this.y = aux.y
    }

    fun setXY(x: Int, y: Int)
    {
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "x= $x, y= $y"
    }
}

class Saves{
    var saves = ArrayList<Memento>()

    fun addSave(save: Memento)
    {
       saves.add(save)
    }

    fun gettSave(): Memento
    {
        return saves.get(0)
    }
}

fun main()
{
    var saves = Saves()
    var player = Player(20, 30)
    println(player)

    player.createSave(saves)
    player.setXY(30,20)
    println(player)

    player.loadSave(saves)
    println(player)
}