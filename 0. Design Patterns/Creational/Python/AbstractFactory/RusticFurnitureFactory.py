from AbstractFactory import AbstractFactory
from RusticChair import RusticChair
from RusticTable import RusticTable


class RusticFurnitureFactory(AbstractFactory):
    def __init__(self):
        print("Fabrica de mobila rustica creata")

    def create_chair(self):
        return RusticChair("Scaun rustic", 200, "Hannibal")

    def create_table(self):
        return RusticTable("Masa rustica", 600, "Yesman")
