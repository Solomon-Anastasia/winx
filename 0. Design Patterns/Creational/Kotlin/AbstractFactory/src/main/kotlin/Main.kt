fun getFactory(type : String) : AbstractFactory {
    if (type == "Modern")
        return ModernFactory()
    if (type == "Rustic")
        return RusticFactory()

    throw RuntimeException("Factory type not supported")
}

fun main() {
    val fabricaModerna = getFactory("Modern")

    val scaunModern = fabricaModerna.createChair("Falus Maximus", 20, "fer", "Scranciob SRL")
    val masaModerna = fabricaModerna.createTable("Falus minimus", 100, "ferus maximus", 120, "Pocahontas II")

    println(scaunModern)
    println(masaModerna)

    val fabricaRustica = RusticFactory()
    val scaunRustic = fabricaRustica.createChair("falus maximus rusticus", 30, "lemnus", "Orez SRL")
    val masaRustica = fabricaRustica.createTable("falus minimus rusticus", 200, "ferologie", 200, "Smecherius Evaziunes fiscala")

    println(scaunRustic)
    println(masaRustica)
}
