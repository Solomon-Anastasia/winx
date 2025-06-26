import com.sun.org.apache.xpath.internal.operations.Bool

class Button(var mediator: Mediator)
{
    fun press()
    {
        mediator.press()
    }
}

class Fan(var mediator: Mediator)
{
    var isOn: Boolean = false

    fun turnOn()
    {
        isOn = true
    }

    fun turnOff()
    {
        isOn = false
    }
}

class Mediator{
    var button: Button? = null
    var fan: Fan? = null

    fun press()
    {
        if (fan?.isOn == true)
        {
            fan?.turnOff()
        }
        else
        {
            fan?.turnOn()
        }
    }

    fun settButton(button: Button)
    {
        this.button = button
    }

    fun settFan(fan: Fan)
    {
        this.fan = fan
    }

}

fun main()
{
    var mediator = Mediator()
    var button = Button(mediator)
    var fan = Fan(mediator)

    mediator.settButton(button)
    mediator.settFan(fan)

    button.press()
    println(fan.isOn)
    button.press()
    println(fan.isOn)
}