class ModernFactory : AbstractFactory {
    override fun createChair(name: String, price: Int, material: String, manufacturer: String): Chair {
        return ModernChair(name, price, material, manufacturer)
    }

    override fun createTable(name: String, price: Int, material: String, length : Int, manufacturer: String): Table {
        return ModernTable(name, price, material, length, manufacturer)
    }

}