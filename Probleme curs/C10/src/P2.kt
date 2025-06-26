import javafx.application.Application.launch

//Creare diverse tipuri de thread

fun main() =runBlocking<Unit>{
    launch{
        println("Corutina principala runBloking : Sunt in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined){
        println("Independenta :Sunt in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default){
        println("Implicita :Sunt in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("Threadul Meu")){
        println("newSingleThreadContext :Sunt in thread ${Thread.currentThread().name}")
    }
}