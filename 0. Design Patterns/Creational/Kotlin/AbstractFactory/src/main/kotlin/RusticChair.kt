class RusticChair(name : String, price : Int, material : String, private val manufacturer: String) : Chair(name, price, material) {
    override fun toString(): String {
        return super.toString() + " Made by: $manufacturer"
    }
}