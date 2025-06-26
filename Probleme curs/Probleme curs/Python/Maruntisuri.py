#Maruntisuri

import socket as sk
DIM_BUFF_SEND =4096
DIM_BUFF_RECV=4096

def test_socket_timeout():
    s=sk.socket(sk.AF_INET,sk.SOCK_STREAM)
    print("Timp maxim de asteptare: %s"%s.gettimeout())
    s.settimeout(100)
    print("Timp de asteptare curent: %s"%s.gettimeout())
def modific_dim_buffer(trimite,receptie):
    sock =sk.socket(sk.AF_INET,sk.SOCK_STREAM)
    bufsize =sock.getsockopt(sk.SOL_SOCKET,sk.SO_SNDBUF)
    print("Dimensiune tampon inainte de modificare: %d"%bufsize)
    sock.setsockopt(sk.SOL_TCP,sk.TCP_NODELAY,1)
    sock.setsockopt(sk.SOL_SOCKET, sk.SO_SNDBUF, trimite)
    sock.setsockopt(sk.SOL_SOCKET, sk.SO_RCVBUF, receptie)
    bufsize=sock.getsockopt(sk.SOL_SOCKET,sk.SO_SNDBUF)
    print("Dimenisiune tampon dupa modificare: %d"% bufsize)

if __name__=='__main__':
    test_socket_timeout()
    modific_dim_buffer(DIM_BUFF_SEND,DIM_BUFF_RECV)