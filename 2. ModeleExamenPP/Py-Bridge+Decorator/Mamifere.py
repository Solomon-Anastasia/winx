from abc import ABCMeta, abstractmethod


class MamiferAbstraction(metaclass=ABCMeta):
    def __init__(self, implementation):
        self._implementation = implementation

    @abstractmethod
    def speak(self):
        pass

    @abstractmethod
    def preffered_food(self):
        pass


class Mamifer(MamiferAbstraction):
    def __init__(self, implementation):
        super().__init__(implementation)

    def speak(self):
        self._implementation.speak()

    def preffered_food(self):
        self._implementation.preffered_food()


class MamiferImplementation(metaclass=ABCMeta):
    @abstractmethod
    def speak(self):
        pass

    @abstractmethod
    def preffered_food(self):
        pass


class Femeie(MamiferImplementation):
    def speak(self):
        print("Vorbeste cu voce de femeie.")

    def preffered_food(self):
        print("Caviar")


# Am pus clasa barbat in loc de clasa om deoarece mi se pare cam ciudat sa ai ca si clase frati clasele Femeie si Om...
class Barbat(MamiferImplementation):
    def speak(self):
        print("Vorbeste cu voce de barbat.")

    def preffered_food(self):
        print("Mici")


class Caine(MamiferImplementation):
    def speak(self):
        print("Ham ham.")

    def preffered_food(self):
        print("Carne")


class Pisica(MamiferImplementation):
    def speak(self):
        print("Miau miau.")

    def preffered_food(self):
        print("Peste")
