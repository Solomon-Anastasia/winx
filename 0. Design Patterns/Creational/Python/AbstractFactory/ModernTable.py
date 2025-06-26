from Table import Table


class ModernTable(Table):

    def __init__(self, nume, pret, producator):
        super().__init__(nume, pret)
        self.producator = producator

    def __repr__(self):
        return super().__repr__() + f" Producator: {self.producator}"
