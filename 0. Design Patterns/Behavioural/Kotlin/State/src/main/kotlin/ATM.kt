class ATM {
    private val hasCard = HasCard(this)
    private val noCard = NoCard(this)
    private val hasCorrectPIN = HasPIN(this)
    private val atmOutOfMoney = NoCash(this)

    private var currentState : ATMState = noCard
    var cashInside = 1000
    var correctPIN = false

    fun insertCard() {
        this.currentState.insertCard()
    }

    fun ejectCard() {
        this.currentState.removeCard()
    }

    fun insertPIN(pin : String) {
        this.currentState.insertPIN(pin)
    }

    fun requestMoney(amount : Int) {
        this.currentState.requestCash(amount)
    }

    fun setMoney(amount : Int) {
        cashInside -= amount
    }

    fun setState(state : ATMState) {
        currentState = state
    }

    fun getHasCardState() : ATMState {
        return this.hasCard
    }

    fun getNoCardState() : ATMState {
        return this.noCard
    }

    fun getHasPINState() : ATMState {
        return this.hasCorrectPIN
    }

    fun getNoCashState() : ATMState {
        return this.atmOutOfMoney
    }
}