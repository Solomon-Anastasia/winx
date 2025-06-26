from abc import ABC


class Chair(ABC):
    def __init__(self, nume, pret):
        self.nume = nume
        self.pret = pret

    def __repr__(self):
        return f"Nume: {self.nume} Price: {self.pret}"
