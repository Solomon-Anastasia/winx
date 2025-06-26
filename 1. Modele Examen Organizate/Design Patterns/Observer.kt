interface Observator{
    fun onUpdate()
}

class Paul: Observator{
    override fun onUpdate() {
        println("Paul a fost notificat")
    }
}

class Geanina: Observator{
    override fun onUpdate() {
        println("Geanina a fost notificata")
    }
}

class Footshop{
    var subscribers: ArrayList<Observator> = ArrayList()

    var promo: String = "10%"

    fun subscribe(observator: Observator)
    {
        subscribers.add(observator)
    }

    fun unsubscribe(observator: Observator)
    {
        subscribers.remove(observator)
    }

    fun notifySubs()
    {
        subscribers.forEach {
            it.onUpdate()
        }
    }

    fun changePromo(newPromo: String)
    {
        this.promo = newPromo
        notifySubs()
    }

}

fun main()
{
    var paul: Paul = Paul()
    var geanina: Geanina = Geanina()

    var shop: Footshop = Footshop()

    shop.subscribe(paul)
    shop.changePromo("30%")
    shop.subscribe(geanina)
    shop.changePromo("10%")
}