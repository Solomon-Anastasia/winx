from abc import ABCMeta, abstractmethod
import re
from random import choice


class StrategieBancuri(metaclass=ABCMeta):
    def __init__(self):
        text = open("Bancuri.txt", 'r').read()
        self._dictionar = {"*": [], "**": [], "***": []}
        self._dictionar["*"] += re.findall("(?<!\*{2})(?<!\*{3})(?<=\*)[^\*]+", text)
        self._dictionar["**"] += re.findall("(?<!\*{3})(?<=\*{2})[^\*]+", text)
        self._dictionar["***"] += re.findall("(?<=\*{3})[^\*]+", text)

    @abstractmethod
    def get_banc(self):
        pass


class StrategieBancuri1Stea(StrategieBancuri):
    def __init__(self):
        super().__init__()

    def get_banc(self):
        return choice(self._dictionar["*"])


class StrategieBancuri2Stele(StrategieBancuri):
    def __init__(self):
        super().__init__()

    def get_banc(self):
        return choice(self._dictionar["**"])


class StrategieBancuri3Stele(StrategieBancuri):
    def __init__(self):
        super().__init__()

    def get_banc(self):
        return choice(self._dictionar["***"])
