from Handler import Handler
from AbstractFactory import AbstractFactory
from chain.HappyWorkHandler import HappyWorkerHandler
class HappyWorkerFactory(AbstractFactory):
    def getHandler(self,handler: str) -> Handler:
        if handler == "HappyWorker":
            return HappyWorkerHandler()
        else:
            return HappyWorkerHandler()