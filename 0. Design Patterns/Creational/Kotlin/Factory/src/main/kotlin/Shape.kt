abstract class Shape(private val name : String) {
    override fun toString(): String {
        return "Name: $name"
    }
    abstract fun calcArea() : Double
}