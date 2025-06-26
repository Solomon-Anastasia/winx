import java.util.Random

class CirclesCreator : ShapeCreator() {
    override fun createShape(): Shape {
        Circle.counter++
        return Circle("Circle "+Circle.counter, Random().nextDouble())
    }
}