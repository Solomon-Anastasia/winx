import abc
from tkinter import *


class Displayer(Frame):
    def __init__(self, root, **kw):
        super().__init__(**kw)
        self.root = root
        self.canvas = Canvas(root)


class Factory_Default(metaclass=abc.ABCMeta): # AbstractFactory (interface) (Fabrica de fabrici)

    @abc.abstractmethod
    def UIdisplay(self):
        pass


class Factory1_English(Factory_Default): # FabricaMica1
    def __init__(self, name):
        self.name = name

    def UIdisplay(self):
        print(self.name)
        self.root = Tk()
        self.root.title("english factory")
        self.disp = Displayer(self.root)
        self.disp.button = Button(self.root, text="Button one", padx=20, pady=20).grid(row=0, column=1)
        self.disp.button = Button(self.root, text="Button two", padx=20, pady=20).grid(row=0, column=2)
        self.disp.button = Button(self.root, text="Button three", padx=20, pady=20).grid(row=0, column=3)
        self.root.mainloop()


class Factory2_Romanian(Factory_Default): # FabricaMica2
    def __init__(self, name):
        self.name = name

    def UIdisplay(self):
        print(self.name)
        self.root = Tk()
        self.root.title("fabrica romaneasca")
        self.disp = Displayer(self.root)
        self.disp.button = Button(self.root, text="Buton unu", padx=20, pady=20).grid(row=0, column=1)
        self.disp.button = Button(self.root, text="Buton doi", padx=20, pady=20).grid(row=0, column=2)
        self.disp.button = Button(self.root, text="Buton trei", padx=20, pady=20).grid(row=0, column=3)
        self.root.mainloop()


class LanguageFactory: # FabricaMare
    def createFactory(self, name):
        if name == 'english':
            return Factory1_English(name)
        elif name == 'romanian':
            return Factory2_Romanian(name)


def main():

    FabricaMare = LanguageFactory()
    type = input("introduce ui language romanian/english\n")

    FabricaMica = FabricaMare.createFactory(type)

    FabricaMica.UIdisplay()


if __name__ == '__main__':
    main()