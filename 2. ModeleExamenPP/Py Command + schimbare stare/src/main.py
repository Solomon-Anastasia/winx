from enum import Enum


class Stari(Enum):
    FERICIT = 1
    DISPERAT = 2
    MORT = 3
    STIE_POPA_CA_UMBLI_DEZGROPAT = 4


class Command:
    def execute(self, student):
        pass


class Bucurie(Command):
    def execute(self, student):
        student.stareSufleteasca(Stari.FERICIT)


class Dispera(Command):
    def execute(self, student):
        student.stareSufleteasca(Stari.DISPERAT)


class Rupe(Command):
    def execute(self, student):
        student.stareSufleteasca(Stari.MORT)


class Maxima(Command):
    def execute(self, student):
        student.stareSufleteasca(Stari.STIE_POPA_CA_UMBLI_DEZGROPAT)


class Student:
    def __init__(self):
        self.stare = Stari.FERICIT

    def stareSufleteasca(self, stare):
        self.stare = stare

    def printStare(self):
        print("Saracul student se simte: " + self.stare.name)


class Colega:
    def __init__(self, baiat):
        self.student = baiat
        self.comanda = Bucurie()

    def setComanda(self,comanda):
        self.comanda = comanda

    def executa(self):
        self.comanda.execute(self.student)


def main():
    un_student = Student()
    o_colega = Colega(un_student)

    o_colega.setComanda(Dispera())
    o_colega.executa()
    un_student.printStare()

    o_colega.setComanda(Rupe())
    o_colega.executa()
    un_student.printStare()

    o_colega.setComanda(Maxima())
    o_colega.executa()
    un_student.printStare()


if __name__ == '__main__':
    main()