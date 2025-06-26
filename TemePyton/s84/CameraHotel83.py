from typing import List, Callable
from functools import wraps
from collections import deque


# ------------------ Updated Room Class ------------------
class Room:
    def __init__(self, number: int, room_type: str, price: float):
        self.number = number
        self.room_type = room_type
        self.price = price
        self.is_available = True

    def reserve(self):
        if self.is_available:
            self.is_available = False
            return True
        return False

    def checkout(self):
        self.is_available = True

    def __repr__(self):
        return (f"Room {self.number}: "
                f"{self.room_type}, ${self.price}, "
                f"{'Available' if self.is_available else 'Booked'}")


# ------------------ ADT RoomRegistry ------------------
class RoomRegistry:
    def __init__(self):
        self.rooms: List[Room] = []

    def add_room(self, room_reg: Room):
        self.rooms.append(room_reg)

    def find_available(self, room_type: str):
        return next((r for r in self.rooms if r.room_type == room_type and r.is_available), None)


# ------------------ Checkout Function ------------------
def checkout_room(registry: RoomRegistry, room_number: int):
    for room in registry.rooms:
        if room.number == room_number:
            if not room.is_available:
                room.checkout()
                print(f"[CHECKOUT] Room {room.number} is now available.")
                return True
            else:
                print(f"[INFO] Room {room.number} was already available.")
                return False
    print(f"[ERROR] Room {room_number} not found.")
    return False


# ------------------ Waiting List ------------------
class WaitingList:
    def __init__(self):
        self.queue = deque()

    def add(self, guest_name: str, room_type: str):
        self.queue.append((guest_name, room_type))

    def process(self, room_registry: RoomRegistry):
        for _ in range(len(self.queue)):
            guest_name, room_type = self.queue.popleft()
            is_room_available = room_registry.find_available(room_type)
            if is_room_available:
                is_room_available.reserve()
                print(f"[WAITLIST] Guest {guest_name} got a room: {is_room_available}")
            else:
                self.queue.append((guest_name, room_type))
                break


waiting_list = WaitingList()


# ------------------ Decorator ------------------
def handle_waitlist(func: Callable):
    @wraps(func)
    def wrapper(*args, **kwargs):
        success = func(*args, **kwargs)
        if not success:
            guest_name = kwargs.get("guest_name")
            room_type = kwargs.get("room_type")
            print(f"[WAITLIST] No room available for {guest_name}. Added to waiting list.")
            waiting_list.add(guest_name, room_type)
        return success

    return wrapper


# ------------------ Booking Function ------------------
@handle_waitlist
def book_room(registry: RoomRegistry, room_type: str, guest_name: str):
    room = registry.find_available(room_type)
    if room and room.reserve():
        print(f"[BOOKED] Guest {guest_name} reserved Room {room.number}")
        return True
    return False


# ------------------ Demo ------------------
if __name__ == "__main__":
    registry = RoomRegistry()
    registry.add_room(Room(101, "single", 100))
    registry.add_room(Room(102, "double", 150))
    registry.add_room(Room(103, "single", 100))

    book_room(registry, room_type="single", guest_name="Alice")
    book_room(registry, room_type="single", guest_name="Bob")
    book_room(registry, room_type="single", guest_name="Charlie")  # goes to waitlist
    book_room(registry, room_type="double", guest_name="Marie")  # goes to waitlist

    print("\n--- Cancelling one room manually (simulating checkout) ---")
    registry.rooms[0].is_available = True
    registry.rooms[1].is_available = True

    print("\n--- Processing Waitlist ---")
    waiting_list.process(registry)

    print("\n--- Final Room States ---")
    for room in registry.rooms:
        print(room)
