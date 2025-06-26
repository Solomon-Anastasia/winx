from abc import ABC, abstractmethod
from logging import Handler


class Handler(ABC):
    @abstractmethod
    def handleRequest(self,forwardDirection, messageToBeProcessed):
        pass
    def SetRight(self,right):
        pass
    def SetLeft(self,left):
        pass
    def SetVertical(self,vertical):
        pass