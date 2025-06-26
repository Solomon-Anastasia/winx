fun main() {
    val mioara = Sheep(2)

    val fabricaClone = CloneFactory()

    val mioara2 = fabricaClone.makeClone(mioara)

    println("Mioara: $mioara Hash: ${System.identityHashCode(mioara)}")
    println("Mioara2: $mioara2 Hash: ${System.identityHashCode(mioara2)}")
}