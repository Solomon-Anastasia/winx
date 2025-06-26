//Modelul automatului finit
class CoffeeMachine{
    var state: CoffeeMachineState
    val MAX_BEANS_QUANTITY =100
    val MAX_WATER_QUANTITY =100
    var beansQuantity =0
    var waterQuantity=0
    val OffState =Off(this)
    val noIngredients = NoIngredients(this)
    val ready =Ready(this)
    init{ state =OffState}
    fun turnOn() =state.turnOn()
    fun fillInBeans(quantity: Int) = state.fillInBeans(quantity)
    fun fillInWater(quantity: Int) = state.fillInWater(quantity)
    fun makeCoffee() = state.makeCoffee()
    fun turnOff() =state.turnOff()
    override fun toString():String{
        return """COFFEE MACHINE - ${state:: class .simpleName}
            | water quantity: $waterQuantity
            | beans quantity : $beansQuantity
            |""".trimMargin()
    }
}
abstract class CoffeeMachineState(val coffeeMachine :CoffeeMachine){
    open fun makeCoffee(): Unit = throw UnsupportedOperationException("Op. not supported")
    open fun fillInBeans(quantity :Int): Unit =throw UnsupportedOperationException("Operation not supported")
    open fun fillInWater(quantity: Int):Unit = throw UnsupportedOperationException("operation not supported")
    open fun turnOn():Unit = throw UnsupportedOperationException("Operation not supported")
    fun turnOff():Unit{
        coffeeMachine.state =coffeeMachine.OffState
    }
}
class Off(coffeeMachine: CoffeeMachine): CoffeeMachineState(coffeeMachine){
    override fun turnOn(){
        coffeeMachine.state = coffeeMachine.noIngredients
        println("Coffee machine turned on")
    }
}
class NoIngredients(coffeeMachine: CoffeeMachine): CoffeeMachineState(coffeeMachine){
    override fun fillInBeans(quantity: Int){
        if((coffeeMachine.beansQuantity + quantity)<=coffeeMachine.MAX_BEANS_QUANTITY){
            coffeeMachine.beansQuantity += quantity
            println("Beans filled in")
            if(coffeeMachine.waterQuantity >0){
                coffeeMachine.state=coffeeMachine.ready
            }
        }
    }
    override fun fillInWater(quantity: Int){
        if((coffeeMachine.waterQuantity + quantity)<=coffeeMachine.MAX_WATER_QUANTITY){
            coffeeMachine.waterQuantity +=quantity
            println("Water filled in")
            if(coffeeMachine.beansQuantity >0){
                coffeeMachine.state = coffeeMachine.ready
            }
        }
    }
}
class Ready(coffeeMachine:CoffeeMachine):CoffeeMachineState(coffeeMachine){
    override fun makeCoffee(){
        coffeeMachine.beansQuantity --
        coffeeMachine.waterQuantity --
        println("Making coffee...DONE")
        if(coffeeMachine.beansQuantity == 0 || coffeeMachine.waterQuantity==0){
            coffeeMachine.state=coffeeMachine.noIngredients
        }
    }
}
fun main(args:Array<String>){
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.turnOn()
    println(coffeeMachine)
    coffeeMachine.fillInBeans(2)
    println(coffeeMachine)
    coffeeMachine.fillInWater(2)
    println(coffeeMachine)
    coffeeMachine.makeCoffee()
    println(coffeeMachine)
    coffeeMachine.makeCoffee()
    println(coffeeMachine)
    coffeeMachine.turnOff()
    println(coffeeMachine)
}