#Modelul automatului finit
class State(object):
    def scan(self):
        self.pos +=1
        if self.pos == len(self.stations):
            self.pos=0
        print(u"Caut..Am gasit o statie la %s in banda %s"%(self.stations[self.pos],self.name))
class AmState(State):
    def __init__(self,radio):
        self.radio=radio
        self.stations=["1250","1380","1510"]
        self.pos=0
        self.name="AM"
    def toggle_amfm(self):
        print(u"Comutare in banda FM")
        self.radio.state=self.radio.fmstate
class FmState(State):
    def __init__(self,radio):
        self.radio=radio
        self.stations=["81.3","89.1","103.9"]
        self.pos=0
        self.name="FM"
    def toggle_amfm(self):
        print(u"Comutare in banda AM")
        self.radio.state=self.radio.amstate
class Radio(object):
    def __init__(self):
        self.amstate=AmState(self)
        self.fmstate=FmState(self)
        self.state=self.amstate
    def toggle_amfm(self):
        self.state.toggle_amfm()
    def scan(self):
        self.state.scan()
def main():
    radio=Radio()
    actions=[radio.scan]*2+[radio.toggle_amfm]+[radio.scan]*2
    actions *=2
    for action in actions:
        action()
if __name__ =='__main__':
    main()