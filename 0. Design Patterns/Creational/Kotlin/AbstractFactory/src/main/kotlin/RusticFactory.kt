class RusticFactory : AbstractFactory {
    override fun createChair(name: String, price: Int, material: String, manufacturer: String): Chair {
        return RusticChair(name, price, material, manufacturer)
    }

    override fun createTable(name: String, price: Int, material: String, length : Int, manufacturer: String): Table {
        return RusticTable(name, price, material, length, manufacturer)
    }

}