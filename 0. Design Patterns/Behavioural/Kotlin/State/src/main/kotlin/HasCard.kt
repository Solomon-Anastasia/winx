class HasCard(private val atm: ATM) : ATMState {
    override fun insertCard() {
        println("Card already inserted")
    }

    override fun removeCard() {
        println("Card Ejected")
        atm.setState(atm.getNoCardState())
    }

    override fun insertPIN(pin: String) {
        if (pin == "1234") {
            println("PIN correct")
            atm.correctPIN = true
            atm.setState(atm.getHasPINState())
        }
        else {
            println("Wrong PIN")
            atm.correctPIN = false
            println("Card ejected")
            atm.setState(atm.getNoCardState())
        }
    }

    override fun requestCash(cashToWithdraw: Int) {
        println("You have insert a card first")
    }
}