import tkinter as tk
from abc import ABC, abstractmethod


# --- Product Interface ---
class Button(ABC):
    @abstractmethod
    def create(self, master):
        pass


# --- Concrete Products ---
class EnglishButton(Button):
    def create(self, master):
        return tk.Button(master, text="Click Me")


class FrenchButton(Button):
    def create(self, master):
        return tk.Button(master, text="Cliquez-moi")


class GermanButton(Button):
    def create(self, master):
        return tk.Button(master, text="Klick mich")


# --- Abstract Factory for Buttons ---
class ButtonFactory(ABC):
    @abstractmethod
    def get_button(self) -> Button:
        pass


# --- Concrete Factories ---
class EnglishButtonFactory(ButtonFactory):
    def get_button(self):
        return EnglishButton()


class FrenchButtonFactory(ButtonFactory):
    def get_button(self):
        return FrenchButton()


class GermanButtonFactory(ButtonFactory):
    def get_button(self):
        return GermanButton()


# --- Factory of Factories ---
class LanguageFactory:
    @staticmethod
    def get_factory(language: str) -> ButtonFactory:
        factories = {
            "english": EnglishButtonFactory(),
            "french": FrenchButtonFactory(),
            "german": GermanButtonFactory()
        }
        return factories.get(language.lower(), EnglishButtonFactory())  # default to English


# --- Client Code ---
def main(language):
    root = tk.Tk()
    root.title("Factory of Factories Example")

    factory = LanguageFactory.get_factory(language)
    button = factory.get_button().create(root)
    button.pack(padx=20, pady=20)

    root.mainloop()


# Example usage:
if __name__ == "__main__":
    main("french")
