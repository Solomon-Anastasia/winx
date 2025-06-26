class Square(name : String, private val sideLength : Double) : Shape(name) {
    companion object {
        var counter = 0
    }

    override fun toString(): String {
        return super.toString() + " Side length: $sideLength Area: ${calcArea()}"
    }

    override fun calcArea(): Double {
        return sideLength * sideLength
    }
}