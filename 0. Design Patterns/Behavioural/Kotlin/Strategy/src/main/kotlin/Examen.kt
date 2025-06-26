class Examen() {
    private lateinit var strategy : LearningStrategy
    var score = 0
    fun learnBro() {
        score = strategy.takeNotes() + strategy.rest() + strategy.test()
    }

    fun setStrategy(strategy: LearningStrategy) {
        this.strategy = strategy
    }
}