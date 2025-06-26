class AvionCivil(name : String, turnControl: TurnControl, permis : Boolean) : ObiectZburator(name, turnControl, permis) {
    override fun land() {
        println("Avion civil vreau sa aterizez $name $permis")
        turnControlCorespondednt.notify(this)
    }
}