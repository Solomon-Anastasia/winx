from abc import ABCMeta, abstractmethod
from functional import seq


def isPrime(x):
    if x < 0:
        return False
    if x == 1 or x == 2:
        return True
    if seq(range(2, x // 2 + 1)).filter(lambda it: x % it == 0).len() > 0:
        return False
    return True


class FSM:
    def __init__(self, l):
        self.__l = l
        self.__states = [State0(self), State1(self), State2(self)]
        self.__current_state = self.__states[0]

    def get_list(self):
        return self.__l

    def get_state(self, state_number):
        if state_number >= len(self.__states) or state_number < 0:
            return None
        return self.__states[state_number]

    def set_state(self, state):
        self.__current_state = state

    def do_task(self):
        return self.__current_state.do_task()


class State(metaclass=ABCMeta):
    def __init__(self, fsm):
        self._fsm = fsm

    @abstractmethod
    def do_task(self):
        pass


class State0(State):
    def __init__(self, fsm):
        super().__init__(fsm)

    def do_task(self):
        if len(self._fsm.get_list()) > 0:
            self._fsm.set_state(self._fsm.get_state(1))
            return True
        return False


class State1(State):
    def __init__(self, fsm):
        super().__init__(fsm)

    def do_task(self):
        l = self._fsm.get_list()
        found = seq(l).find(lambda it: isPrime(it))
        if found != None:
            print(f"S-a eliminat elementul prim {found}.")
            l.remove(found)
        self._fsm.set_state(self._fsm.get_state(2))
        return True


class State2(State):
    def __init__(self, fsm):
        super().__init__(fsm)

    def do_task(self):
        l = self._fsm.get_list()
        found = seq(l).find(lambda it: not isPrime(it))
        if found != None:
            print(f"S-a eliminat elementul neprim {found}.")
            l.remove(found)
        self._fsm.set_state(self._fsm.get_state(0))
        return True
