class Subject:Originator() {
    protected val observers= arrayListOf<Observer>()
    fun register(observer:Observer){observers+=observer}
    fun unregister(observer: Observer){observers-=observer}
    fun notifyAll(word:String){observers.forEach{it.update(word)}}
}