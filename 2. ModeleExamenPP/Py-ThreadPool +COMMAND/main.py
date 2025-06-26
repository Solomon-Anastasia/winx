import threading
import time
from time import sleep
from copy import copy

class MyThreadPool:
    def __init__(self,n:int):
        self.__threads=[threading.Thread() for _ in range(n)]
        self.__get_thread_state=lambda threads, i:threads[i].is_alive()
        self.__delay_thread=lambda threads, i, delay:None
        self.__start_thread=lambda threads, i:threads[i].start()
        self.__map=lambda func, *args:threading.Thread(target=func, args=args)

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_value, tb):
        for thread in self.__threads:
            if thread.is_alive():
                thread.join()

    def start_thread(self,i):
        self.__start_thread(self.__threads,i)

    def map(self, i, func, *args):
        if self.__threads[i].is_alive():
            self.__threads[i].join()
        self.__threads[i]=self.__map(func,args)

    def delay_thread(self, i, delay):
        self.__delay_thread(self.__threads,i,delay)

    def get_thread_state(self,i):
        return self.__get_thread_state(self.__threads,i)

def print_lists(lists):
    for list in lists:
        for i in list:
            print(f"{i} ",end='')
            sleep(1)


def reverse_print_lists(lists):
    for list in lists:
        aux=copy(list)
        aux.reverse()
        for i in aux:
            print(f"{i} ",end='')
            sleep(1)

if __name__ == '__main__':
    with MyThreadPool(3) as pool:
        list=[1,2,3,4,5]
        pool.map(0,print_lists,list)
        pool.start_thread(0)
        print(f"Thread 0 is alive: {pool.get_thread_state(0)}")
        pool.map(1,reverse_print_lists,list)
        pool.start_thread(1)
        print(f"Thread 1 is alive: {pool.get_thread_state(1)}")
        time.sleep(7)
        print(f"\nThread 0 is alive: {pool.get_thread_state(0)}")
        print(f"Thread 1 is alive: {pool.get_thread_state(1)}")
