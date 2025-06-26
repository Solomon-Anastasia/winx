#server ecou utilizand tcp-ip bazat pe asyncio

import asyncio as asy
class ServerEcou(asy.Protocol):
    def connection_made(self,transport):
        nume_client=transport.get_extra_info('nume client')
        print("Conexiune acceptata cu {}".format(nume_client))
        self.transport =transport
    def data_received(self,date):
        mesaj=date.decode()
        print("Date Receptionate: {}",format(mesaj))
        print("Trimit {!r}".format(mesaj))
        self.transport.write(date)
        print("Inchid socket-ul clientului")
        self.transport.close()
bucla =asy.get_event_loop()
c1=bucla.create_server(ServerEcou,'127.0.0.1',8888)
server=bucla.run_until_complete(c1)
try:
    bucla.run_forever()
except KeyboardInterrupt:
    pass
server.close()
bucla.run_until_complete(server.wait_closed())
bucla.close()

#client ecou utilizand tco-ip bazat pe asyncio

import asyncio as asy
class ClientEcou(asy.Protocol):
    def __init__(self,mesaj,bucla):
        self.mesaj=mesaj
        self.bucla=bucla
    def connection_made(self,transport):
        transport.write(self.mesaj.encode())
        print('Date trimise: {!r}'.format(self.mesaj))
    def data_received(self,data):
        print("Date primite: {!r}".format(data.decode()))
    def connection_lost(self,exc):
        print("Serverul a terminat conexiunea")
        print("Oprire bucla de evenimente")
        self.bucla.stop()

bucla=asy.get_event_loop()
mesaj='Am trimis ceva'
c=bucla.create_connection(lambda: ClientEcou(mesaj,bucla),'127.0.0.1',8888)
bucla.run_until_complete(c)
bucla.run_forever()
bucla.close()