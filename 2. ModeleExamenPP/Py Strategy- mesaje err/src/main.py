import sys


class Warning(Exception):
    pass


class Error(Exception):
    pass


class GraveError(Exception):
    pass


class Strategie:
    file = None
    fileGrav = None
    fileWarning = None

    @classmethod
    def fisiereDeschidere(cls):
        fisier_de_log = "Erori.txt"
        cls.file = open(fisier_de_log, "w")
        fisier_de_log_rau = "EroriGrave.txt"
        cls.fileGrav = open(fisier_de_log_rau, "w")
        fisier_de_log_mai_bun = "Warning.txt"
        cls.fileWarning = open(fisier_de_log_mai_bun, "w")

    def handleError(self):
        pass

    @classmethod
    def inchidereFisierCaEAcademic(cls):
        cls.file.close()
        cls.fileGrav.close()
        cls.fileWarning.close()


class StrategieEroareGrava(Strategie):

    def handleError(self):
        self.fileGrav.write("Chiar a aparut o eroare grava!\n")
        Strategie.inchidereFisierCaEAcademic()
        sys.exit()


class StrategieEroare(Strategie):

    def handleError(self):
        print("A aparut o eroare!")
        self.file.write("Chiar a aparut o eroare!\n")


class StrategieWarning(Strategie):

    def handleError(self):
        self.fileWarning.write("Ai picat la PC ca ai warning!\n")


class Handler:
    def __init__(self):
        self.strategie = Strategie()
        Strategie.fisiereDeschidere()

    def setareStrategie(self, strategie):
        self.strategie = strategie

    def gestionam(self):
        self.strategie.handleError()


def main():
    handler = Handler()

    while True:
        print("Ce eroare vrei?")
        print("  0 - Grava")
        print("  1 - Normala")
        print("  2 - Doar Warning")
        opt = int(input(""))
        try:
            if opt == 0:
                raise GraveError
            elif opt == 1:
                raise Error
            else:
                raise Warning
        except GraveError:
            handler.setareStrategie(StrategieEroareGrava())
            handler.gestionam()
        except Error:
            handler.setareStrategie(StrategieEroare())
            handler.gestionam()
        except Warning:
            handler.setareStrategie(StrategieWarning())
            handler.gestionam()


if __name__ == '__main__':
    main()