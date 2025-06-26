//Efecte laterale

class operatiiAritmetice{
    var nr1:Int=0
    var nr2:Int=0
    fun suma(nr1:Int=this.nr1,nr2:Int=this.nr2):Int{
        this.nr1=nr1
        this.nr2=nr2
        return nr1+nr2
    }
}
fun main(args:Array<String>){
    var nr1=10
    var nr2=15
    val obCalcul=operatiiAritmetice()
    println("Suma dintre ${nr1} si ${nr2} este ${obCalcul.suma(nr1,nr2)}")
}

///////////////////////////////////

class functionalOperatiiAritmetice{
    val sumaf:(Int,Int) ->Int={x,y->x+y}
    fun executaOperatia(x:Int,y:Int,op:(Int,Int)->Int):Int=op(x,y)
}

fun main(args:Array<String>){
    var nr1=10
    var nr2=15
    val obCalcul=functionalOperatiiAritmetice()
    println("Suma dintre ${nr1} si ${nr2} este ${obCalcul.executaOperatia(nr1,nr2,obCalcul.sumaf)}")

}