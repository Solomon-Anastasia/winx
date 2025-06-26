from Memento import *
from functional import seq

if __name__ == '__main__':
    numbers=open("file1.csv",'r').read().split(',')
    numbers=seq(numbers).map(lambda it:int(it)).list()

    f1=lambda x:(x%2==0 and x+1) or x
    f2=lambda x:3*x*x-2*x+1
    f3=lambda x:x+x+1
    functions=[f1,f2,f3]

    caretaker=Caretaker()
    originator=Originator(numbers)

    print(f"Lista originala: {numbers}")
    for i,f in enumerate(functions,1):
        caretaker.add(originator.save_state_to_memento())
        originator.set_state(seq(originator.get_state()).map(f).list())
        print(f"Lista dupa aplicarea functiei f{i}: {originator.get_state()}")
        restore=input("Doriti restaurarea starii anterioare a listei? 1-Da Altceva-Nu\nRaspunsul dumneavoastra: ")
        if restore=="Da":
            originator.restore_state_from_memento(caretaker.get())
    print(f"Lista finala: {originator.get_state()}")