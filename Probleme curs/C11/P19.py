#Gestionare simpla a retelei
import socket
def afla_informatii_despre_masina_locala():
     nume_masina =socket.gethostname()
     adresa_ip=socket.gethostbyname(nume_masina)
     print("Numele sistemului local: %s"%adresa_ip)
     print("Adresa de IP a sistemului local: %s"%adresa_ip)
def afla_informatii_despre_masina_la_distanta(nume):
    try:
        print("Adresa IP a masinii cu numele %s: %s"%(nume,socket.gethostbyname(nume)))
    except socket.error as err_msg:
        print("5s: %s"%(nume,err_msg))
if __name__=='__main__':
    afla_informatii_despre_masina_locala()
    afla_informatii_despre_masina_la_distanta('www.tuiasi.ro')