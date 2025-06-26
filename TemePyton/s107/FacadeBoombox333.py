# Subsystem: TapeDeck
class TapeDeck:
    def __init__(self):
        self.tape_position = 0  # in seconds
        self.is_playing = False
        self.is_recording = False

    def play(self):
        self.is_playing = True
        print("Playing cassette...")

    def record(self):
        self.is_recording = True
        print("Recording on cassette...")

    def fast_forward(self):
        self.tape_position += 30
        print(f"Fast forwarding cassette to position {self.tape_position} seconds...")

    def rewind(self):
        self.tape_position = max(0, self.tape_position - 30)
        print(f"Rewinding cassette to position {self.tape_position} seconds...")


# Subsystem: Radio
class Radio:
    def __init__(self):
        self.is_on = False
        self.current_station = None

    def on(self):
        self.is_on = True
        print("Radio turned ON.")

    def off(self):
        self.is_on = False
        print("Radio turned OFF.")

    def tune(self, station):
        self.current_station = station
        print(f"Tuned to station {station} FM.")


# Subsystem: Speaker
class Speaker:
    def __init__(self):
        self.volume_level = 5  # Default volume

    def set_volume(self, level):
        self.volume_level = max(0, min(level, 10))  # Keep volume in the 0 – 10 range
        print(f"Volume set to {self.volume_level}.")


# Subsystem: Battery
class Battery:
    def __init__(self):
        self.percentage = 80

    def check_status(self):
        print(f"Battery at {self.percentage}%.")


# Facade: Boombox
class Boombox:
    def __init__(self):
        self.tape_deck = TapeDeck()
        self.radio = Radio()
        self.speaker = Speaker()
        self.battery = Battery()

    def play_music(self):
        self.tape_deck.play()

    def start_recording(self):
        self.tape_deck.record()

    def fast_forward_tape(self):
        self.tape_deck.fast_forward()

    def rewind_tape(self):
        self.tape_deck.rewind()

    def play_radio(self, station):
        self.radio.on()
        self.radio.tune(station)

    def stop_radio(self):
        self.radio.off()

    def set_volume(self, level):
        self.speaker.set_volume(level)

    def check_battery(self):
        self.battery.check_status()


# Sample usage
if __name__ == "__main__":
    bb = Boombox()
    bb.check_battery()
    bb.set_volume(7)
    bb.play_music()
    bb.play_radio("102.5")
    bb.stop_radio()
    bb.start_recording()
    bb.fast_forward_tape()
    bb.rewind_tape()
