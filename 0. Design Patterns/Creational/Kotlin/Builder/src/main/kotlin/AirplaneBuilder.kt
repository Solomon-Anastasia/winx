class AirplaneBuilder : VehicleBuilder {
    val airplane = Vehicle()
    override fun setVehiclePurpose() {
        airplane.setVehicleType("Air")
    }

    override fun buildEngine() {
        airplane.setEngineType("Motor de avion nu ma pricep")
    }

    override fun buildSeats() {
        airplane.setSeatNumber(120)
    }

    override fun setVehicleFuel() {
        airplane.setFuelType("Kerosen")
    }

    override fun buildWings() {
        airplane.setHasWings(true)
    }

    override fun buildWaterProofSystem() {
        airplane.setIsAmphibious(false)
    }

    override fun buildVehicle(): Vehicle {
        return airplane
    }
}