#Aplicatii client server
from socket import*
serverHost=''
serverPort=8888
canal_comunicare_server=socket(AF_INET,SOCK_STREAM)
canal_comunicare_server.bind((serverHost,serverPort))
canal_comunicare_server.listen(3)
while True:
    conexiune,addr =canal_comunicare_server.accept()
    print("Conexiune cu un client: ",addr)
    while True:
        data=conexiune.recv(1024)
        if not data:
            break
        print('Serverul a primit: ',repr(data))
        conexiune.sendall(data)
    conexiune.close()

import sys
from socket import *
serverHost=''
serverPort=8888
masaj=['Mesajul unu de la client','Mesajul doi']
if len(sys.argv)>1:
    serverHost=sys.argv[1]
canal_comunicare_client=socket(AF_INET,SOCK_STREAM)
canal_comunicare_client.connect((serverHost,serverPort))
for element in mesaj:
    canal_comunicare_client.sendall(element.encode())
    date_receptionate=socketul_client.recv(1024)
    print("Clientul a primit: ",date_receptionate)
canal_comunicare_client.close()


import socketserver
HOST,PORT="",8889

class MyTCPRequestHandler(socketserver.StreamRequestHandler):
    def handle(self):
        self.date_primite =self.request.recv(1024).strip()
        print("{} a trimis:".format(self.client_address[0]))
        print(self.date_primite)
        self.request.sendall(self.date_primite.upper())
server=socketserver.TCPServer((HOST,PORT),MyTCPRequestHandler)

server.serve_forever()


import socket
HOST,PORT="",8889
date_test="Test de emisie receptie \n si a doua linie"
canal_comunicare=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
try:
    canal_comunicare.connect((HOST,PORT))
    canal_comunicare.sendall(bytes(date_test+"\n",'utf-8'))
    date_receptionate=str(canal_comunicare.rscv(1024),"utf-8")
finally:
    canal_comunicare.close()
print("Am primit la server: {}".format(date_test))
print("Am primit de la server: {}".format(date_receptionate))