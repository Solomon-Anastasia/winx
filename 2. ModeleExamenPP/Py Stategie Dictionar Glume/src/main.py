import abc
import random


def citimGlume(text):
    bancuriBune = []
    bancuriFoarteBune = []
    bancuriCeleMaiBune = []

    default_data = { 'ok': bancuriBune,
                     'bune': bancuriFoarteBune,
                     'foartebune':bancuriCeleMaiBune
                     }

    glume = text.split("\t")
    for element in glume:
        if "***" in element:
            bancuriCeleMaiBune.append( element)
        elif "**" in element:
            bancuriFoarteBune.append( element)
        elif "*" in element:
            bancuriBune.append(element)


    #print(default_data['ok'])
    #print(default_data['bune'])
    #print(default_data['foartebune'])
    return default_data

class StrategieGlume( metaclass= abc.ABCMeta):
    @abc.abstractmethod
    def spuneGluma(self):
        pass

class StrategieGlumeOk(StrategieGlume):
    def __init__(self, _dictionar):
        self.dictionar = _dictionar

    def spuneGluma(self):
        listos = self.dictionar['ok']
        gluma = listos[random.randint(0, len(listos) - 1)]
        print(gluma)
        return gluma

class StrategieGlumeBune(StrategieGlume):
    def __init__(self, _dictionar):
        self.dictionar = _dictionar

    def spuneGluma(self):
        listos = self.dictionar['bune']
        gluma = listos[random.randint(0, len(listos) - 1)]
        print(gluma)
        return gluma

class StrategieGlumeFoarteBune(StrategieGlume):
    def __init__(self, _dictionar):
        self.dictionar = _dictionar

    def spuneGluma(self):
        listos = self.dictionar['foartebune']
        gluma = listos[random.randint(0,len(listos) -1)  ]
        print( gluma)
        return gluma

class Student():
    def __init__(self, _strategie):
        self.strategie = _strategie

    def spuneGluma(self):
        return self.strategie.spuneGluma()

    def ascultaGluma(self,gluma):
        if "***" in gluma:
            print("hahaHAHAHAHAHAHA")
        elif "**" in gluma:
            print("hahaHAHA")
        elif "*" in gluma:
            print("ha")

def main():
    f = open("bancuri.txt", "r")
    text = f.read()

    dictionarGlume = citimGlume(text)
    #print(glume)
    strategie1 = StrategieGlumeOk(dictionarGlume)
    strategie2 = StrategieGlumeFoarteBune(dictionarGlume)

    student1 = Student(strategie1)
    student2 = Student(strategie2)

    student2.ascultaGluma(student1.spuneGluma())
    student1.ascultaGluma(student2.spuneGluma())


if __name__ == '__main__':
    main()