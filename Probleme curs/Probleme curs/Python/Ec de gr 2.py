import math

print("Rezolvare ecuatie de grad II \n")
try:
    a,b,c=[int(x) for x in input("Introduceti coef a,b,c: ").split()]
    discRoot=math.sqrt(b*b-4*a*c)
    root1=(-b+discRoot)/(2*a)
    root2=(-b-discRoot)/(2*a)
    print("\nSolutiile sunt:",root1,root2)
except ValueError as excObj:
    if str(excObj)=="math domain error":
        print("Nu are radacini reale")
    else:
        print("Numar incorect de valori")
except NameError:
    print("\nNu ai introdus 3 valori")
except TypeError:
    print("\nNu toate valorile introduse sunt numere")
except SyntaxError:
    print("\nFormatul datelor incorect-utilizati spatiu")
except:
    print("\nEroare necunoscuta")