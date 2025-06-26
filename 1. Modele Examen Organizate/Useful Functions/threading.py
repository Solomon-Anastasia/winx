import threading
from functional import seq


class MyThread(threading.Thread):
    def __init__(self, thread_id, lock_, file_, list_):
        threading.Thread.__init__(self)
        self.lock = lock_
        self.id = thread_id
        # self.delay = delay
        self.list = list_
        self.file = file_

    def run(self):
        with self.lock:
            count = 0
            while count <= self.id:
                count += 1
                line = self.file.readline()
                self.list.append(line)
                if not line:
                    break


if __name__ == "__main__":
    file1 = open("C:\Facultate\PP\exercitii\\fire_with\\file1.txt", "r")
    file2 = open("C:\Facultate\PP\exercitii\\fire_with\\file2.txt", "r")
    file3 = open("C:\Facultate\PP\exercitii\\fire_with\\file3.txt", "r")
    file4 = open("file4.txt", "r")
    lock = threading.Lock()
    alist = []

    thread1 = MyThread(0, lock, file1, alist)
    thread2 = MyThread(1, lock, file2, alist)
    thread3 = MyThread(2, lock, file3, alist)
    thread4 = MyThread(3, lock, file4, alist)

    thread1.start()
    thread2.start()
    thread3.start()
    thread4.start()

    thread1.join()
    thread2.join()
    thread3.join()
    thread4.join()

    print(seq(alist).map(lambda line: line.replace(" ", "").replace("\n", "")))
