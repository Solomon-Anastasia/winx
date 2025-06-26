//clase nested
class basicGraphWithInner(graphName:String){
    private val name:String
        init{name=graphName}
    inner class InnerLine(val x1:Int,val y1:Int,val x2:Int,val y2:Int){
        fun draw():Unit{
            println("Drawing Line from ($x1,$y1) to ($x2,$y2) for graph $name")
        }
    }
    fun draw():Unit{println("Drawing the graph $name")}
}

class A{
    private val somefield:Int=1
    inner class B{
        private val somefield:Int=1
        fun foo(s:String){
            println("Field <somefield> from B"+this.somefield)
            println("Field <somefield> from b"+this@B.somefield)
            println("field <somefield> from A"+this@A.somefield)
        }
    }
}

/*fun main(args:Array<String>){
    basicGraphWithInner("Something")
    //A.B.foo("Something")  //Nu merge...
}*/