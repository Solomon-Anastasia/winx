class Bike : Cloneable
{
    var nume: String = "standard"
    var viteze: Int = 4

    fun makeAdvanced()
    {
        nume = "advanced"
        viteze = 6
    }

    override fun clone(): Any {
        return Bike()
    }

    override fun toString(): String {
        return "Nume: $nume, Viteze: $viteze"
    }
}

fun main()
{
    var advBike = Bike()
    advBike.makeAdvanced()
    println(advBike)

}