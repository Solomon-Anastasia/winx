class Vehicle : VehiclePlan {
    lateinit var purpose : String
    lateinit var engine : String
    var seats : Int = 0
    lateinit var fuel : String
    var wings : Boolean = false
    var amphibious: Boolean = false


    override fun setVehicleType(type: String) {
        this.purpose = type
    }

    override fun setEngineType(type: String) {
        this.engine = type
    }

    override fun setSeatNumber(number: Int) {
        this.seats = number
    }

    override fun setFuelType(type: String) {
        this.fuel = type
    }

    override fun setHasWings(wings: Boolean) {
        this.wings = wings
    }

    override fun setIsAmphibious(amphibious: Boolean) {
        this.amphibious = amphibious
    }

    override fun toString(): String {
        return "Purpose: $purpose Engine: $engine Seats: $seats Fuel: $fuel Wings: $wings Amphibious: $amphibious"
    }
}