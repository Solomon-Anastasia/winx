from abc import ABC, abstractmethod
from Handler import Handler
class AbstractFactory(ABC):
    @abstractmethod
    def getHandler(self,handler: str)-> Handler:
        pass
