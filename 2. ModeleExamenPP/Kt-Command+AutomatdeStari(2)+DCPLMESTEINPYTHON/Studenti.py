import State
from random import choice


class Student:
    def __init__(self, name):
        self.__name = name
        self.__current_state = "Fericit"
        self.__general_states = [State.FericitState(self), State.NefericitState(self)]
        self.__general_state = self.__general_states[0]
        self.__nice_action = lambda colega: colega.act_on("Nice")
        self.__bad_action = lambda colega: colega.act_on("Bad")

    def get_current_state(self):
        return self.__current_state

    def toggle_general_state(self):
        if self.__general_state == self.__general_states[0]:
            self.__general_state = self.__general_states[1]
        else:
            self.__general_state = self.__general_states[0]

    def act_nice(self, colega):
        self.__current_state = self.__nice_action(colega)
        self.__update_general_state()

    def act_bad(self, colega):
        self.__current_state = self.__bad_action(colega)
        self.__update_general_state()

    def __update_general_state(self):
        self.__general_state.update_state()

    def print_state(self):
        print(
            f"Studentul {self.__name} este {self.__current_state}, in general fiind {self.__general_state.show_state()}.")


class Colega:
    def __init__(self, name):
        self.__name = name
        self.__fericit_states = ["Fericit", "Bucuros", "Vesel"]
        self.__nefericit_states = ["Nefericit", "Disperat", "Suparat"]

    def act_on(self, action_type):
        if action_type == "Nice":
            selected = choice(self.__fericit_states)
        elif action_type == "Bad":
            selected = choice(self.__nefericit_states)
        else:
            raise Exception("Actiune incorecta!")
        print(f"Colega {self.__name} a facut un coleg {selected}.")
        return selected
