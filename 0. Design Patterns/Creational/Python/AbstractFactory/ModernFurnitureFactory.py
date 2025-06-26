from AbstractFactory import AbstractFactory
from ModernChair import ModernChair
from ModernTable import ModernTable


class ModernFurnitureFactory(AbstractFactory):
    def __init__(self):
        print("Fabrica de mobila moderna creata")

    def create_chair(self):
        return ModernChair("Scaun modern", 100, "Genghis")

    def create_table(self):
        return ModernTable("Masa moderna", 300, "Han")