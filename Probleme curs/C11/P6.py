#Comunicare inter-thread utilizand cozi

from threading import Thread
from queue import Queue
import time
import random

class Producator(Thread):
    def __init__(self,queue):
        Thread.__init__(self)
        self.queue=queue
    def run(self):
        for i in range(10):
            element =random.randint(0,256)
            self.queue.put(element)
            print('Mesaj de la producator: element N%d adaugat la coada de %s\n'%(element,self.name))
            time.sleep(1)
class Consumator(Thread):
    def __init__(self,queue):
        Thread.__init__(self)
        self.queue =queue
    def run(self):
        while True:
            element =self.queue.get()
            print('Mesaj de la consumator: %d scos din coada de %s'%(element,self.name))
            self.queue.task_done()
if __name__=='__main__':
    queue=Queue()
    t1=Producator(queue)
    t2=Consumator(queue)
    t3=Consumator(queue)
    t4=Consumator(queue)
    t1.start()
    t2.start()
    t3.start()
    t4.start()
    t1.join()
    t2.join()
    t3.join()
    t4.join()