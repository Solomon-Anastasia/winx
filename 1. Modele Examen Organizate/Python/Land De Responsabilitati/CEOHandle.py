from Handler import Handler
class CEOHandler(Handler):
    right: Handler = None
    vertical: Handler = None
    def handleRequest(self, forwardDirection, messageToBeProcessed):
        msg = messageToBeProcessed.split(":")
        priority = msg[0]
        request = msg[1]
        if forwardDirection == "right":
            if priority == "1":
                print("Sunt CEO si prelucrez mesajul: "+ str(request)+ "....")
                if self.vertical is not None:
                    self.vertical.handleRequest("vertical", str(priority) + ":Mesajul a fost prelucrat de catre  CEO.")
            else:
                if self.right is not None:
                    self.right.handleRequest("right",messageToBeProcessed)
        if forwardDirection == "vertical" or forwardDirection == "left":
            print("Sunt  CEO  si transmit mai departe rezultatul unei prelucrari: " + str(request))
            if self.vertical is not None:
                self.vertical.handleRequest("vertical", messageToBeProcessed)
            else:
                print("Sunt CEO si am primit rezultatul unei prelucrari"+str(messageToBeProcessed))
    def SetRight(self,right):
        self.right = right
    def SetLeft(self,left):
        pass
    def SetVertical(self,vertical):
        self.vertical = vertical