from abc import ABC, abstractmethod


# ------------------ Alert Object ------------------
class Alert:
    def __init__(self, level: int, message: str):
        self.level = level
        self.message = message


# ------------------ Handler Interface ------------------
class Handler(ABC):
    def __init__(self):
        self.next_handler: Handler | None = None

    def set_next(self, handler: 'Handler'):
        self.next_handler = handler
        return handler

    def handle(self, alert: Alert):
        if not self._handle(alert) and self.next_handler:
            self.next_handler.handle(alert)

    @abstractmethod
    def _handle(self, alert: Alert) -> bool:
        pass


# ------------------ Concrete Handlers ------------------
class GuardsHandler(Handler):
    def _handle(self, alert: Alert) -> bool:
        if alert.level == 5:
            print(f"[Guards] Handling alert: {alert.message}")
            return True
        return False


class PoliceHandler(Handler):
    def _handle(self, alert: Alert) -> bool:
        if alert.level == 4:
            print(f"[Police] Handling alert: {alert.message}")
            return True
        return False


class SRIHandler(Handler):
    def _handle(self, alert: Alert) -> bool:
        if alert.level == 3:
            print(f"[SRI] Handling alert: {alert.message}")
            return True
        return False


class SIEHandler(Handler):
    def _handle(self, alert: Alert) -> bool:
        if alert.level == 2:
            print(f"[SIE] Handling alert: {alert.message}")
            return True
        return False


class CSATHandler(Handler):
    def _handle(self, alert: Alert) -> bool:
        if alert.level == 1:
            print(f"[CSAT] Handling alert: {alert.message}")
            return True
        return False


class NATOHandler(Handler):
    def _handle(self, alert: Alert) -> bool:
        if alert.level == 0:
            print(f"[NATO] Handling alert: {alert.message}")
            return True
        return False


# ------------------ Demo ------------------
if __name__ == "__main__":
    # Set up the chain
    chain = GuardsHandler()
    chain.set_next(PoliceHandler()) \
        .set_next(SRIHandler()) \
        .set_next(SIEHandler()) \
        .set_next(CSATHandler()) \
        .set_next(NATOHandler())

    # Test alerts
    alerts = [
        Alert(5, "Perimeter breach"),
        Alert(3, "Suspicious activity"),
        Alert(0, "International cooperation"),
        Alert(1, "Internal protocol check")
    ]

    for alert in alerts:
        chain.handle(alert)
