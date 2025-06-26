import more_itertools
from functional import seq


def merge_dict(d, d1):
    for key, value in d1.items():
        if key in d:
            d[key] = (d[key], d1[key])
        else:
            d[key] = d1[key]
    return d


if __name__ == "__main__":
    with open("text1.txt", "r") as f:
        data1 = f.read().split(" ")

    key_func = lambda word: word
    value_func = lambda word: ("text1.txt", 1)
    reduce_func = lambda word: seq(word).reduce_by_key(lambda x, y: x + y)

    d1 = more_itertools.map_reduce(data1, key_func, value_func, reduce_func)

    with open("text2.txt", "r") as f:
        data2 = f.read().split(" ")

    value_func = lambda word: ("text2.txt", 1)
    d2 = more_itertools.map_reduce(data2, key_func, value_func, reduce_func)

    with open("text3.txt", "r") as f:
        data3 = f.read().split(" ")

    value_func = lambda word: ("text3.txt", 1)
    d3 = more_itertools.map_reduce(data3, key_func, value_func, reduce_func)

    finalDictionary = {}
    finalDictionary = merge_dict(finalDictionary, d1)
    finalDictionary = merge_dict(finalDictionary, d2)
    finalDictionary = merge_dict(finalDictionary, d3)

    for (key, value) in finalDictionary.items():
        print(str(key) + ": " + str(value))

    # listaPuncte = [(1, 2, 3), (2, 3, 4), (1, 2, 3), (3, 4, 5), (4, 5, 6)]
    # proiectieXOY = lambda x, y, z: (x, y)  # proiectie pe fata de jos a unui cub
    # proiectieYOZ = lambda x, y, z: (y, z)  # proiectie pe una din fetele laterale ale uunui cub
    # proiectieXOZ = lambda x, y, z: (x, z)  # proiectia pe cealalta fata laterala a unui cub

