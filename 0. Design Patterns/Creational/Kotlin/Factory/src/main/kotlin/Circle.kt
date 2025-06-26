import kotlin.math.PI

class Circle(name : String, private val radius : Double) : Shape(name) {
    companion object {
        var counter = 0
    }

    override fun toString(): String {
        return super.toString() + " Radius : $radius Area: ${calcArea()}"
    }

    override fun calcArea(): Double {
        return PI * radius * radius
    }
}