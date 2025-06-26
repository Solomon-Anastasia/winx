#Determinarea firului curent

import logging
import threading
logging.basicConfig(level=logging.INFO)
def first_function():
    logging.info(threading.currentThread().getName() +str(' Porneste..'))
    logging.info(threading.currentThread().getName() +str(' se opreste...'))
    return
def second_function():
    logging.info(threading.currentThread().getName() + str(' Porneste..'))
    logging.info(threading.currentThread().getName() + str(' se opreste...'))
    return
def third_function():
    logging.info(threading.currentThread().getName() + str(' Porneste..'))
    logging.info(threading.currentThread().getName() + str(' se opreste...'))
    return

if __name__ =='__main__':
    t1=threading.Thread(name='prima_functie',target=first_function)
    t2 = threading.Thread(name='a doua_functie', target=second_function)
    t3 = threading.Thread(name='a treia_functie',target= third_function)
    t1.start()
    t2.start()
    t3.start()
    logging.debug('Pauza')
    t1.join()
    t2.join()
    t3.join()
    logging.info(threading.currentThread().getName()+str('-main thread..'))