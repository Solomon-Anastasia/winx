import threading

# --- Initialize data ---
X = {i: i * 2 for i in range(10)}  # Example hashmap X: {0:0, 1:2, ..., 9:18}
Y = {i: i + 1 for i in range(11)}  # Example dictionary Y: {0:1, 1:2, ..., 10:11}
# Note: Y has len(X)+1 elements to ensure Y[i+1] exists

# --- RLock for thread-safe operations ---
rlock = threading.RLock()


# --- Processing function ---
def process(i):
    with rlock:
        x = X[i]
        y_i = Y[i]
        y_ip1 = Y[i + 1]

        result = x * y_i + y_ip1
        Y[i] = result
        print(f"Thread {i}: x={x}, y[i]={y_i}, y[i+1]={y_ip1} -> result={result}")


# --- Main ---
def main():
    threads = []

    for i in X.keys():
        t = threading.Thread(target=process, args=(i,))
        threads.append(t)
        t.start()

    for t in threads:
        t.join()

    print("\nFinal Y dictionary:")
    for k, v in Y.items():
        print(f"{k} -> {v}")


if __name__ == "__main__":
    main()
