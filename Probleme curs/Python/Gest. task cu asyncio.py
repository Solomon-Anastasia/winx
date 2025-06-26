#Gestiune task-uri cu asyncio

import asyncio as asy
@asy.coroutine
def factorial(number):
    fact=1
    for i in range(2,number+1):
        print('Calculez factorial(%s)'%i)
        yield from asy.sleep(1)
        fact*=i
    print('Factorial(%s) = %s'%(number,fact))
@asy.coroutine
def fibonacci(number):
    a,b=0,1
    for i in range(number):
        print('Calculez fibonacci (%s)'%i)
        yield from asy.sleep(1)
        a,b=b,a+b
    print('Fibonacci(%s) = %s'%(number,a))
@asy.coroutine
def coeficient_binomial(n,k):
    rezultat=1
    for i in range(1,k+1):
        rezultat = rezultat*(n-i+1)/i
        print('Calculez coeficientul binomial (%s)'%i)
        yield from asy.sleep(1)
    print('Coeficientul binomial (%s, %s)= %s'%(n,k,rezultat))

if __name__=='__main__':
    tasks=[asy.Task(factorial(7)),asy.Task(fibonacci(7)),asy.Task(coeficient_binomial(14,7))]
    bucla =asy.get_event_loop()
    bucla.run._until_complete(asy.wait(tasks))
    bucla.close()