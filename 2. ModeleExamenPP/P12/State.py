from abc import ABCMeta, abstractmethod


class StudentState(metaclass=ABCMeta):
    def __init__(self, student):
        self._student = student

    @abstractmethod
    def update_state(self):
        pass

    @abstractmethod
    def show_state(self):
        pass


class FericitState(StudentState):
    def __init__(self, student):
        super().__init__(student)
        self.__ok_states = ["Fericit", "Bucuros", "Vesel"]

    def update_state(self):
        if self._student.get_current_state() not in self.__ok_states:
            self._student.toggle_general_state()

    def show_state(self):
        return "Fericit"


class NefericitState(StudentState):
    def __init__(self, student):
        super().__init__(student)
        self.__ok_states = ["Nefericit", "Disperat", "Suparat"]

    def update_state(self):
        if self._student.get_current_state() not in self.__ok_states:
            self._student.toggle_general_state()

    def show_state(self):
        return "Nefericit"
