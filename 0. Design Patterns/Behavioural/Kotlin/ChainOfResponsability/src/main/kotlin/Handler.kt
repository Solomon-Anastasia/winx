interface Handler {
    fun setNextHandler(nextHander : Handler)
    fun calculate(nr : Numbers)
}