interface VehicleBuilder {
    fun setVehiclePurpose()
    fun buildEngine()
    fun buildSeats()
    fun setVehicleFuel()
    fun buildWings()
    fun buildWaterProofSystem()
    fun buildVehicle() : Vehicle
}