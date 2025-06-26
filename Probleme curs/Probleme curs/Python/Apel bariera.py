#Apel bariera
import multiprocessing
from multiprocessing import Barrier,Lock,Process
from time import time
import datetime as dt

def test_bariera(barrier,lock):
    name=multiprocessing.current_process().name
    barrier.wait()
    now=time()
    with lock:
        print('Procesul %s -----> %s'%(name,dt.datetime.fromtimestamp(now)))
def test_fara_bariera():
    name =multiprocessing.current_process().name
    now=time()
    print('Procesul %s -----> %s'%(name,dt.datetime.fromtimestamp(now)))
if __name__=='__main__':
    barrier =Barrier(2)
    lock=Lock()
    Process(name='p1-test_cu_bariera',target=test_bariera,args=(barrier,lock)).start()
    Process(name='p2-test_cu_bariera', target=test_bariera, args=(barrier, lock)).start()
    Process(name='p3-test_fara_bariera',target=test_fara_bariera).start()
    Process(name='p4-test_fara_bariera', target=test_fara_bariera).start()