package Handlers

import Alerta
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.nio.channels.ClosedChannelException
import java.security.InvalidParameterException

class Politie(val next:Channel<Alerta>, val prev:Channel<Alerta>):Handler {
    override suspend fun handleRequests(): Unit = runBlocking {
        val tasks=listOf(launch { handleFromPrev() }, launch { handleFromNext() })
        tasks.forEach { it.join() }
    }

    override suspend fun handleFromPrev() {
        try {
            while(true)
            {
                val alert=prev.receive()
                if(alert.niv_alerta !in 0..4)
                    throw InvalidParameterException("Nivel alerta invalid!")
                if(alert.niv_emitere==null)
                    alert.niv_emitere=4
                if(alert.niv_alerta==4)
                {
                    println("Politie: ${alert.mes}")
                    prev??????????????????????????????????????????????????????????????????????????????????????????????????????

                }
                else
                {
                    next.send(alert)
                }
            }
        }catch(e:ClosedChannelException){}

    }

    override suspend fun handleFromNext() {
        try{
            while(true)
            {
                val alert=next.receive()
                if(alert.niv_emitere==null || alert.niv_emitere != 5)
                    throw InvalidParameterException("Nivel emitere invalid!")
                print("Actiune comunitari:")
                alert.comanda()
            }
        }catch(e:ClosedChannelException){}
    }
}