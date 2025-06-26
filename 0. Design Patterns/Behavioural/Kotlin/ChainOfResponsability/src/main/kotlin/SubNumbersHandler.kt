class SubNumbersHandler : Handler {
    private lateinit var nextHandler : Handler

    override fun setNextHandler(nextHander: Handler) {
        this.nextHandler = nextHander
    }

    override fun calculate(nr: Numbers) {
        if (nr.getOperation() == "-")
            println("${nr.getNr1()} - ${nr.getNr2()} = ${nr.getNr1() - nr.getNr2()}")
        else
            nextHandler.calculate(nr)
    }
}