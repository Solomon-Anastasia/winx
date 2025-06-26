fun main() {
    val circleCreator = CirclesCreator()
    val squareCreator = SquareCreator()

    for (i in 1..10)
        println(circleCreator.createShape())

    for (i in 1..10)
        println(squareCreator.createShape())
}