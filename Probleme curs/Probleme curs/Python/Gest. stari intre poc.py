#Gestionarea starilor intre procese

import multiprocessing as mp
def worker(dictionary,cheie,element,contor):
    lock=mp.Lock()
    with lock:
        contor[0]=contor[0]+1
    dictionary[cheie]=element
    print('Cheie:',cheie,'laloare:',element,'sunt la al',contor[0],'-lea apel')
if __name__=='__main__':
    manager =mp.Manager()
    dictionary =manager.dict()
    contor =manager.list([0])
    contor[0]=0
    sarcini =[mp.Process(target=worker,args=(dictionary,i,i*2,contor)) for i in range(5)]
    for treaba in sarcini:
        treaba.start()
    for treaba in sarcini:
        treaba.join()
    print('Rezultate: ',dictionary)