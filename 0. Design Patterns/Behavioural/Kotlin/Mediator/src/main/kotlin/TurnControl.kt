class TurnControl : Mediator {

    lateinit var avionCivil: AvionCivil

    override fun notify(sender: ObiectZburator) {
            for (avion in avioane)
                if (sender == avion)
                    checkPermission(avion)
    }

    fun checkPermission(test : ObiectZburator) {
        if (test.getPermit())
            test.ok()
        else
            println("Nu ai voie sa aterizezi")
    }

    override fun addComponent(obiectZburator: ObiectZburator) {
        avioane.add(obiectZburator)
    }
}