class Provider:
    def __init__(self):
        self.msg_queue =[]
        self.subscribers ={}
    def notify(self,msg):
        self.msg_queue.append(msg)
    def subscribe(self,msg,subscriber):
        self.subscribers.setdefault(msg,[]).append(subscriber)
    def unsubscribe(self,msg,subscriber):
        self.subscribers[msg].remove(subscriber)
    def update(self):
        for msg in self.msg_queue:
            for sub in self.subscribers.get(msg,[]):
                sub.run(msg)
        self.msg_queue=[]
class Publisher:
    def __init__(self,msg_center):
        self.provider =msg_center
    def publish(self,msg):
        self.provider.notify(msg)
class Subscriber:
    def __init__(self,name,msg_center):
        self.name=name
        self.provider =msg_center
    def subscribe(self,msg):
        self.provider.subscribe(msg,self)
    def unsubscribe(self,msg):
        self.provider.unsubscribe(msg,self)
    def run(self,msg):
        print("{} got {}".format(self.name,msg))

def main():
    message_center=Provider()
    fftv=Publisher(message_center)
    jim=Subscriber("jim",message_center)
    jim.subscribe("cartoon")
    jack = Subscriber("jack", message_center)
    jack.subscribe("music")
    gee = Subscriber("gee", message_center)
    gee.subscribe("movie")
    vani = Subscriber("vani", message_center)
    vani.subscribe("movie")
    vani.unsubscribe("movie")
    fftv.publish("cartoon")
    fftv.publish("music")
    fftv.publish("ads")
    fftv.publish("movie")
    fftv.publish("cartoon")
    fftv.publish("cartoon")
    fftv.publish("movie")
    fftv.publish("blank")
    message_center.update()

if __name__=='__main__':
    main()