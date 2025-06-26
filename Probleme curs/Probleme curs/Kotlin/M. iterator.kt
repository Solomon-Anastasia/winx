//Modelul iterator
class Schita(val name: String)
class Schite(val Schite: MutableList<Schita> = mutableListOf()) :Iterable<Schita>{
    override fun iterator():Iterator<Schita> = SchiteIterator(Schite)
}
class SchiteIterator(val Schite: MutableList<Schita> =mutableListOf(),var current: Int =0):Iterator<Schita>{
    override fun hasNext():Boolean = Schite.size> current
    override fun next():Schita{
        val Schita = Schite[current]
        current++
        return Schita
    }
}

fun main(args: Array<String>){
    val Schite = Schite(mutableListOf(Schita("Test1"),Schita("Test2")))
    Schite.forEach{ println(it.name)}
}