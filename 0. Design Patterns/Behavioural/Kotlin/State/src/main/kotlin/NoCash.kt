class NoCash(private val atm: ATM) : ATMState {
    override fun insertCard() {
        println("ATM out of cash")
    }

    override fun removeCard() {
        println("ATM out of cash")

    }

    override fun insertPIN(pin: String) {
        println("ATM out of cash")

    }

    override fun requestCash(cashToWithdraw: Int) {
        println("ATM out of cash")

    }
}