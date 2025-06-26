//Curry/Uncurry

fun<P1,P2,P3,R> Function3<P1,P2,P3,R>.curried():(P1)->(P2)->(P3)->R={p1->{p2->{p3->this(p1,p2,p3)}}}
fun<P1,P2,P3,R> ((P1)->(P2)->(P3)->R).uncurried():(P1,P2,P3)->R{
    return {f1:P1,f2:P2,f3:P3 ->this(f1)(f2)(f3)}
}
var add={x:Int,y:Int,z:Int->x+y+z}.curried()
val add1={x:Int->{y:Int->{z:Int->x+y+z}}}.uncurried()
fun main(){
    val x=add(3)(4)(5)
    val y=add1(3,4,5)
    println(x)
    println(y)
}