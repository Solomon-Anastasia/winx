import string

#executarea de cod in interiorul unui sir
radius =3
cards=['Ace','King','Queen','Jack']
codeStr = 'for card in cards: print("Card= "+card)'
exec(codeStr)

areaStr = 'pi*(radius*radius)'
print("\nArea= "+str(eval(areaStr,{'pi':3.14},{'radius':5})))
values = [5,3,'blue','red']

s=string.Template("Variable v =$v")
for x in values:
    print(s.substitute(v=x))