import StrategieBancuri
from random import choice


class Student:
    def __init__(self, name):
        self.__name = name
        self.__dict_reaction_to_banc_strategy = {}
        self.__dict_reaction_to_banc_strategy["Buna"] = StrategieBancuri.StrategieBancuri1Stea()
        self.__dict_reaction_to_banc_strategy["Foarte buna"] = StrategieBancuri.StrategieBancuri2Stele()
        self.__dict_reaction_to_banc_strategy["Cea mai buna"] = StrategieBancuri.StrategieBancuri3Stele()
        self.__possible_reactions = ["Buna", "Foarte buna", "Cea mai buna"]

    def get_reaction(self):
        reaction = choice(self.__possible_reactions)
        print(f"Studentul {self.__name} are reactia: \"{reaction}\".")
        return reaction

    def say_banc_to(self, other):
        reaction = other.get_reaction()
        print(f"Studentul {self.__name} a primit reactia \"{reaction}\" si spune urmatorul banc:")
        print(self.__dict_reaction_to_banc_strategy[reaction].get_banc())
