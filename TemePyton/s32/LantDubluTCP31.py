import threading
import socket
import time

# --- Node Server Thread ---
class NodeServer(threading.Thread):
    def __init__(self, host, port, next_host, next_port, process_function, name):
        super().__init__()
        self.host = host
        self.port = port
        self.next_host = next_host
        self.next_port = next_port
        self.process_function = process_function
        self.name = name

    def run(self):
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            s.bind((self.host, self.port))
            s.listen()
            print(f"[{self.name}] listening on port {self.port}...")
            while True:
                conn, addr = s.accept()
                with conn:
                    data = conn.recv(1024).decode()
                    if not data:
                        continue
                    print(f"[{self.name}] Received: {data}")
                    result = self.process_function(data)

                    if self.next_port:
                        # Pass to next node
                        result = self.pass_to_next(result)

                    conn.sendall(result.encode())

    def pass_to_next(self, message):
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            s.connect((self.next_host, self.next_port))
            s.sendall(message.encode())
            data = s.recv(1024).decode()
            print(f"[{self.name}] Received back from next: {data}")
            return data

# --- Processing functions ---
def process_node1(data):
    return f"Node1({data})"

def process_node2(data):
    return f"Node2({data})"

def process_node3(data):
    return f"Node3({data})"

# --- Client function ---
def client_send(host, port, message):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((host, port))
        s.sendall(message.encode())
        data = s.recv(1024).decode()
        print(f"[CLIENT] Final response: {data}")

# --- Main function ---
def main():
    host = "localhost"

    # --- Node3: final handler ---
    node3 = NodeServer(host, 9003, None, None, process_node3, "Node3")
    node3.start()

    time.sleep(1)  # Ensure node3 is up

    # --- Node2: middle handler, passes to node3 ---
    node2 = NodeServer(host, 9002, host, 9003, process_node2, "Node2")
    node2.start()

    time.sleep(1)  # Ensure node2 is up

    # --- Node1: first handler, passes to node2 ---
    node1 = NodeServer(host, 9001, host, 9002, process_node1, "Node1")
    node1.start()

    time.sleep(1)  # Ensure node1 is up

    # --- Client sends to Node1 ---
    print("\n[CLIENT] Sending initial message...")
    client_send(host, 9001, "HelloChain")

    # Keep servers alive
    while True:
        time.sleep(10)

# --- Run ---
if __name__ == "__main__":
    main()
