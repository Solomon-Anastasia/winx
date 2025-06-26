#Caut servicii

import socket as sk

def caut_servicii(nume_protocol,port_list):
    for port in port_list:
        try:
            s=sk.getservbyport(port,nume_protocol)
            print("Pe portul: %s am serviciul cu numele %s care utilizeaza protocolul %s"%(port,s,nume_protocol))
        except:
            continue

if __name__=='__main__':
    port_list=[1,80,8080]
    nume_protocol='udp'
    caut_servicii(nume_protocol,port_list)
    nume_protocol='tcp'
    caut_servicii(nume_protocol,port_list)