class ShipBuilder : VehicleBuilder {
    val ship = Vehicle()
    override fun setVehiclePurpose() {
        ship.setVehicleType("Water")
    }

    override fun buildEngine() {
        ship.setEngineType("Motor de vapor")
    }

    override fun buildSeats() {
        ship.setSeatNumber(30)
    }

    override fun setVehicleFuel() {
        ship.setFuelType("Diesel")
    }

    override fun buildWings() {
        ship.setHasWings(false)
    }

    override fun buildWaterProofSystem() {
        ship.setIsAmphibious(true)
    }

    override fun buildVehicle(): Vehicle {
        return ship
    }
}