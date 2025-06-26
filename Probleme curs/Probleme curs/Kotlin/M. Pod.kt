//Model pod
interface DrawAPI{
    fun drawCircle(radius: Int,x:Int,y:Int)
}
abstract class Shapes(protected val drawAPI:DrawAPI){
    abstract fun draw()
}
class Circles(val x: Int,val y:Int, val radius:Int,drawAPI:DrawAPI):Shapes(drawAPI){
    override fun draw(){
        drawAPI.drawCircle(radius,x,y)
    }
}
class GreenCircle:DrawAPI{
    override fun drawCircle(radius: Int,x:Int,y:Int){
        println("Drawing Circle[color:green,radius: $radius,x: $x,y: $y")
    }
}
class RedCircle:DrawAPI{
    override fun drawCircle(radius: Int,x:Int,y:Int){
        println("Drawing Circle[color:red,radius: $radius,x: $x,y: $y")
    }
}
fun main(args: Array<String>){
    val redCircle=Circles(100,100,10,RedCircle())
    val greenCircle=Circles(100,100,10,GreenCircle())
    redCircle.draw()
    greenCircle.draw()
}