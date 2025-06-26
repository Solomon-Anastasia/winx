#Modelul fabrica de obiecte
import abc
class Shape(metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def draw(self):
        pass
class Color(metaclass =abc.ABCMeta):
    @abc.abstractmethod
    def fill(self):
        pass
class AbstractFactory(metaclass =abc.ABCMeta):
    @abc.abstractmethod
    def get_color(self):
        pass
    @abc.abstractmethod
    def get_shape(self):
        pass
class Rectangle(Shape):
    def draw(self):
        print("Inside Rectangle: draw() method.")
class Square(Shape):
    def draw(self):
        print("Inside Square: draw() method.")
class Circle(Shape):
    def draw(self):
        print("Inside Circle: draw() method.")
class Red(Color):
    def fill(self):
        print("Inside Red: fill() method.")
class Green(Color):
    def fill(self):
        print("Inside Green: fill() method.")
class Blue(Color):
    def fill(self):
        print("Inside Blue: fill() method.")
class FactoryProducer:
    @staticmethod
    def get_factory(choice):
        if choice =="SHAPE":
            return ShapeFactory()
        elif choice =="COLOR"
            return ColorFactory()
        return None

if __name__=='__main__':
    shape_factory = FactoryProducer.get_factory("SHAPE")
    shape1=shape_factory.get_shape("CIRCLE")
    shape1.draw()
    shape2 = shape_factory.get_shape("RECTANGLE")
    shape2.draw()
    shape3 = shape_factory.get_shape("SQUARE")
    shape3.draw()
    color_factory = FactoryProducer.get_factory("COLOR")
    color1 =color_factory.get_color("RED")
    color1.fill()
    color2 = color_factory.get_color("GREEN")
    color2.fill()
    color3 = color_factory.get_color("BLUE")
    color3.fill()