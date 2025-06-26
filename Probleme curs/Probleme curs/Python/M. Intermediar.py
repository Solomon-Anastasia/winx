#Intermediar
class SensitiveInfo:
    def __init__(self):
        self.users=['bula','strula','bugs','mike']
    def read(self):
        nb=len(self.users)
        print(f"Sunt {nb} utilizatori: {''.join(self.users)}")
    def add(self,user):
        self.users.append(user)
        print(f'Adauga loser {user}')
class Info:
    def __init__(self):
        self.protected =SensitiveInfo()
        self.secret ='0xdeadbeef'
    def read(self):
        self.protected.read()
    def add(self,user):
        sec=input('dati parola?')
        self.protected.add(user) if sec == self.secret else print("Mai incearca!")
def main():
    info =Info()

    while True:
        print('1. afiseaza lista |==| 2. adauga loser |==| 3.iesire')
        key=input('Alegeti o obtiune:')
        if key=='1':
            info.read()
        elif key=='2':
            name =input('Dati numele userului: ')
            info.add(name)
        elif key=='3':
            exit()
        else:
            print(f'Optiune invalida: {key}')

if __name__=='__main__':
    main()