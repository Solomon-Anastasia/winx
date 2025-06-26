import tkinter as tk
from abc import ABC, abstractmethod


# --- Shape Interface ---
class Shape(ABC):
    @abstractmethod
    def draw(self, canvas):
        pass


# --- Concrete Shapes ---
class Square(Shape):
    def draw(self, canvas):
        canvas.create_rectangle(50, 50, 150, 150, fill="red")
        print("Drawing square")


class Rectangle(Shape):
    def draw(self, canvas):
        canvas.create_rectangle(200, 50, 350, 150, fill="green")
        print("Drawing rectangle")


class Circle(Shape):
    def draw(self, canvas):
        canvas.create_oval(400, 50, 500, 150, fill="blue")
        print("Drawing circle")


# --- Abstract Factory ---
class ShapeFactory(ABC):
    @abstractmethod
    def create_shape(self, shape_type: str) -> Shape:
        pass


# --- Concrete Factory ---
class BasicShapeFactory(ShapeFactory):
    def create_shape(self, shape_type: str) -> Shape:
        shape_type = shape_type.lower()
        if shape_type == "square":
            return Square()
        elif shape_type == "rectangle":
            return Rectangle()
        elif shape_type == "circle":
            return Circle()
        else:
            raise ValueError(f"Unknown shape type: {shape_type}")


# --- Factory of Factories ---
class FactoryProducer:
    @staticmethod
    def get_factory(factory_type: str) -> ShapeFactory:
        if factory_type.lower() == "basic":
            return BasicShapeFactory()
        else:
            raise ValueError("Unknown factory type")


# --- Application ---
def main():
    window = tk.Tk()
    window.title("Shape Drawer")
    canvas = tk.Canvas(window, width=600, height=250, bg="white")
    canvas.pack()

    # Factory of factories
    factory = FactoryProducer.get_factory("basic")
    for shape_name in ["square", "rectangle", "circle",]:
        shape = factory.create_shape(shape_name)
        shape.draw(canvas)

    window.mainloop()


if __name__ == "__main__":
    main()
