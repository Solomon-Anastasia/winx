from tkinter import Tk, Canvas, Frame, BOTH
import math


class Color:
    def __init__(self, c):
        self.val = c


class Shape:
    color = Color('#000')

    def draw(self, canvas):
        pass


class Displayer(Frame):
    def __init__(self, root, **kw):
        super().__init__(**kw)
        self.root = root
        self.canvas = Canvas(root)
        self.shape = Shape()

    def addShape(self, shape):
        self.shape = shape

    def drawShape(self):
        self.shape.draw(self.canvas)


class Rectangle(Shape):
    def __init__(self, top_left, bottom_right, color):
        self.top_left = top_left
        self.bottom_right = bottom_right
        self.color = color

    def draw(self, canvas):
        canvas.create_rectangle(self.top_left[0], self.top_left[1], self.bottom_right[0], self.bottom_right[1],
                                fill=self.color.val)
        canvas.pack(fill=BOTH, expand=1)


class Triangle(Shape):
    def __init__(self, l1, l2, l3, color):
        self.l1 = l1
        self.l2 = l2
        self.l3 = l3
        self.color = color

    def draw(self, canvas):
        canvas.create_polygon(self.l1[0], self.l1[1], self.l2[0], self.l2[1], self.l3[0], self.l3[1],
                              fill=self.color.val)
        canvas.pack(fill=BOTH, expand=1)

    def expand(self, times):
        self.l1 = self.l1 * times
        self.l2 = self.l2 * times
        self.l3 = self.l3 * times


class Circle(Shape):
    def __init__(self, center, radius, color):
        self.radius = radius
        self.center = center
        self.color = color

    def draw(self, canvas):
        canvas.create_oval(self.center[0] - self.radius * math.sqrt(2), self.center[1] - self.radius * math.sqrt(2),
                           self.center[0] + self.radius * math.sqrt(2), self.center[1] + self.radius * math.sqrt(2),
                           fill=self.color.val)
        canvas.pack(fill=BOTH, expand=1)

    def expand(self, times):
        self.radius = self.radius * times


def main():
    root = Tk()
    root.title("cod maimuta")
    displayer = Displayer(root)

    displayer.addShape(Rectangle((10, 10), (50, 50), Color('#ff6')))
    displayer.drawShape()

    displayer.addShape(Triangle((20, 30), (75, 95), (100, 32), Color('#461')))
    displayer.drawShape()

    displayer.addShape(Circle((200, 200), 20, Color('#2f6')))
    displayer.drawShape()

    root.mainloop()


if __name__ == '__main__':
    main()