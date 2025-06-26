class NoCard(private val atm: ATM) : ATMState {
    override fun insertCard() {
        println("Card inserted")
        atm.setState(atm.getHasCardState())
    }

    override fun removeCard() {
        println("You have to enter a card first")
    }

    override fun insertPIN(pin: String) {
        println("You have to enter a card first")

    }

    override fun requestCash(cashToWithdraw: Int) {
        println("You have to enter a card first")
    }
}