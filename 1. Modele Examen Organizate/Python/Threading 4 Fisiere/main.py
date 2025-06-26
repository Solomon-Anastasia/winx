from threading import Condition, Thread
from concurrent.futures import ThreadPoolExecutor
import threading
from functional import seq

lock1 = threading.Lock()
lock2 = threading.Lock()

class myADT:
    def __init__(self):
        self.__lines = []

    def addLines(self, line):
        try:
            lock1.acquire()

            self.__lines.append("".join(filter(lambda x: x not in ' ', line)))
        finally:
            lock1.release()

    def getLines(self):
        return self.__lines

myList = myADT()

def readFile(file):
    try:
        with open(file, "r") as f:
            lines = f.readlines()
            for line in lines:
                myList.addLines(line)
    except:
        print("Exceptie")

if __name__ == "__main__":
    thread1 = threading.Thread(target = readFile, args = ('file1.txt',))
    thread2 = threading.Thread(target=readFile,args = ('file2.txt',))
    thread3 = threading.Thread(target=readFile,args = ('file3.txt',))
    thread4 = threading.Thread(target=readFile,args = ('file4.txt',))
    thread1.start()
    thread2.start()
    thread3.start()
    thread4.start()
    thread1.join()
    thread2.join()
    thread3.join()
    thread4.join()

    print(myList.getLines())
