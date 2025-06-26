class Decorator:
    def addDecorabil(self, mamifer):
        self.decorat = mamifer

    def interactiune(self):
        pass


class Mamifer:
    pass


class AnimalDeCompanie(Mamifer):
    pass


class Caine(AnimalDeCompanie):
    def __init__(self):
        print("Ham!")


class Pisica(AnimalDeCompanie):
    def __init__(self):
        print("Meow!")


class Femeie(Mamifer, Decorator):
    def __init__(self):
        self.animal = AnimalDeCompanie()
        print("Am creat o femeie.")

    def amAnimal(self, animal):
        self.animal = animal

    def interactiune(self):
        if isinstance(self.decorat, Om):
            print("Femeie interactiune cu Om")


class Om(Mamifer):
    def __init__(self):
        self.animal = AnimalDeCompanie()
        print("Am creat un om.")

    def amAnimal(self, animal):
        self.animal = animal


def main():

    femeie = Femeie()
    femeie.amAnimal(Caine())
    femeie.addDecorabil(Om())
    femeie.interactiune()


if __name__ == '__main__':
    main()