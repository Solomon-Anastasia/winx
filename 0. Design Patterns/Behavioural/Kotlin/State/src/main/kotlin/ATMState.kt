interface ATMState {
    fun insertCard()
    fun removeCard()
    fun insertPIN(pin : String)
    fun requestCash(cashToWithdraw : Int)
}