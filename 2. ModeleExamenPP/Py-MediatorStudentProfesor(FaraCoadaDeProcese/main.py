from Student import Student
from Profesor import Profesor
from Mediator import Mediator, Asistent


if __name__ == '__main__':
    asistent=Asistent()
    studenti=[Student(name,asistent) for name in ["Alex","George","Alina"]]
    profesor=Profesor(asistent)
    asistent.set_profesor(profesor)
    asistent.set_studenti(studenti)

