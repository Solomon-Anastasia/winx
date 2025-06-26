interface AbstractFactory {
    fun createChair(name : String, price : Int, material : String, manufacturer : String) : Chair
    fun createTable(name : String, price : Int, material : String, length : Int, manufacturer : String) : Table
}