//Monade
sealed class TipSimplu<out T>{
    object None:TipSimplu<Nothing>(){
        override fun toString()="None"
    }
    data class Some<out T>(val value:T):TipSimplu<T>()
    companion object
}
fun<T,R>TipSimplu<T>.flatMap(fm:(T) -> TipSimplu<R>):TipSimplu<R> =when (this){
    TipSimplu.None ->TipSimplu.None
    is TipSimplu.Some ->fm(value)
}
fun main(args: Array<String>){
    val poatePatru =TipSimplu.Some(4)
    val poateSapte =TipSimplu.Some(7)
    println(poatePatru.flatMap{f->poateSapte.flatMap{t->TipSimplu.Some(f+t)}})
}