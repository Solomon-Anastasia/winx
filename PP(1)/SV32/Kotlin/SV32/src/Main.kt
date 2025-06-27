fun main() {
    // Pasul 1 -> HashMap cu valori numerice
    val hashMap = hashMapOf(
        //cheie -> valoare
        1 to 10,
        2 to 20,
        3 to 30,
        4 to 40
    )

    // Pasul 2- > functor = lambda f(x) = 3 * x - 1, apoi conversie la String

    val transformed = hashMap.map { (key, value) ->
        val result = 3 * value - 1
        key to result.toString()
    }.toMap()

    // Pasul 3 -> Afisare rezultate

    println("Rezultatele transformate:")
    transformed.forEach{(key, value) ->
        println("Cheie $key, Valoare procesata: $value")
    }
}