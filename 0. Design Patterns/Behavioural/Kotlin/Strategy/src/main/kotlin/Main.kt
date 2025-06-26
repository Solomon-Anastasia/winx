fun main() {
    val strtegieBuna = Learning2040()
    val strtegieRea = Learning4020()
    val examen = Examen()

    examen.setStrategy(strtegieBuna)
    examen.learnBro()
    val score1 = examen.score

    examen.setStrategy(strtegieRea)
    examen.learnBro()
    val score2 = examen.score

    if (score1 >= score2)
        println("E mai bine sa stai degeaba")
    else
        println("E mai bine sa inveti. Said nobody ever")
}