from CEOHandle import CEOHandler
from ExecutiveHandler import ExecutiveHandler
from Handler import Handler
from AbstractFactory import AbstractFactory
from Manager import ManagerHandler
class EliteFactory(AbstractFactory):
    def getHandler(self,handler: str) -> Handler:
        if handler == "CEO":
            return CEOHandler()
        if handler == "Executive":
            return ExecutiveHandler()
        if handler == "Manager":
            return ManagerHandler()