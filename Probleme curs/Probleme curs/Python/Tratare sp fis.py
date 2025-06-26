#Tratare simpla fisiere

fobj_in =open("otopeni.txt")
fobj_out=open("otopeni1.txt","w")
i=1
for line in fobj_in:
    print(line.rstrip())
    fobj_out.write(str(i)+": "+line)
    i=i+1
fobj_in.close()
fobj_out.close()

#Pozitionare in fisier

fo=open("otopeni.txt","r+")
str=fo.read(10)
print("\n\nSirul citit este: "+str)
pos=fo.tell()
print("pozitia curenta: ",pos)
pos=fo.seek(0,0)
str=fo.read(25)
print("Din nou citite: "+str)
fo.close()

#Citeste o anume linie
import linecache

filePath="otopeni.txt"
print(linecache.getline(filePath,2))
print(linecache.getline(filePath,4))
linecache.clearcache()

#Citeste cate un cuvant
filePAth="otopeni.txt"
wordList=[]
wordCount=0
file=open(filePath,'r')
for line in file:
    for word in line.split():
        wordList.append(word)
        wordCount+=1
print(wordList)
print("Total words = %d" %wordCount)

#Tratare corecta operatii I/O fisiere
inPath=input("Fisierul de intrare: ")
outPath=input("Fisierul de iesire: ")
try:
    file=open(inPath,'r')
    #citire fisier date
    file.close()
except FileNotFoundError:
    print("Eroare deschidere fisier")

try:
    file=open(outPath,'wb')
    #scriere fisier date
    file.close()
except FileNotFoundError:
    print("Eroare scriere in fisier")

#Print to File
import sys

wordList=["Red","Blue","Green"]
filePath="output.txt"

def printToFile(filePath,mode,text):
    original=sys.stdout
    sys.stdout=open(filePath,mode)
    print(text)
    sys.stdout=original

#for word in wordList:
    #printToFile(filePAth,'a',"\n"+str(word)+"Color Adjust") #Cica eroare la str...

