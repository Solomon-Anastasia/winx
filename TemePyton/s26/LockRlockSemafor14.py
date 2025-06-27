import threading
import time

# --- Shared file name ---
file_name = "output.txt"

# --- Shared lock, rlock, semaphore ---
lock = threading.Lock()
rlock = threading.RLock()
semaphore = threading.Semaphore(2)  # max 2 threads can write simultaneously


# --- Function using Lock ---
def write_with_lock(thread_id):
    for _ in range(2):
        print(f"[Lock] Thread {thread_id} waiting for lock...")
        with lock:
            with open(file_name, "a") as f:
                f.write(f"[Lock] Thread {thread_id} writing\n")
                time.sleep(0.5)
        print(f"[Lock] Thread {thread_id} released lock.")


# --- Function using RLock (reentrant lock) ---
def write_with_rlock(thread_id):
    print(f"[RLock] Thread {thread_id} acquiring rlock first time")
    with rlock:
        print(f"[RLock] Thread {thread_id} acquired rlock first time")
        inner_rlock(thread_id)


def inner_rlock(thread_id):
    print(f"[RLock] Thread {thread_id} acquiring rlock second time")
    with rlock:
        with open(file_name, "a") as f:
            f.write(f"[RLock] Thread {thread_id} writing\n")
            time.sleep(0.5)
        print(f"[RLock] Thread {thread_id} released rlock second time")


# --- Function using Semaphore ---
def write_with_semaphore(thread_id):
    print(f"[Semaphore] Thread {thread_id} waiting for semaphore...\n")
    with semaphore:
        with open(file_name, "a") as f:
            f.write(f"[Semaphore] Thread {thread_id} writing\n")
            time.sleep(0.5)
    print(f"[Semaphore] Thread {thread_id} released semaphore.\n")


# --- Main driver ---
if __name__ == "__main__":
    # Clear file
    open(file_name, "w").close()

    print("==== Using Lock ====")
    threads = []
    for i in range(3):
        t = threading.Thread(target=write_with_lock, args=(i,))
        threads.append(t)
        t.start()

    for t in threads:
        t.join()

    print("\n==== Using RLock ====")
    threads = []
    for i in range(3):
        t = threading.Thread(target=write_with_rlock, args=(i,))
        threads.append(t)
        t.start()

    for t in threads:
        t.join()

    print("\n==== Using Semaphore ====")
    threads = []
    for i in range(3):
        t = threading.Thread(target=write_with_semaphore, args=(i,))
        threads.append(t)
        t.start()

    for t in threads:
        t.join()

    print("\nDone. Check output.txt")
