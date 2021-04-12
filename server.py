# server.py
import socket
import sys

host = '192.168.1.4'    # IP Address
port = 8080             # Port Number
client_list = []

server_sock = socket.socket(socket.AF_INET)
server_sock.bind((host, port))
server_sock.listen(1)


print("Waiting for connection...")
client_sock, addr = server_sock.accept()
print('Connected by', addr)

while True:
    data = client_sock.recv(1024)
    if not data:
        break
    print(data.decode())