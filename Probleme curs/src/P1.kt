import java.io.File
import java.io.IOException
import java.nio.file.Path

/*fun readFile(path: Path): Unit{
    val input = File.newInputStream(path)  //Nu stiu ce naiba are....
    try{
        var byte=input.read()
        while(byte!= -1){
            println(byte)
            byte=input.read()
        }
    }catch(e: IOException){
        println("Error was ${e.message}")
    }
    finally{ input.close()}
}*/

//conversia de tip
fun printStringLength(any: Any){
    if(any is String){
        println(any.length)
    }
}

//when ca switch case(cu argument)
fun whatNumber(x:Int){
    when(x){
        0 ->println("x is zero")
        1 ->println("x is 1")
        else ->println("x is neither 0 or 1")
    }
}

fun isMinOrMax(x:Int):Boolean{
    val isZero= when(x){
        Int.MIN_VALUE ->true
        Int.MAX_VALUE ->true
        else ->false
    }
    return isZero
}
fun isZeroOrOne(x:Int):Boolean{
    return when(x){
        0,1 ->true
        else ->false
    }
}
fun isSingleDigit(x:Int):Boolean{
    return when(x){
        in -9..9->true
        else ->false
    }
}
/*fun startsWithFoo(any:Any):Boolean{
    return when(any){
        isString ->any.startsWith("Foo") //Nici asta nu merge
        else ->false
    }
}*/

//when ca expresie
fun whenWithoutArgs(x:Int,y:Int){
    when{
        x<y ->println("x is less than y")
        x>y->println("x is greater than y")
        else->println("x must equal y")
    }
}

//transmiterea rezultatelor unei functii
fun largestNumber(a: Int,b:Int,c:Int):Int{
    fun largest(a:Int,b:Int):Int{
        if(a>b) return a
        else return b
    }
    return largest(largest(a,b),largest(b,c))
}

fun printUntilStop(){
    val list=listOf("a","b","stop","c")
    list.forEach stop@{
        if(it=="stop") return@stop
        else println(it)
    }
}

fun printUntilStop2(){
    val list=listOf("1","2","stop","3")
    list.forEach{
        if(it=="stop") return@forEach
        else println(it)
    }
}

/*fun main(){
    //printStringLength("Ana Bib")
    whatNumber(1)
    whatNumber(3)
    var a=isMinOrMax(1)
    println(a)
    var b=isZeroOrOne(0)
    println(b)
    var c=isSingleDigit(2)
    println(c)
    whenWithoutArgs(2,3)
    whenWithoutArgs(3,3)
    var d =largestNumber(2,3,4)
    println(d)
    printUntilStop()
    printUntilStop2()
}*/
