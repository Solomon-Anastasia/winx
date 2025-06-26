abstract class Table(private val name : String, private val price : Int, private val material : String, private val length : Int) {
    override fun toString() : String {
        return "Name: $name Price: $price Material: $material Length: $length cm"
    }
}