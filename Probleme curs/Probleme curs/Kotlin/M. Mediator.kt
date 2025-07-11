//Modelul Mediator
interface Comand{ fun land() }
class Flight(private val atcMediator: IATCMediator): Comand{
    override fun land(){
        if(atcMediator.isLandingOk){
            println("Landing done...")
            atcMediator.setLandingStatus(true)
        }else
            println("Will wait to land...")
    }
    fun getReady(){
        println("Getting ready...")
    }
}
class Runway(private val atcMediator: IATCMediator):Comand{
    init{
        atcMediator.setLandingStatus(true)
    }
    override fun land(){
        println("Landing permission granted...")
        atcMediator.setLandingStatus(true)
    }
}
interface IATCMediator{
    val isLandingOk:Boolean
    fun registerRunway(runway:Runway)
    fun registerFlight(flight :Flight)
    fun setLandingStatus(status:Boolean)
}
class ATCMediator: IATCMediator{
    private var flight: Flight? =null
    private var runway: Runway? =null
    override var isLandingOk: Boolean =false
    override fun registerRunway(runway: Runway){
        this.runway =runway
    }
    override fun registerFlight(flight: Flight){
        this.flight = flight
    }
    override fun setLandingStatus(status: Boolean){
        isLandingOk=status
    }
}
fun main(args: Array<String>){
    val atcMediator = ATCMediator()
    val sparrow101 = Flight(atcMediator)
    val mainRunway = Runway(atcMediator)
    atcMediator.registerFlight(sparrow101)
    atcMediator.registerRunway(mainRunway)
    sparrow101.getReady()
    mainRunway.land()
    sparrow101.land()
}