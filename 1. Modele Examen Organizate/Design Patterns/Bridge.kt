
interface Vehicul{
    val garaj: Garaj

    fun repara()
}

class Masina(override val garaj: Garaj): Vehicul{

    override fun repara() {
        print("Masina a fost ")
        garaj.work()
    }
}

class Bicicleta(override val garaj: Garaj): Vehicul{
    override fun repara() {
        print("Bicicleta a fost ")
        garaj.work()
    }
}

interface Garaj{
    fun work()
}

class Mecanic: Garaj{
    override fun work() {
        println("reparata")
    }
}

class Vopsitorie: Garaj{
    override fun work() {
        println("vopsita")
    }
}


fun main()
{
    Bicicleta(garaj = Mecanic()).repara()

    Bicicleta(garaj = Vopsitorie()).repara()

    Masina(garaj = Vopsitorie()).repara()
}