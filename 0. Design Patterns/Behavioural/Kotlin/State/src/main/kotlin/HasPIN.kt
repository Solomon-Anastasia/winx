class HasPIN(private val atm: ATM) : ATMState {
    override fun insertCard() {
        println("You already inserted a card")
    }

    override fun removeCard() {
        println("Card ejected")
        atm.setState(atm.getNoCardState())
    }

    override fun insertPIN(pin: String) {
        println("You already entered a PIN")
    }

    override fun requestCash(cashToWithdraw: Int) {
        if (cashToWithdraw >= atm.cashInside) {
            println("ATM doesn't have enough money\nCard ejected")
            atm.setState(atm.getNoCardState())
        } else {
            atm.setMoney(atm.cashInside - cashToWithdraw)
            println("Here is your money: $cashToWithdraw")
            println("Card ejected!")
            atm.setState(atm.getNoCardState())

            if (atm.cashInside <= 0) {
                println("ATM out of money")
                atm.setState(atm.getNoCashState())
            }
        }
    }
}