from Handler import Handler
class ManagerHandler(Handler):
    left : Handler
    right : Handler
    vertical: Handler
    def handleRequest(self, forwardDirection: str, messageToBeProcessed: str):
        msg = messageToBeProcessed.split(":")
        priority = msg[0]
        request = msg[1]
        if forwardDirection == "right":
            if priority == "3":
                print("Sunt Manager si prelucrez mesajul: "+ str(request))
                if self.vertical is not None:
                    self.vertical.handleRequest("vertical",str(priority) + ": Mesajul"+ str(request)+" a fost prelucrat de catre Manager.")
                else:
                    if self.left is not None:
                        self.left.handleRequest("left", str(priority) + ": Mesajul"+ str(request)+" a fost prelucrat de catre Manager.")
            else:
                print("Sunt Manager si nu am putut procesa mesajul"+str(request))
                if self.right is not None:
                    self.right.handleRequest("right",messageToBeProcessed)
        if forwardDirection == "vertical":
            print("Sunt Manager si transmit mai departe rezultatul unei prelucrari: " + str(request))
            if self.vertical is not None:
                self.vertical.handleRequest("vertical", messageToBeProcessed)
            else:
                if self.left is not None:
                    self.left.handleRequest("left",messageToBeProcessed)
        if forwardDirection == "left":
            print("Sunt Manager si transmit mai departe rezultatul unei prelucrari: " + str(request))
            if self.left is not None:
                self.left.handleRequest("left",messageToBeProcessed)
    def SetRight(self,right):
        self.right = right
    def SetLeft(self,left):
        self.left = left
    def SetVertical(self,vertical):
        self.vertical = vertical