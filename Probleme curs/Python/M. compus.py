import abc
class Shapes(metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def draw(self,color): pass
class Triangle(Shapes):
    def draw(self,color):
        print("Desenez un triunghi cu culoarea " +color)
class Circle(Shapes):
    def draw(self,color):
        print("Desenez un cerc cu culoarea " +color)
class Drawing(Shapes):
    def __init__(self):
        self.shapes=[]
    def draw(self,color):
        for sh in self.shapes:
            sh.draw(color)
    def add(self,sh):
        self.shapes.append(sh)
    def remove(self,sh):
        self.shapes.remove(sh)
    def clear(self):
        print("Sterg toate formele din desen")
        self.shapes=[]

if __name__ =='__main__':
    tri1=Triangle()
    tri2=Triangle()
    cir=Circle()

    drawing =Drawing()
    drawing.add(tri1)
    drawing.add(tri2)
    drawing.add(cir)

    drawing.draw("rosu")

    drawing.clear()

    drawing.add(tri1)
    drawing.add(cir)
    drawing.draw("verde")