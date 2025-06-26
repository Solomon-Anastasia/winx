class Caretaker {
    private val mementoList= arrayListOf<Memento>()
    fun add(memento:Memento){mementoList+=memento}
    fun getMemento(ind:Int):Memento{return mementoList.removeAt(ind)}
    fun getNumberOfMementos()=mementoList.size
}