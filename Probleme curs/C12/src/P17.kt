//Aplicative
infix inline fun <A,reified B>Array<(A) -> B>.aplicatAsupraLui(a: Array<A>)=Array(this.size *a.size){
    this[it/a.size](a[it%a.size])
}
fun main(args:Array<String>){
    val tablou=arrayOf<(Int)->Int>({it+3},{it*2})aplicatAsupraLui arrayOf(1,2,3)
    println("[${tablou.joinToString()}")
}