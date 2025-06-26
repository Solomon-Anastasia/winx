#Utilizarea unui pool de procese
import multiprocessing as mp
import signal
import time as tm
import sys

def la_patrat(data):
    #tm.sleep(10000)
    val =data*data
    return val
def signal_handler(signal,frame):
    print('A aparut o operatie externa',signal)
    pool.terminate()
    pool.join()
    print('Am terminat fortat procesul')
    sys.exit(0)
if __name__=='__main__':
    intrari =list(range(10))
    pool =mp.Pool(processes=4)
    signal.signal(signal.SIGINT,signal_handler)
    calcul_pool=pool.map(la_patrat,intrari)
    pool.close()
    pool.join()
    print('Pool: ',calcul_pool)