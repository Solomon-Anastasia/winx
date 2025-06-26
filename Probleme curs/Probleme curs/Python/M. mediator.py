#Model Mediator
class ChatRoom(object):
    def display_message(self,user,message):
        print("[{} zice]: {}".format(user,message))

class user(object):
    def __init__(self,name):
        self.name=name
        self.chat_room=ChatRoom()

    def say(self,message):
        self.chat_room.display_message(self,message)

    def __str__(self):
        return self.name

def main():
    vasale =user('Vasale')
    tica= user('Tica2')
    altul=user('Altul')

    vasale.say("Echipa adunarea la ora 3 dupa amiaza!")
    tica.say("Da sefu pot sa astept pana atunci in fata usii?")
    altul.say("da' eu pot?")

if __name__=='__main__':
    main()