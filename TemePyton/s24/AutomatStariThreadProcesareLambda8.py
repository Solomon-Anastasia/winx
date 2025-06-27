import threading
import time


class Automaton:
    def __init__(self, numbers):
        self.numbers = numbers
        self.lock = threading.Lock()
        self.running = True

        # Define lambda expressions for even and odd deletion
        self.delete_even = lambda: self._delete(lambda x: x % 2 == 0)
        self.delete_odd = lambda: self._delete(lambda x: x % 2 != 0)

    def _delete(self, condition):
        with self.lock:
            for i, num in enumerate(self.numbers):
                if condition(num):
                    removed = self.numbers.pop(i)
                    print(f"Deleted: {removed}")
                    return True
        return False

    def s0(self):
        print("From s0\n")
        while self.running:
            with self.lock:
                if not self.numbers:
                    print("List is empty. Terminating.")
                    self.running = False
                    return
            time.sleep(0.5)
            self.s1()

    def s1(self):
        print("From s1\n")
        if self.delete_even():
            time.sleep(0.5)
            self.s2()
        else:
            self.s0()

    def s2(self):
        print("From s2\n")
        if self.delete_odd():
            time.sleep(0.5)
            self.s0()
        else:
            self.s0()


def main():
    # Example number list
    numbers = [2, 4, 5, 7, 8, 9]

    automaton = Automaton(numbers)

    # Create thread for s0 state to start automaton
    t0 = threading.Thread(target=automaton.s0)
    t0.start()
    t0.join()


if __name__ == "__main__":
    main()
