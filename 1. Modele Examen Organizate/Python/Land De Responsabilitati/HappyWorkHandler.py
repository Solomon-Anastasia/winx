from Handler import Handler
class HappyWorkerHandler(Handler):
    left : Handler
    right : Handler
    vertical: Handler
    def handleRequest(self, forwardDirection: str, messageToBeProcessed: str):
        msg = messageToBeProcessed.split(":")
        priority = msg[0]
        request = msg[1]
        if forwardDirection == "right":
            if priority == "4":
                print("Sunt HappyWorker si prelucrez mesajul: "+ str(request))
                if self.vertical is not None:
                    self.vertical.handleRequest("vertical", str(priority) + ": Mesajul"+ str(request)+" a fost prelucrat de catre HappyWorker.")
                else:
                    if self.left is not None:
                        self.left.handleRequest("left", str(priority) + ":Mesajul"+ str(request)+" a fost prelucrat de catre HappyWorker.")
            else:
                print("Sunt HappyWorker si nu am putut procesa mesajul"+str(request))
                if self.vertical is not None:
                    self.vertical.handleRequest("vertical", str(priority)+":Mesajul nu a putut fi procesat")
                else:
                    if self.left is not None:
                        self.left.handleRequest("left", str(priority)+":Mesajul nu a putut fi procesat")
        if forwardDirection == "vertical":
            print("Sunt HappyWorker si transmit mai departe rezultatul unei prelucrari: " + str(request))
            if self.vertical is not None:
                self.vertical.handleRequest("vertical", messageToBeProcessed)
            else:
                if self.left is not None:
                    self.left.handleRequest("left",messageToBeProcessed)
        if forwardDirection == "left":
            print("Sunt HappyWorker si transmit mai departe rezultatul unei prelucrari: " + str(request))
            if self.left is not None:
                self.left.handleRequest("left",messageToBeProcessed)
    def SetRight(self,right):
        self.right = right
    def SetLeft(self,left):
        self.left = left
    def SetVertical(self,vertical):
        self.vertical = vertical