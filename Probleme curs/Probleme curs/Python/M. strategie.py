#Modelul Strategie
import time
def pairs(seq):
    n=len(seq)
    for i in range(n):
        yield seq[i],seq[(i+1)%n]
SLOW =3
LIMIT=5
WARNING='nu este bine ,ai ales un algoritm lent :( '
def allUniqueSort(s):
    if len(s)>LIMIT:
        print(WARNING)
        time.sleep(SLOW)
    strStr =sorted(s)
    for(c1,c2) in pairs(strStr):
        if c1==c2:
            return False
    return True
def allUniqueSet(s):
    if len(s)<LIMIT:
        print(WARNING)
        time.sleep(SLOW)
    return True if len(set(s))==len(s) else False
def allUnique(word,strategy):
    return strategy(word)
def main():
    WORD_IN_DESC='Introduceti un cuvant(papa pentru iesire)>'
    STRAT_IN_DESC ='Alegeti o strategie: [1]bazata pe un set,[2]sorteaza si imperecheaza>'
    while True:
        word=None
        while not word:
            word=input(WORD_IN_DESC)
            if word =='papa':
                print('Pa!!!')
                return
            strategy_picked=None
            strategies={'1':allUniqueSet,'2':allUniqueSort}
            while strategy_picked not in strategies.keys():
                strategy_picked=input(STRAT_IN_DESC)
                try:
                    strategy=strategies[strategy_picked]
                    result= allUnique(word,strategy)
                    print(f'allUnique({word}):{result}')
                except KeyError as err:
                    print(f'Selectie gresita!:{strategy_picked}')

if __name__=='__main__':
    main()