class CarBuilder : VehicleBuilder {
    val car = Vehicle()

    override fun setVehiclePurpose() {
        car.setVehicleType("Land")
    }

    override fun buildEngine() {
        car.setEngineType("1.4 rup asfaltu")
    }

    override fun buildSeats() {
        car.setSeatNumber(4)
    }

    override fun setVehicleFuel() {
        car.setFuelType("Diesel")
    }

    override fun buildWings() {
        car.setHasWings(false)
    }

    override fun buildWaterProofSystem() {
        car.setIsAmphibious(false)
    }

    override fun buildVehicle(): Vehicle {
        return car
    }
}