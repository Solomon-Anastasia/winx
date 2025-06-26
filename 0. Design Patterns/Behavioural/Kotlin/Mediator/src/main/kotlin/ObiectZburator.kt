abstract class ObiectZburator(protected val name : String, protected val turnControlCorespondednt : Mediator, protected val permis : Boolean) {
    init {
        turnControlCorespondednt.addComponent(this)
    }

    abstract fun land()

    fun ok() {
        println("Landing $name $permis")
    }

    fun getPermit() : Boolean {
        return permis
    }
}
