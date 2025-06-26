#Modelul Pod
class DrawingAPIOne:
    def drawCircle(self,x,y,radius):
        print("API 1 deseneaza un cerc la({},{}) cu raza {}".format(x,y,radius))
class DrawingAPITwo:
    def drawCircle(self,x,y,radius):
        print("API 2 deseneaza un cerc la ({},{}) cu raza {}".format(x,y,radius))
class Circle:
    def __init__(self,x,y,radius,drawingAPI):
        self._x=x
        self._y=y
        self._radius=radius
        self._drawingAPI=drawingAPI
    def draw(self):
        self._drawingAPI.drawCircle(self._x,self._y,self._radius)
    def scale(self,percent):
        self._radius*=percent

circle1=Circle(0,0,2,DrawingAPIOne())
circle1.draw()
circle2=Circle(1,3,3,DrawingAPITwo())
circle2.draw()