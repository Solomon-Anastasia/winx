package com.pp.laborator
import kotlinx.coroutines.*
import kotlin.system.*
import java.util.concurrent.locks.ReentrantLock

var sharedCounterLock = ReentrantLock()

interface furnicaAbstracta{
    public suspend fun send(s : String)
    public suspend fun receive(s : String)
}

interface Mediator{
    public suspend fun notify(f : furnicaAbstracta, s : String)
    public fun adaugaFurnica(f : furnicaAbstracta)
}

class Furnica(var mediator : Mediator, var Name : String) : furnicaAbstracta{

    private var m = mediator
    private var name = Name

    public override suspend fun send(s : String){
        println("Furnica " + name + " a trimis mesajul: " + s)
        m.notify(this, s)
    }

    public override suspend fun receive(s : String){
        println("Furnica " + name + " a primit mesajul: " + s)
    }
}

class ConcreteMediator: Mediator{

    var furnici = ArrayList<furnicaAbstracta>()

    public override suspend fun notify(f : furnicaAbstracta, s : String){
        for(furnica in furnici)
        {
            if(furnica != f){
                sharedCounterLock.lock()
                try{
                    furnica.receive(s)
                }
                finally{
                    sharedCounterLock.unlock()
                }
            }
        }

        println()

    }

    public override fun adaugaFurnica(f : furnicaAbstracta){
        furnici.add(f)
    }
}


fun main() = runBlocking<Unit>{
    val mediator = ConcreteMediator()

    val furnica1 = Furnica(mediator, "Furnica1")
    val furnica2 = Furnica(mediator, "Furnica2")
    val furnica3 = Furnica(mediator, "Furnica3")

    mediator.adaugaFurnica(furnica1)
    mediator.adaugaFurnica(furnica2)
    mediator.adaugaFurnica(furnica3)

    launch{
        furnica1.send("mi-e foame")
    }

    launch{
        furnica2.send("ajutor")
    }

    launch{
        furnica3.send("am gasit mancare")
    }

    launch{
        furnica1.send("distractie placuta")
    }

}