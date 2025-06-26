class Camera():
    def operation(self):
        pass


class ConcreteCamera(Camera):
    def operation(self):
        print('Camera nu dispune de bar')
        # return "ConcreteCamera"


class Decorator(Camera):
    _camera: Camera = None

    def __init__(self, camera: Camera, price):
        self._camera = camera
        self.alcohol_price = price

    @property
    def component(self):
        return self._camera

    def operation(self):
        return self._camera.operation()


class ConcreteDecoratorA(Decorator):
    def operation(self):
        print(f'In bar au fost urmatoarele cheltuieli: {self.alcohol_price}')
        # return "DecoratedCamera"


def generare_plata(component: Camera):
    component.operation()


def main():
    '''
    Componenta
    ComponentaConcreta == Camera
    Decorator
    DecoratorConcretA = Decorator specific, pot face A, B, C... dar sa aiba implementari diferite == Consum_Bar
    
    '''

    # camere concrete
    camera1 = ConcreteCamera()
    camera2 = ConcreteCamera()
    camera3 = ConcreteCamera()

    # inainte de a decora camerele cu bar
    camere_hotel = [camera1, camera2, camera3]
    for camera in camere_hotel:
        generare_plata(camera)
    print()

    # decorez camera2 cu bar
    camera_decorata1 = ConcreteDecoratorA(camera1, 24)
    camera_decorata2 = ConcreteDecoratorA(camera2, 0)
    camere_hotel[0] = camera_decorata1
    camere_hotel[1] = camera_decorata2

    for camera in camere_hotel:
        generare_plata(camera)


if __name__ == '__main__':
    main()