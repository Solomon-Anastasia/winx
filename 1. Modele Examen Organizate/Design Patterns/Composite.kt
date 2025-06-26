interface Product{
    var price: Int
    var name: String

    fun settName(name: String)
    fun gettPrice(): Int
}

class Mouse(override var price: Int, override var name: String): Product
{
    override fun settName(name: String) {
        this.name = name
    }

    override fun gettPrice(): Int {
        return this.price
    }
}

class Tastatura(override var price: Int, override var name: String): Product
{
    override fun settName(name: String) {
        this.name = name
    }

    override fun gettPrice(): Int {
        return this.price
    }
}

class ProductManager
{
    var list = mutableListOf<Product>()

    fun add(product: Product)
    {
        list.add(product)
    }

    fun calculatePrice(): Int
    {
        var sum = 0
        list.forEach {
            sum += it.gettPrice()
        }
        return sum
    }
}

fun main()
{
    var manager = ProductManager()

    manager.add(Mouse(20,"Logitech"))
    manager.add(Tastatura(30,"Razer"))
    manager.add(Mouse(15,"Steel"))
    manager.add(Tastatura(60,"Steel"))

    println(manager.calculatePrice())


}