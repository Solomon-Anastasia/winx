#Paralelism real -multiprocessing

import multiprocessing
import time

def proces_gol():
    nume =multiprocessing.current_process().name
    print('\nPornesc un proces numit: %s'%nume)
    time.sleep(3)
    print('Am terminat procesul numit: %s'%nume)

if __name__=='__main__':
    proces_demon=multiprocessing.Process(name='proces demon',target=proces_gol)
    proces_demon.daemon=True
    proces_normal=multiprocessing.Process(name='proces normal',target=proces_gol)
    proces_normal.daemon =False
    proces_demon.start()
    proces_normal.start()
    print('Am terminat procesul normal')