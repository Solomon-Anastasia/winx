class CloneFactory {
    fun makeClone(type : Animal) : Animal {
        return type.makeCopy()
    }
}