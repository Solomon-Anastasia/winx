//Modelul Fabrica abstracta
interface Shape{ fun draw()}
interface Color{ fun fill()}

abstract class AbstractFactory{
    abstract fun getColor(color:String):Color?
    abstract fun getShape(shape:String):Shape?
}
class ShapeFactory: AbstractFactory(){
    override fun getShape(shape: String): Shape? {
        if (shape.equals("CIRCLE",true))
            return Circle()
        if(shape.equals("RECTANGLE",true))
            return Rectangle()
        if(shape.equals("SQUARE",true))
            return Square()
        return null
    }
    override fun getColor(color:String):Color?=null
}
class ColorFactory: AbstractFactory(){
    override fun getShape(shape:String):Shape? =null
    override fun getColor(color:String):Color?{
        if(color.equals("RED",true))
            return Red()
        if(color.equals("GREEN",true))
            return Green()
        if(color.equals("BLUE",true))
            return Blue()
        return null
    }
}
object FactoryProducer{
    fun getFactory(choice:String): AbstractFactory?{
        if(choice.equals("SHAPE",true))
            return ShapeFactory()
        if(choice.equals("COLOR",true))
            return ColorFactory()
        return null
    }
}

class Circle: Shape{
    override fun draw(){
        println("Inside Circle::draw() method.")
    }
}
class Rectangle: Shape{
    override fun draw(){
        println("Inside Rectangle::draw() method.")
    }
}
class Square:Shape{
    override fun draw(){
        println("Inside Square::draw() method.")
    }
}
class Red:Color{
    override fun fill(){
        println("Inside Red::fill() method.")
    }
}
class Green: Color{
    override fun fill(){
        println("Inside Green::fill() method.")
    }
}
class Blue: Color{
    override fun fill(){
        println("Inside Blue::fill() method.")
    }
}
fun main(args: Array<String>){
    val shapeFactory= FactoryProducer.getFactory("SHAPE")
    shapeFactory?.getShape("CIRCLE")?.draw()
    shapeFactory?.getShape("RECTANGLE")?.draw()
    shapeFactory?.getShape("SQUARE")?.draw()

    val colorFactory= FactoryProducer.getFactory("COLOR")
    colorFactory?.getColor("CIRCLE")?.fill()
    colorFactory?.getColor("RECTANGLE")?.fill()
    colorFactory?.getColor("SQUARE")?.fill()
}