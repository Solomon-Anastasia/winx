def search(list, element):
    for i in range(len(list)):
        if list[i] == element:
            return i
    return 0


# This is simply a container of the state
class Memento():
    def __init__(self, myList):
        self.myList = myList


# The object whose state changes
class Originator():
    def __init__(self, myList):
        self.__myList = myList

    def getList(self):
        return self.__myList

    def setList(self, otherList):
        self.__myList = otherList

    # returneaza starea actuala sub forma unui memento
    def memento(self):
        return Memento(self.__myList)


class CareTaker():
    def __init__(self, originator):
        self.__originator = originator
        self.__mementos = []

    def addMemento(self):
        newMemento = self.__originator.memento()
        self.__mementos.append(newMemento)

    def restore(self, index):
        oldMemento = self.__mementos[index]
        self.__originator.setList(oldMemento.myList)


if __name__ == "__main__":
    with open("input.txt") as f:
        content = f.read()
        words = content.split(" ")
        numbers = list(map(lambda x: int(x), words))

        originator = Originator(numbers)
        careTaker = CareTaker(originator)
        careTaker.addMemento()

        print("Lista initiala: ", end="")
        print(originator.getList())

        transformedList1 = list(map(lambda x: (x + 1) if x % 2 == 0 else x, originator.getList()))
        originator.setList(transformedList1)
        careTaker.addMemento()

        print("Lista dupa prima transformare: ", end="")
        print(originator.getList())

        raspuns = input("Doresti sa revii la vechea lista? 1 - DA, 0 - NU\n")
        if raspuns == "1":
            careTaker.restore(0)
        print("Lista la momentul actual: " + str(originator.getList()))

        transformedList2 = list(map(lambda x: 3 * x ** 2 - 2 * x + 1, originator.getList()))
        originator.setList(transformedList2)
        careTaker.addMemento()

        print("Lista dupa a doua transformare: ", end="")
        print(originator.getList())

        raspuns = input("Doresti sa revii la vechea lista? 1 - DA, 0 - NU\n")
        if raspuns == "1":
            careTaker.restore(1)
        print("Lista la momentul actual: " + str(originator.getList()))

        transform3 = lambda x: x * search(originator.getList(), x) + x * search(originator.getList(), x) + 1
        transformedList3 = list(map(transform3, originator.getList()))
        originator.setList(transformedList3)
        careTaker.addMemento()

        print("Lista dupa a treia transformare: ", end="")
        print(originator.getList())

        raspuns = input("Doresti sa revii la vechea lista? 1 - DA, 0 - NU\n")
        if raspuns == "1":
            careTaker.restore(2)
        print("Lista la momentul actual: " + str(originator.getList()))


