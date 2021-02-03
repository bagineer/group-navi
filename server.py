# server.py
import socket

host = '192.168.1.4'    # IP Address
port = 8080             # Port Number

server_sock = socket.socket(socket.AF_INET)
server_sock.bind((host, port))
server_sock.listen(1)

print("Waiting for connection...")
client_sock, addr = server_sock.accept()
print('Connected by', addr)