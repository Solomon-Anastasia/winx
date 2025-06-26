class Director(private var builder : VehicleBuilder) {
    fun getBuiltVehicle() : Vehicle {
        return builder.buildVehicle()
    }

    fun buildVehicle() {
        builder.setVehiclePurpose()
        builder.buildEngine()
        builder.buildSeats()
        builder.setVehicleFuel()
        builder.buildWings()
        builder.buildWaterProofSystem()
    }

    fun setBuilder(newBuilder : VehicleBuilder) {
        builder = newBuilder
    }
}