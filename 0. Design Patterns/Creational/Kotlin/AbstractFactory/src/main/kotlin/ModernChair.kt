class ModernChair(private val name : String, private val price : Int, private val material : String, private val manufacturer : String)  : Chair(name, price, material) {
    override fun toString(): String {
        return super.toString() + " Made by: $manufacturer"
    }
}