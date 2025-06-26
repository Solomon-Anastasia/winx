class Elicopter(name : String, turnControl: TurnControl, permis : Boolean,  private val rol : String) : ObiectZburator(name, turnControl, permis) {
    override fun land() {
        println("Name: $name $rol FÂL FÂL FÂL FÂL FÂŞ")
        turnControlCorespondednt.notify(this)
    }
}