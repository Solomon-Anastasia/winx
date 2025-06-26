from abc import ABC, abstractmethod
from functional import seq


class Command(ABC):
    def execute(self):
        pass


class Receiver:
    def run1(self, stateMachine, myList):
        firstAppearence = -1
        deletedElement = myList[0]
        for index, elem in enumerate(myList):
            if elem % 2 == 0:
                firstAppearence = index
                deletedElement = elem
                break

        if firstAppearence != -1:
            # myList2 = list(filter(lambda x: x != deletedElement, myList))
            # print(myList2)
            myList.pop(firstAppearence)
            print("Elementul sters:" + str(deletedElement))
        else:
            print("Nu s-a sters nimic")

        stateMachine.setList(myList)

    def run2(self, stateMachine, myList):
        firstAppearence = -1
        deletedElement = myList[0]
        for index, elem in enumerate(myList):
            if elem % 2 == 1:
                firstAppearence = index
                deletedElement = elem
                break

        if firstAppearence != -1:
            #myList2 = list(filter(lambda x: x != deletedElement, myList))
            #print(myList2)
            myList.pop(firstAppearence)
            print("Elementul sters:" + str(deletedElement))
        else:
            print("Nu s-a sters nimic")
        # print(myList)

        stateMachine.setList(myList)


class Command1(Command):
    def __init__(self, receiver, stateMachine):
        self.__stateMachine = stateMachine
        self.__myList = stateMachine.getList()
        self.__receiver = receiver

    def execute(self):
        self.__receiver.run1(self.__stateMachine, self.__myList)
        self.__myList = self.__stateMachine.getList()


class Command2(Command):
    def __init__(self, receiver, stateMachine):
        self.__stateMachine = stateMachine
        self.__myList = stateMachine.getList()
        self.__receiver = receiver

    def execute(self):
        self.__receiver.run2(self.__stateMachine, self.__myList)
        self.__myList = self.__stateMachine.getList()


class Invoker:

    def __init__(self):
        self.__commands = {}

    def addCommand(self, name, command):
        self.__commands[name] = command

    def executeCommand(self, name):
        if name in self.__commands.keys():
            self.__commands[name].execute()
        else:
            print(f"Command [{name}] not recognised")


class StateMachine:
    def __init__(self, list):
        self.__currentState = None
        self.__myList = list
        self.__stateList = {}

    def addState(self, name, state):
        self.__stateList[name] = state

    def setCurrentState(self, name):
        self.__currentState = self.__stateList[name]

    def getList(self):
        return self.__myList

    def setList(self, list):
        self.__myList = list

    def getStateList(self):
        return self.__stateList

    def setState(self, state):
        self.__currentState = state

    def run(self):
        self.__currentState.handle(self, self.__myList)


class State(ABC):
    __invoker = None

    def handle(self, stateMachine, list):
        pass


class State0(State):
    def __init__(self, invoker):
        self.__invoker = invoker

    def handle(self, stateMachine, list):
        if len(list) == 0:
            print("Sunt in State0: S-a terminat procesarea")
            exit(0)
        else:
            print("Sunt in State0")
            # print(list)
            stateList = stateMachine.getStateList()
            stateMachine.setState(stateList["S1"])
            stateMachine.run()


class State1(State):
    def __init__(self, invoker):
        self.__invoker = invoker

    def handle(self, stateMachine, myList):
        print("Sunt in State1")

        invoker.executeCommand(1)

        stateList = stateMachine.getStateList()
        stateMachine.setState(stateList["S2"])
        stateMachine.run()


class State2(State):
    def __init__(self, invoker):
        self.__invoker = invoker

    def handle(self, stateMachine, myList):
        print("Sunt in State2")

        invoker.executeCommand(2)

        stateList = stateMachine.getStateList()
        stateMachine.setState(stateList["S0"])
        stateMachine.run()


if __name__ == "__main__":
    myList = [1, 2, 3, 4, 5]
    stateMachine = StateMachine(myList)

    invoker = Invoker()
    receiver = Receiver()
    command1 = Command1(receiver, stateMachine)
    command2 = Command2(receiver, stateMachine)
    invoker.addCommand(1, command1)
    invoker.addCommand(2, command2)

    state0 = State0(invoker)
    state1 = State1(invoker)
    state2 = State2(invoker)
    stateMachine.addState("S0", state0)
    stateMachine.addState("S1", state1)
    stateMachine.addState("S2", state2)
    stateMachine.setCurrentState("S0")
    stateMachine.run()
