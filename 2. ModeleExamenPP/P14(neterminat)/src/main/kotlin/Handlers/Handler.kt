package Handlers

import Alerta

interface Handler {
    suspend fun handleRequests()
    suspend fun handleFromPrev()
    suspend fun handleFromNext()
}