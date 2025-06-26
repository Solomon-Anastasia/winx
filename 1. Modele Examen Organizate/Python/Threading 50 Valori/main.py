import asyncio
import more_itertools
import functools
import numpy as np

async def select(list):
    maxim = functools.reduce(lambda a, b: a if a > b else b,list)
    minim = functools.reduce(lambda a, b: b if a > b else a, list)
    sum = functools.reduce(lambda a, b: a + b, list)
    average = sum / len(list)
    squaresum = 0
    for elem in list:
        squaresum += elem ** 2
    mediePatratica = np.sqrt(squaresum / len(list))

    print("Lista este: " + str(list))
    print("Media este: " + str(average))
    print("Media patratica este: " + str(mediePatratica))
    #print("Maximul este: " + str(maxim))
    #print("Minimul este: " + str(minim))
    selectedList = [x for x in list if x > average - mediePatratica and x < average + mediePatratica]
    print("Lista selectata este: " + str(selectedList))
    print()



async def main(list):
    await asyncio.gather(
        select(list[0:10]),
        select(list[10:20]),
        select(list[20:30]),
        select(list[30:40]),
        select(list[40:50]),
    )

if __name__ == "__main__":
    # with open("input.txt", 'a') as f:
    #     for elem in range(50):
    #         f.write(str(elem * 5) + " ")

    with open("input.txt", 'r') as f:
        line = f.readline()
        myList = list(map(int, line.split()))
        asyncio.run(main(myList))





