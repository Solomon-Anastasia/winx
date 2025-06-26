from abc import ABC
import multiprocessing as mp
from multiprocessing.managers import BaseManager

#Cozi de mesaje - neterminat

class Worker(mp.Process):
    def __init__(self, message_queue):
        self.message_queue = message_queue
        super(Worker, self).__init__()
    def run(self):
        result = self.message_queue.get()
        result.append('Worker: Hello!')
        self.message_queue.put(result)

queue = mp.Queue()
queue.put([])
worker = Worker(queue)


#---------------------------------

class Om(ABC): #interfata generala
    pass

class Mediator(ABC):
    def notify(self):
        pass

class Asistent(Mediator,Om): #Concrete Mediator
    def __init__(self,stud,prof):
        self.student = stud
        self.student.setMediator(self)
        self.profesor = prof
        self.profesor.setMediator(self)
    def notify(self, who, msg):
        if isinstance(who,Student) == True:
            print("Student catre profesor: ",end='')
            self.profesor.receive(msg)
        else: #Profesor
            print("Profesor catre student: ",end='')
            self.profesor.receive(msg)

class BaseComponent(): #retine o intanta a mediatorului pentru student-profesor
    def __init__(self,mediator:Mediator = None):
        self.mediator = mediator
    def getMediator(self):
        return self.mediator
    def setMediator(self, mediator):
        self.mediator = mediator
    def receive(self,msg):
        print(msg)

class Student(Om, BaseComponent):
    def anunta_profesor(self,msg):
        self.mediator.notify(self,msg)

class Profesor(Om, BaseComponent):
    def anunta_student(self,msg):
        self.mediator.notify(self,msg)


if __name__ == '__main__':
    #worker.start()

    stud1 = Student()
    stud2 = Student()
    prof = Profesor()
    mediator = Asistent(stud1,prof)

    stud1.anunta_profesor("Am fost la examen.")
    prof.anunta_student("Ai luat nota 10!")

    mediator = Asistent(stud2, prof)

    stud2.anunta_profesor("Am lipsit de la examen.")
    prof.anunta_student("Ai luat nota 4!")
