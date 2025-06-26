# clasa mediator
class Musuroi(object):
    def display_message(self, user, message):
        print("{} zice: {}".format(user.name, message))
        # print(f'{user.name} zice {message}')


class Furnica(object):
    def __init__(self, name):
        self.name = name
        self.musuroi = Musuroi()

    def say(self, message):
        self.musuroi.display_message(self, message)

    def str(self):
        return self.name


def main():

    vasile = Furnica('Vasile')
    tica = Furnica('Tica')
    altul = Furnica('Altul')

    vasile.say("Sa luam mancare!")
    tica.say("Drum bun baetii!")
    altul.say("Ajutor! Mike ma executa cu tunu!!")


if __name__ == '__main__':
    main()
