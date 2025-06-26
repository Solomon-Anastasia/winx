import abc


class Handler(metaclass=abc.ABCMeta):
    def __init__(self, successor=None):
        self.succesor = successor

    def handle(self, request):
        res = self.check_alertlevel(request)
        if not res and self.succesor:
            self.succesor.handle(request)

    @abc.abstractmethod
    def check_alertlevel(self, request):
        """verificam nivelul  de alerta"""


class NATOHandler(Handler):
    @staticmethod
    def check_alertlevel(request):
        if request.find('0') != -1:
            print("cererea {} tratata la NATO".format(request))
            return True
        else:
            return False


class CSATHandler(Handler):
    def check_alertlevel(self, request):
        if request.find('1') != -1:
            print("cererea {} tratata la CSAT".format(request))
            return True
        else:
            return False


class SIEHandler(Handler):
    def check_alertlevel(self, request):
        if request.find('2') != -1:
            print("cererea {} tratata la SIE".format(request))
            return True
        else:
            return False


class SRIHandler(Handler):
    def check_alertlevel(self, request):
        if request.find('3') != -1:
            print("cererea {} tratata la SRI".format(request))
            return True
        else:
            return False


class PoliceHandler(Handler):
    def check_alertlevel(self, request):
        if request.find('4') != -1:
            print("cererea {} tratata la Politie".format(request))
            return True
        else:
            return False


class GuardHandler(Handler):
    def check_alertlevel(self, request):
        if request.find('5') != -1:
            print("cererea {} tratata la paznicii muzeului".format(request))
            return True
        else:
            return False


class FallbackHandler(Handler):
    @staticmethod
    def check_alertlevel(request):
        print("Am terminat de parcurs lantul - nu exista tratare pt cazul {}".format(request))
        return False


def main():
    hg = GuardHandler()  # creez gestionari
    hp = PoliceHandler()
    hsri = SRIHandler()
    hsie = SIEHandler()
    hcsat = CSATHandler()
    hnato = NATOHandler(FallbackHandler())

    hg.succesor = hp  # creez lantul
    hp.succesor = hsri
    hsri.succesor = hsie
    hsie.succesor = hcsat
    hcsat.succesor = hnato

    requests = [
        "Sun la 4 ca mi s-a furat masina!",
        "Tre sa zic la 0 ca Rusia ne ataca",
        "Esti 3-ist frate!",
        "Suna la 5 ca s-a spart vasul din vitrina!",
        "1 nu faci nimic?",
        "Ca si sri tu esti 2 nu?",
    ]
    for request in requests:
        hg.handle(request)


if __name__ == '__main__':
    main()
