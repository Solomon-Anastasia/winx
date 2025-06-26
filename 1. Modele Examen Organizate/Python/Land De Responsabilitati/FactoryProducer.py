from EliteFactory import EliteFactory
from Handler import Handler
from AbstractFactory import AbstractFactory
from HappyWorkFactory import HappyWorkerFactory
class FactoryProducer(AbstractFactory):
    def getHandler(self, choice: str) -> Handler:
        if choice == "Elite":
            return EliteFactory()
        else:
            return HappyWorkerFactory()
