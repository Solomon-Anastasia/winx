class Sheep(val age : Int) : Animal {
    override fun makeCopy(): Animal {
        return this.clone() as Sheep
    }

    override fun toString(): String {
        return "Sheep Age: $age"
    }
}