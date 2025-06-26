class Outer{
    //static class StaticNested{}
    class Inner{}
}
//clase "nested"
class BasicGraph(val name:String){
    class Line(val x1:Int,val y1:Int,val x2:Int, val y2:Int){
        fun draw():Unit{
            println("Drawing Line from($x1:$y1) to ($x2,$y2)")
        }
    }
    fun draw():Unit{
        println("drawing the graph $name")
    }
}

/*fun main(args:Array<String>){
    val line=BasicGraph.Line(1,0,-2,0)
    val name=BasicGraph("Ceva")
    name.draw()
    line.draw()
}*/