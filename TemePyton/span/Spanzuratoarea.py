import tkinter as tk
from tkinter import messagebox
import random


class HangmanGame:
    def __init__(self, root):
        self.root = root
        self.root.title("Spânzurătoarea - Hangman")

        self.WORDS = ["calculator", "python", "kotlin", "programare", "fereastra", "algorithm", "spanzuratoare"]
        self.word = random.choice(self.WORDS)
        self.guessed = ["_"] * len(self.word)
        self.errors = 0

        # --- GUI widgets ---
        self.canvas = tk.Canvas(root, width=200, height=200)
        self.canvas.grid(row=0, column=0, columnspan=8)

        self.label_word = tk.Label(root, text=" ".join(self.guessed), font=("Helvetica", 16))
        self.label_word.grid(row=1, column=0, columnspan=8, pady=10)

        self.result_label = tk.Label(root, text="", font=("Helvetica", 12))
        self.result_label.grid(row=3, column=0, columnspan=8)

        self.letter_buttons = []
        letters = "abcdefghijklmnopqrstuvwxyz"
        for idx, letter in enumerate(letters):
            b = tk.Button(root, text=letter, width=3, command=lambda l=letter: self.guess(l))
            b.grid(row=2 + idx // 8, column=idx % 8)
            self.letter_buttons.append(b)

        self.restart_button = tk.Button(root, text="Restart", width=10, command=self.restart, state="disabled")
        self.restart_button.grid(row=6, column=0, columnspan=8, pady=10)

        self.update_display()

    def draw_hangman(self):
        c = self.canvas
        c.delete("all")
        c.create_line(10, 180, 150, 180)  # base
        c.create_line(80, 180, 80, 20)
        c.create_line(80, 20, 140, 20)
        c.create_line(140, 20, 140, 40)
        if self.errors > 0:
            c.create_oval(120, 40, 160, 80)  # head
        if self.errors > 1:
            c.create_line(140, 80, 140, 120)  # body
        if self.errors > 2:
            c.create_line(140, 90, 120, 110)  # left arm
        if self.errors > 3:
            c.create_line(140, 90, 160, 110)  # right arm
        if self.errors > 4:
            c.create_line(140, 120, 120, 150)  # left leg
        if self.errors > 5:
            c.create_line(140, 120, 160, 150)  # right leg

    def update_display(self):
        self.label_word.config(text=" ".join(self.guessed))
        self.draw_hangman()
        self.root.update_idletasks()

    def guess(self, letter):
        if self.errors >= 6 or "_" not in self.guessed:
            return
        found = False
        for i, l in enumerate(self.word):
            if l == letter:
                self.guessed[i] = letter
                found = True
        if not found:
            self.errors += 1
        self.update_display()
        self.check_game_end()

    def check_game_end(self):
        if "_" not in self.guessed:
            messagebox.showinfo("Game Over", "Felicitări! Ai câștigat!")
            self.result_label.config(text="Felicitări! Ai câștigat!")
            self.disable_buttons()
        elif self.errors >= 6:
            messagebox.showinfo("Game Over", f"Ai pierdut! Cuvântul era: {self.word}")
            self.result_label.config(text=f"Ai pierdut! Cuvântul era: {self.word}")
            self.disable_buttons()

    def disable_buttons(self):
        for b in self.letter_buttons:
            b.config(state="disabled")
        self.restart_button.config(state="normal")

    def restart(self):
        self.word = random.choice(self.WORDS)
        self.guessed = ["_"] * len(self.word)
        self.errors = 0
        self.result_label.config(text="")
        for b in self.letter_buttons:
            b.config(state="normal")
        self.restart_button.config(state="disabled")
        self.update_display()


# --- Main execution ---
if __name__ == "__main__":
    root = tk.Tk()
    game = HangmanGame(root)
    root.mainloop()
