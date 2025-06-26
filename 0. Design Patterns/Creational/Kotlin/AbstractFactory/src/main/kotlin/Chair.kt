abstract class Chair(private val name : String, private val price : Int, private val material : String) {
    override fun toString() : String {
        return "Name: $name Pret: $price Material: $material"
    }
}