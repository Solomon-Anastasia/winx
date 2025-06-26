#Utilizarea 'with

import threading
import logging

logging.basicConfig(
    level=logging.DEBUG,
    format='(%(threadName)-8s)%(message)s'
)
def thread_cu_with(statement):
    with statement:
        logging.debug('%s achizitionat cu with' %statement)
def thread_fara_with(statement):
    statement.acquire()
    try:
        logging.debug('%s achizitionat direct'%statement)
    finally:
        statement.release()
if __name__=='__main__':
    lock =threading.Lock()
    rlock =threading.RLock()
    conditie =threading.Condition()
    mutex =threading.Semaphore(1)
    threading_synchronisation_list =[lock,rlock,conditie,mutex]
    for statement in threading_synchronisation_list:
        t1 =threading.Thread(target =thread_cu_with,args=(statement,))
        t2=threading.Thread(target=thread_fara_with,args=(statement,))
        t1.start()
        t2.start()
        t1.join()
        t2.join()