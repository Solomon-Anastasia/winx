class AvionPasageri(name : String, turnControl: TurnControl, permis : Boolean, private val pasageri : Int) : ObiectZburator(name, turnControl, permis) {
    override fun land() {
        println("Avion pasageri vreau sa aterizez Nume: $name Pasageri: $pasageri")
        turnControlCorespondednt.notify(this)
    }
}