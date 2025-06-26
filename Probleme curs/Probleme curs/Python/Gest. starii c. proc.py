#Gestionarea starii curente a unui proces

import multiprocessing
import time
import signal

def proces_gol():
    print('Pornesc executie procesului')
    time.sleep(0.1)
    print('S-a terminat executie procesului')
if __name__=='__main__':
    proces_test=multiprocessing.Process(target=proces_gol)
    print('Starea procesului inainte de lansarea in executie: ',proces_test,proces_test.is_alive())
    proces_test.start()
    print('Procesul execute: ',proces_test,proces_test.is_alive())
    proces_test.terminate()
    try:
        print('Procesul s-a terminat: ',proces_test,proces_gol().is_alive())
    except AttributeError:
        print('Nu exista informatii dupa comanda terminate')
    proces_test.join()
    try:
        print('Procesul dupa join: ',proces_test,proces_gol().is_alive())
    except AttributeError:
        print('Nu am informatii dupa join')
    if signal.SIG_DFL == proces_test.exitcode:
        print('Procesul dupa un exit code')