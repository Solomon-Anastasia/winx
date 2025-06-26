import datetime


class Hacker(Exception):
    pass


class Observator:
    def primesteRata(self, rata):
        raise NotImplemented


class Pret(Observator):
    def __init__(self, initial):
        self.initial = initial

    def primesteRata(self, rata):
        self.initial = self.initial - ((rata * self.initial) / 100)
        return self.initial


class Dispatcher:
    def __init__(self):
        self.observatori = []
        self.logger = Logger("Log.txt")

    def addObs(self, obs):
        self.observatori.append(obs)

    def removeObs(self, obs):
        self.observatori.remove(obs)

    def trimiteNouaRata(self, rata, user):
        for obs in self.observatori:
            pretNou = obs.primesteRata(rata)
            self.logger.log(user.user, rata, pretNou)


class Cont:
    def __init__(self, user, parola):
        self.user = user
        self.parola = parola


class Service:
    def operatie(self):
        raise NotImplemented


class IntroducereRata(Service):
    def operatie(self):
        return int(input('Rata noua:  '))


class Proxy(Service):
    def __init__(self):
        self.service = None
        self.cont = None
        self.dispatcher = Dispatcher()

    def operatie(self):
        return self.service.operatie()

    def checkAcces(self):
        self.service = Logare()
        if self.cont is None:
            self.cont = self.operatie()
            self.dispatcher.addObs(Pret(int(input('Pret initial: '))))
        else:
            nouBaiat: Cont = self.operatie()
            if not (nouBaiat.user == self.cont.user and nouBaiat.parola == self.cont.parola):
                print("Hacker-ul naibii...iesi afara!")
                raise Hacker
            else:
                self.service = IntroducereRata()
                rata = self.operatie()
                self.dispatcher.trimiteNouaRata(rata, self.cont)


class Logare(Service):
    def operatie(self):
        return Cont(str(input('User: ')), str(input('Parola: ')))


class Logger:
    def __init__(self, fila):
        self.fisier = open(fila, 'a')

    def close(self):
        self.fisier.close()

    def log(self, user, rata, pret):
        self.fisier.write(
            'User-ul ' + user + ' la ' + str(
                datetime.datetime.now()) + ' a modificat pretul cu rata de ' + str(rata) + '%, noul pret devenind: ' + str(pret) + '\n')


def main():
    proxy = Proxy()
    while True:
        proxy.checkAcces()


if __name__ == '__main__':
    main()