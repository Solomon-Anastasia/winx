import java.util.*

class SquareCreator : ShapeCreator() {
    override fun createShape(): Shape {
        Square.counter++
        return Square("Square " + Square.counter, Random().nextDouble())
    }
}