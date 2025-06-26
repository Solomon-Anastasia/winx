"""Facade pattern with an example of WashingMachine"""


class play:
    '''Subsystem # 1'''

    def play(self):
        print("playing...")


class record:
    '''Subsystem # 2'''

    def record(self):
        print("recording...")


class fastforward:
    '''Subsystem # 3'''

    def fastforward(self):
        print("fast forwarding...")


class rewind:
    '''Subsystem # 4'''

    def rewind(self):
        print("rewinding...")

class radio:
    '''Subsystem # 5'''

    def radio(self):
        print("switching to radio...")

class volumeup:
    '''Subsystem # 6'''

    def volumeup(self):
        print("volume level up...")

class volumedown:
    '''Subsystem # 7'''

    def volumedown(self):
        print("volume level up...")

class batterystats:
    '''Subsystem # 8'''

    def batterystats(self):
        print("volume level up...")

class Boombox:
    '''Facade'''

    def __init__(self):
        #initializare metode n shit
        self.playing = play()
        self.recording = record()
        self.fastforwarding = fastforward()
        self.rewind = rewind()
        self.radio = radio()
        self.volumeup = volumeup()
        self.volumedown = volumedown()
        self.batterystatus = batterystats()

    def startplaying(self):
        self.volumeup.volumeup()
        self.playing.play()

    def startrecording(self):
        self.volumeup.volumeup()
        self.recording.record()
        self.playing.play()

    def switchtoradio(self):
        self.radio.radio()
        self.playing.play()

    def volumetoggle(self):
        self.volumeup.volumeup()
        self.volumedown.volumedown()

    def batterystats(self):
        self.batterystatus.batterystats()


def main():
    monkemusic = Boombox()
    monkemusic.startplaying()


if __name__ == "__main__":
    main()