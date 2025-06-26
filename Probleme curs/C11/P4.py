#Fir cu eveniment

import time
from threading import Thread, Event
import random

elemente =[]
eveniment = Event()
class Consumator(Thread):
    def __init__(self,elemente,eveniment):
        Thread.__init__(self)
        self.elemente=elemente
        self.eveniment=eveniment
    def run(self):
        for i in range(5):
            self.eveniment.wait()
            try:
                item=self.elemente.pop()
            except IndexError:
                print('Nu pot scoate dintr-o coada goala!')
            print('\nmesaj de la consumator: %d a fost generat de %s'%(item, self.name))
class Producator(Thread):
    def __init__(self,elemente,eveniment):
        Thread.__init__(self)
        self.eveniment=eveniment
        self.elemente=elemente
    def run(self):
        for i in range(5):
            item =random.randint(0,256)
            self.elemente.append(item)
            print('\nMesaj de la producator: elementul #%d a fost adaugat la lista de %s'%(item, self.name))
            print('Mesaj de la producator: eveniment generat %s'%self.name)
            self.eveniment.set()
            print('Mesaj de la producator: eveniment anulat de %s'%self.name)
            self.eveniment.clear()
if __name__=='__main__':
    t1=Producator(elemente,eveniment)
    t2=Consumator(elemente,eveniment)
    t1.start()
    t2.start()
    t1.join()
    t2.join()