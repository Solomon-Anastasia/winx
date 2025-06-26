from math import sqrt

from functional import seq
from multiprocessing import Process, Queue

min_fun = lambda list: seq(list).min()
max_fun = lambda list: seq(list).max()
mean_fun = lambda list: seq(list).sum() / seq(list).len()
square_mean_fun = lambda list: sqrt(seq(list).map(lambda it: it * it).sum() / seq(list).len())
subsequence_fun = lambda list: seq(list).filter(lambda it: -square_mean_fun(list) <= it <= square_mean_fun(list))

if __name__ == "__main__":
    lists = []
    numbers = seq(open("Valori.txt", "r").readline().split(' ')) \
        .map(lambda it: it.replace('\t', '')) \
        .map(lambda it: int(it))
    while numbers.len() > 0:
        if numbers.len() >= 10:
            lists.append(numbers.take(10).list())
            numbers = numbers.drop(10)
        else:
            lists.append(numbers.take(numbers.len()).list())
            numbers = numbers.drop(numbers.len())

    results = Queue()  # min, max, mean, subsequence
    processes = []
    for list in lists:
        aux = Process(target=lambda list, results: results.put(
            (min_fun(list), max_fun(list), mean_fun(list), subsequence_fun(list))), args=(list, results,))
        aux.start()
        processes.append(aux)
    for process in processes:
        process.join()

    rez = []
    while not results.empty():
        rez.append(results.get())

    for i in range(len(lists)):
        print(f"Sequence:{lists[i]}, min:{rez[i][0]}, max:{rez[i][1]}, mean:{rez[i][2]}, subsequence:{rez[i][3]}")
    i = 0
