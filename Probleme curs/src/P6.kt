import java.math.BigDecimal

//Mostenirea simpla

enum class CardType{VISA,MASTERCARD,AMEX}
open class Payment(val amount: BigDecimal)
class CardPayment(amount: BigDecimal,val number: String,val type: CardType):Payment(amount)
class ChequePayment:Payment{
    constructor(amount: BigDecimal,name:String,bankld:String):
            super(amount){
                this.name =name
                this.bankld=bankld
    }
    var name:String
        get() = this.name
    var bankld: String
        get() = this.bankld
}

fun main(args:Array<String>){
    // ??????????
}