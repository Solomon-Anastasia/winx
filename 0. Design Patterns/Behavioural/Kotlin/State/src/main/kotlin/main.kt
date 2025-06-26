fun main() {
    val atm = ATM()

    atm.insertCard()
    atm.insertCard()
    atm.insertPIN("1234")
    atm.requestMoney(1000)
}