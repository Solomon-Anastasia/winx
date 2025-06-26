#Dictionar

#unu la unu
numberDict={1:'one',2:'two',3:'three',4:'four'}
print("\n",str(numberDict))

#unu la mai multi
letterDict={'vowel':['a','e','i','o','u'],'consonant':['b','c','d','f']}
print("\n",str(letterDict))

#mai multi la mai multi
numbers=(1,2,3,4,5,6,7,8,9,0)
letters=('a','b','c','d','e','f')
punct=('.','!','?')
charSetDict={numbers:[],letters:[],punct:[]}
print("\n",str(charSetDict))

#adaugare de valori
cSet =input("\n Introduceti caractere:")
for c in cSet:
    for x in charSetDict.keys():
        if c in x:
            charSetDict[x].append(c)
            break
charSetDict["Special"]=['%','$','#']
charSetDict["Special"]='><'
print("\n"+str(charSetDict))

#Problema "Adaugare valori la dictionar"
numbers=('1','2','3','4','5','6','7','8','9','0')
letters=('a','b','c','d','e','f')
punct=('.','!','?')
charSetDict={numbers:[],letters:[],punct:[]}
def display_cset(cset):
    for x in cset.items():
        if x[0]==numbers:
            print("Numere:")
        elif x[0]==letters:
            print("Cifre:")
        elif x[0]==punct:
            print("Punctuatie:")
        else:
            print("Necunoscut:")
        print(x[1])
cSet=input("Introduceti caractere: ")
for c in cSet:
    for x in charSetDict.keys():
        if c in x:
            charSetDict[x].append(c)
            break
display_cset(charSetDict)
charSetDict["Special"]=['%','$','#']
display_cset(charSetDict)
charSetDict["Special"]='><'
display_cset(charSetDict)