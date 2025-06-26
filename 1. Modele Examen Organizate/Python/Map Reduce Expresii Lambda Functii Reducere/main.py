from more_itertools import flatten, map_reduce
from functional import seq


def read_words(files):
    words = []
    for file in files:
        aux = open(file).read().split(' ')
        aux = [(word, file) for word in aux]
        words.append(aux)
    words = list(flatten(words))
    return words


if __name__ == '__main__':
    files = ["file1.txt", "file2.txt"]
    words = read_words(files)
    key_func = lambda pair: pair[0]
    value_func = lambda pair: (pair[1], 1)
    reduce_func = lambda list_of_pairs: seq(list_of_pairs).reduce_by_key(lambda x, y: x + y)
    dict = dict(map_reduce(words, keyfunc=key_func, valuefunc=value_func, reducefunc=reduce_func))
    print('{')
    for pair in dict.items():
        print(f"\'{pair[0]}\' : {pair[1]}")
    print('}')
    i = 0
