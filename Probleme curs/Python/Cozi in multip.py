#Cozi in multiprocessing

import multiprocessing
import os
from multiprocessing import Queue

q=Queue()
def proc_pid(n):
    q.put(os.getpid())
    print("\n[{0}] Salut!".format(n))
procese=[]
for i in range(5):
    t=multiprocessing.Process(target=proc_pid,args=(i,))
    procese.append(t)
    t.start()
for un_proces in procese:
    print(un_proces.name)
    un_proces.join()
olista=[]
while not q.empty():
    olista.append(q.get())
print(olista,' de lungimea ',len(olista))