fun main() {
    val carBuilder = CarBuilder()
    val airplaneBuilder = AirplaneBuilder()
    val shipBuilder = ShipBuilder()

    val director = Director(carBuilder)

    director.buildVehicle()
    val car = director.getBuiltVehicle()

    println(car)

    director.setBuilder(airplaneBuilder)

    director.buildVehicle()
    val airplane = director.getBuiltVehicle()

    println(airplane)

    director.setBuilder(shipBuilder)

    director.buildVehicle()
    val ship = director.getBuiltVehicle()

    println(ship)
}