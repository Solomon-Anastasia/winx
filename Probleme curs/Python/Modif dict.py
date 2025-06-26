#Modificare de elemente din dictionar

validKeys=(1,2,3)
keyGenDict={'keys':[1,2,3],1:'blue',2:'fast',3:'test','key':2}
print("Cheile: ")
print(keyGenDict.keys())
print("\nValorile: ")
print(keyGenDict.values())
print("\nElemente: ")
print(keyGenDict.items())
val=keyGenDict['key']
keyGenDict['key']=1
print("\nValorile: ")
print(keyGenDict.values())
keyGenDict.clear()
print("\nElemente: ")
print(keyGenDict.items())
print("\n\n")

#Extragerea unei valori din dictionar
validkeys=(1,2,3)
keyGenDict={'keys':[1,2,3],1:'blue',2:'fast',3:'test','key':2}

def show_key(key):
    if(key in validkeys):
        keyVal=(keyGenDict["keys"])[key-1]
        print("Key= "+keyGenDict[keyVal])
    else:
        print("Invalid key")

print(keyGenDict.keys())
print(keyGenDict.items())
val=keyGenDict["key"]

show_key(val)