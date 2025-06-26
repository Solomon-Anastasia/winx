import asyncio
from enum import Enum


class Laborator:
    __objectList: list

    def __init__(self):
        self.objectList = []

    def addObject(self, obiect):
        self.objectList.append(obiect)



class Student:
    __name: str
    __laborator: Laborator

    def __init__(self, name, laborator):
        self.name = name
        self.laborator = laborator

    async def action(self):
        if self.laborator is not None:
            for object in self.laborator.objectList:
                if object == Object.DOOR:
                    await self.interactWithDoor()
                if object == Object.CHAIR:
                    await self.interactWithChair()
                if object == Object.TABLE:
                    await self.interactWithTable()
                if object == Object.PEN:
                    await self.interactWithPen()

        else:
            print("Studentul chiuleste.")
    async def interactWithPen(self):
            print("Studentul " + self.name + " scrie.")
    async def interactWithChair(self):
            print("Studentul " + self.name + " isi trage scaunul.")
    async def interactWithDoor(self):
            print("Studentul " + self.name + " intra.")
    async def interactWithTable(self):
        print("Studentul " + self.name + " se aseaza la masa.")




class Object(Enum):
    DOOR = 1
    TABLE = 2
    CHAIR = 3
    PEN = 4
async def main():
    PP=Laborator()
    PP.addObject(Object.CHAIR)
    PP.addObject(Object.PEN)
    Delia=Student("Delia",PP)

    PA = Laborator()
    PA.addObject(Object.DOOR)
    PA.addObject(Object.TABLE)
    PA.addObject(Object.PEN)
    Ioana = Student("Ioana", PA)

    Gabi = Student("Gabi", None)

    await asyncio.gather(Delia.action(), Ioana.action(), Gabi.action())

asyncio.run(main())

