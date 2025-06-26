from abc import ABC, abstractmethod


# --- Receiver ---
class Student:
    def __init__(self, name):
        self.name = name
        self._state = "happy"

    def set_state(self, new_state):
        print(f"[Student] {self.name} state changed from {self._state} to {new_state}")
        self._state = new_state

    def get_state(self):
        return self._state


# --- Command Interface ---
class Command(ABC):
    @abstractmethod
    def execute(self):
        pass


# --- Concrete Commands ---
class CheerUpCommand(Command):
    def __init__(self, student: Student):
        self.student = student

    def execute(self):
        self.student.set_state("happy")


class StressCommand(Command):
    def __init__(self, student: Student):
        self.student = student

    def execute(self):
        self.student.set_state("stressed")


class DespairCommand(Command):
    def __init__(self, student: Student):
        self.student = student

    def execute(self):
        self.student.set_state("desperate")


# --- Invoker ---
class Colleague:
    def send_command(self, command: Command):
        print("[Colleague] Sending command...")
        command.execute()


# --- Demo ---
if __name__ == "__main__":
    student = Student("Alice")
    colleague = Colleague()

    # Send commands
    colleague.send_command(StressCommand(student))
    colleague.send_command(DespairCommand(student))
    colleague.send_command(CheerUpCommand(student))
