import multiprocessing
import time
from multiprocessing import Semaphore


# --- Circular Queue class ---
class CircularQueue:
    def __init__(self, capacity):
        self.capacity = capacity
        self.queue = [None] * capacity
        self.head = 0
        self.tail = 0
        self.size = 0

    def enqueue(self, item):
        if self.isFull():
            raise Exception("Queue is full")
        self.queue[self.tail] = item
        self.tail = (self.tail + 1) % self.capacity
        self.size += 1

    def dequeue(self):
        if self.isEmpty():
            raise Exception("Queue is empty")
        item = self.queue[self.head]
        self.head = (self.head + 1) % self.capacity
        self.size -= 1
        return item

    def isFull(self):
        return self.size == self.capacity

    def isEmpty(self):
        return self.size == 0

    def __str__(self):
        return str(self.queue)


# --- Process task function with semaphore for file writing ---
def process_task(name, sema, filename):
    print(f"{name} started.")
    time.sleep(1)

    with sema:  # ensure only one process writes at a time
        with open(filename, "a") as f:
            for i in range(3):
                f.write(f"{name} writing {i}\n")
                print(f"{name} wrote {i}")
                time.sleep(0.5)

    print(f"{name} finished.")


# --- Main program ---
def main():
    filename = "output.txt"
    open(filename, "w").close()  # clear file

    sema = Semaphore(1)

    queue_capacity = 4
    cq = CircularQueue(queue_capacity)

    # Enqueue initial task names
    for i in range(queue_capacity):
        task_name = f"Process-{i}"
        cq.enqueue(task_name)

    # Run circularly for 2 full cycles
    cycles = 2
    for c in range(cycles):
        print(f"\n--- Cycle {c + 1} ---")
        for _ in range(queue_capacity):
            task_name = cq.dequeue()

            # Start process
            p = multiprocessing.Process(target=process_task, args=(task_name, sema, filename))
            p.start()
            p.join()

            # Enqueue back to maintain circularity
            cq.enqueue(task_name)

    print("\nAll processes completed. Final file content:")
    with open(filename) as f:
        print(f.read())


if __name__ == "__main__":
    main()
