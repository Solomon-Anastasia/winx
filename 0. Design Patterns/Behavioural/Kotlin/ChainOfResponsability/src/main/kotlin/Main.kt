fun main() {
    val handlerAdd = AddNumbersHandler()
    val handlerSub = SubNumbersHandler()
    val handlerMultiply = MultiplyNumbersHandler()
    val handlerDivide = DivideNumbersHandler()

    handlerAdd.setNextHandler(handlerSub)
    handlerSub.setNextHandler(handlerMultiply)
    handlerMultiply.setNextHandler(handlerDivide)

    val request = Numbers(12 ,23, "*")

    try {
        handlerAdd.calculate(request)
    } catch (e : RuntimeException) {
        println(e.message)
    }
}