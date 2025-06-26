class Learning2040 : LearningStrategy {
    override fun takeNotes(): Int {
        println("Moama fii atent invat oleak acu si ma duc afara sa mi repar bicicleta")
        return 20
    }

    override fun rest(): Int {
        println("Ia sa stau oleak. Ni ma am intrat pe wikipedia sa citesc despre dinastii chinezesti inteligenta++")
        return 40 // + bonus de inteligenta
    }

    override fun test(): Int {
        println("Bulanus maximus am luat 9")
        return 40
    }
}