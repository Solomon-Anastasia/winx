
interface Car{
    public fun order()
}

enum class CarType{
    Volvo,
    Mercedes,
    Bmw
}

class Volvo: Car{
    override fun order() {
        println("Ordered a Volvo car")
    }
}

class Mercedes: Car{
    override fun order() {
        println("Ordered a Mercedes car")
    }
}

class Bmw: Car{
    override fun order() {
        println("Ordered a Bmw car")
    }
}

class CarFactory{

    fun orderCar(type: CarType): Car?{
        return when (type) {
            CarType.Volvo -> Volvo()
            CarType.Mercedes -> Mercedes()
            CarType.Bmw -> Bmw()
        }
    }
}

fun main()
{
    val carFactory = CarFactory()

    val car1 = carFactory.orderCar(CarType.Mercedes)
    val car2 = carFactory.orderCar(CarType.Bmw)
    val car3 = carFactory.orderCar(CarType.Volvo)
    val car4 = carFactory.orderCar(CarType.Bmw)

    car1?.order()
    car2?.order()
    car3?.order()
    car4?.order()


}