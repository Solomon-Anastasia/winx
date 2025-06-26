import functools
import threading

global sumadecuvinte
sumadecuvinte = 0


def f(k):
    global nr
    nr = nr + k
    return nr


def prtl(x, k):
    p = functools.partial(f)
    global sumadecuvinte
    global nr
    nr = 0
    lista = list(map(lambda y: p(k), x))
    sumadecuvinte += lista[-1]


def ver(vect, k):
    thread_1 = threading.Thread(target=prtl(vect, k))
    thread_1.start()
    thread_1.join()


if __name__ == '__main__':
    k = 1
    lista = open("text", "r")
    for elem in lista:
        iterator = elem.split(" ")
ver(iterator, k)
afisare = open("afisare", "w")
afisare.writelines(str(sumadecuvinte ))