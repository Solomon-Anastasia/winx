from abc import ABC
import multiprocessing as mp

message_queue = mp.Queue()


class Mediator(ABC):
    def notify(self, sender, event):
        pass


class ConcreteMediator(Mediator):
    def __init__(self, student, profesor):
        self.student = student
        self.student.mediator = self

        self.profesor = profesor
        self.profesor.mediator = self

    def notify(self, sender, event):
        if event == "Give messages to students": # MARE ATENTIE CAND EDITEZI MESAJELE
            if message_queue.empty() is True:
                print("Studentii nu au primit mesaje.\n")
            else:
                print("Mesajele primite de la profesor sunt:")
                while message_queue.empty() is False:
                    print(message_queue.get())
                print()

        elif event == "Give messages to teacher":
            if message_queue.empty() is True:
                print("Profesorul nu a primit mesaje.\n")
            else:
                print("Mesajele primite de la studenti sunt:")
                while message_queue.empty() is False:
                    print(message_queue.get())
                print()


class BaseComponent:
    def __init__(self, mediator: Mediator = None):
        self._mediator = mediator

    @property
    def mediator(self):
        return self._mediator

    @mediator.setter
    def mediator(self, mediator):
        self._mediator = mediator


class Student(BaseComponent):
    def get_message(self):
        self.mediator.notify(self, "Give messages to students")

    def say_message(self, message):
        message_queue.put(message)


class Profesor(BaseComponent):
    def get_message(self):
        self.mediator.notify(self, "Give messages to teacher")

    def say_message(self, message):
        message_queue.put(message)


def main():
    student1 = Student()
    student2 = Student()
    student3 = Student()
    profesor = Profesor()
    mediator = ConcreteMediator(student1, profesor)
    mediator = ConcreteMediator(student2, profesor)
    mediator = ConcreteMediator(student3, profesor)

    profesor.get_message()
    student2.get_message()

    student1.say_message("Eu sunt Feri")
    student1.say_message("Glumeam. Io-te feedbeck")
    student2.say_message("Why are you running")
    student3.say_message("Imi place pisicile")

    profesor.get_message()
    profesor.say_message("Multumesc pentru feedbeck")
    profesor.say_message("Da")

    student1.get_message()


if __name__ == "__main__":
    main()