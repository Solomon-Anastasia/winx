//Parametri alias

typealias Kg=Double
typealias cm =Int

data class ClientBanca(val numeFamilie: String,
                       val numeMijlociu:String,
                       val numeMic:String,
                       val seriePasaport:String,
                       val greutate:Kg,
                       val inaltime:cm,
                       val semneParticulare:String)
fun main(args:Array<String>){
    val client1 =ClientBanca("Mike","Mouse","Rabbit","XX234837447",82.3,180,"nu are")
    val client2=ClientBanca(numeMic="Rabbit",
        numeMijlociu="Mouse",
        numeFamilie="Mike",
        seriePasaport="xe4244rf33333",
        greutate=100.0,
        inaltime=180,
        semneParticulare="nu are")
    print("\n${client1}")
    print("\n${client2}")
}