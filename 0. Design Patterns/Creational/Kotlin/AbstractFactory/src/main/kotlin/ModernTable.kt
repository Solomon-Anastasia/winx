class ModernTable(name : String, price : Int, material : String, length : Int, private val manufacturer : String) : Table(name, price, material, length) {
    override fun toString(): String {
        return super.toString() + " Made by: $manufacturer"
    }
}