class Originator:
    def __init__(self, l):
        self.__state = l

    def set_state(self, l):
        self.__state = l

    def get_state(self):
        return self.__state

    def save_state_to_memento(self):
        return Memento(self.__state)

    def restore_state_from_memento(self, memento):
        self.__state = memento.get_state()


class Memento:
    def __init__(self, state):
        self.__state = state

    def get_state(self):
        return self.__state


class Caretaker:
    def __init__(self):
        self.__states = []

    def add(self, state):
        self.__states.append(state)

    def get(self):
        rez = self.__states[-1]
        self.__states.remove(self.__states[-1])
        return rez
