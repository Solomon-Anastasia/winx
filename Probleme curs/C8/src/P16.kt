//Modelul Dtrategie
interface BookingStrategy{ val fare: Double }
class CarBookingStrategy: BookingStrategy{
    override val fare: Double =12.5
    override fun toString():String{
        return "CarBookingStrategy"
    }
}
class TrainBookingStrategy: BookingStrategy{
    override val fare: Double =8.5
    override fun toString():String{
        return "TrainBookingStrategy"
    }
}
class Customer(var bookingStrategy: BookingStrategy){
    fun calculateFare(numOfPassangeres: Int):Double{
        val fare = numOfPassangeres* bookingStrategy.fare
        println("Calculating fares using "+bookingStrategy)
        return fare
    }
}
fun main(args:Array<String>){
    val cust = Customer(CarBookingStrategy())
    var fare = cust.calculateFare(5)
    println(fare)

    cust.bookingStrategy = TrainBookingStrategy()
    fare =cust.calculateFare(5)
    println(fare)
}