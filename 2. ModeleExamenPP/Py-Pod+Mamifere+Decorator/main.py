from Mamifere import *

# Nu vad cum ai putea, cu decoratorii din Python, sa adaugi noi functionalitati unei clase(noi metode).
# Din cate stiu decoratorii "decoreaza" o clasa (adica fiecare metoda a clasei, pe langa ce facea ea initial, sa mai faca ceva).
# Ar trebui probabil folosite design pattern-urile Visitor/Bridge(inca o data cel putin)/Strategy/Command pentru adaugarea de noi functionalitati...
if __name__ == '__main__':
    caine=Mamifer(Caine())
    pisica=Mamifer(Pisica())
    femeie=Mamifer(Femeie())
    barbat=Mamifer(Barbat())
    mamifere=[caine,pisica,femeie,barbat]
    for mamifer in mamifere:
        mamifer.speak()
        mamifer.preffered_food()