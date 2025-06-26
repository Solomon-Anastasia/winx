interface State{
    var automat: Automat
    fun execute()
}

class State0 (override var automat: Automat): State{

    override fun execute() {
        if (automat.list.isEmpty())
        {
            println("Nu mai sunt elemente")
            automat.isRunning = false
            return
        }
        else
        {
            automat.settState(automat.state1)
        }
    }
}

class State1 (override var automat: Automat): State{
    override fun execute() {

        for (element: Int in automat.list)
        {
            if (element % 2 == 0)
            {
                println("State 1: Element sters: $element")
                automat.list.remove(element)
                break
            }
        }
        automat.settState(automat.state2)
    }
}

class State2 (override var automat: Automat): State{
    override fun execute() {
        for (element: Int in automat.list)
        {
            if (element % 2 == 1)
            {
                println("State 2: Element sters: $element")
                automat.list.remove(element)
                break
            }
        }
        automat.settState(automat.state0)
    }
}

class Automat(var list: ArrayList<Int>){

    var state0 = State0(this)
    var state1 = State1(this)
    var state2 = State2(this)
    var state: State = state0

    var isRunning: Boolean = true

    fun settState(state: State)
    {
        this.state = state
    }

    fun start()
    {
        while ( isRunning )
        {
            state.execute()
        }
    }
}

fun main()
{
    var list = ArrayList<Int>(listOf(1,2,3,4,5,6,7,8,9,10))
    var automat = Automat(list)

    automat.start()
}