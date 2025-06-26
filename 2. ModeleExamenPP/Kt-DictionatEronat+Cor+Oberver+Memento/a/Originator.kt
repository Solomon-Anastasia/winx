abstract class Originator{
    private var state= arrayListOf<String>()
    fun addWord(word:String){state.add(word)}
    fun saveState()=Memento(Pair(state.size-1,state.last()))
    fun restoreState(memento: Memento){state[memento.getState().first]=memento.getState().second}
    fun getWords()=state
}