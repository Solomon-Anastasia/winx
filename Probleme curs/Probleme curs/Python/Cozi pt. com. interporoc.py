#Cozi pentru comunicare interpoces

import multiprocessing
import random

class Producator(multiprocessing.Process):
    def __init__(self,queue):
        multiprocessing.Process.__init__(self)
        self.queue=queue
    def run(self):
        for _ in range(10):
            element= random.randint(0,256)
            self.queue.put(element)
            print('Proces Producator: element %d s-a adaugat on coada %s'%(element, self.name))
            print('Dimensiunea cozii este %s'%self.queue.qsize())
class Consumator(multiprocessing.Process):
    def __init__(self,queue):
        multiprocessing.Process.__init__(self)
        self.queue=queue
    def run(self):
        while True:
            if self.queue.empty():
                print('Coada este goala')
                break
            else:
                element=self.queue.get()
                print('Proces Consumator: element %d a fost scos din %s\n'%(element,self.name))
if __name__=='__main__':
    queue =multiprocessing.Queue()
    proces_producator=Producator(queue)
    proces_consumator=Consumator(queue)
    proces_producator.start()
    proces_consumator.start()
    proces_producator.join()
    proces_consumator.join()