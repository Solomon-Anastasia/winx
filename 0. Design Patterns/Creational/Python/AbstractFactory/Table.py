from abc import ABC


class Table(ABC):
    def __init__(self, nume, pret):
        self.nume = nume
        self.pret = pret

    def __repr__(self):
        return f"Nume : {self.nume} Pret: {self.pret}"
