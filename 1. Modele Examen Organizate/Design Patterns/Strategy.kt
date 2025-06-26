interface PrintingStrategy{
    fun apply(value: String): String
}

class LowerCaseFormatter : PrintingStrategy
{
    override fun apply(value: String): String {
        return value.toLowerCase()
    }
}

class UpperCaseFormatter : PrintingStrategy
{
    override fun apply(value: String): String {
        return value.toUpperCase()
    }
}

class Printer(var strategy: PrintingStrategy)
{

    fun print(string: String)
    {
        println( strategy.apply(string) )
    }
}

fun main() {

    var lowerPrinter = Printer(LowerCaseFormatter())
    lowerPrinter.print("AAABBBBBCCCCCccc")
}