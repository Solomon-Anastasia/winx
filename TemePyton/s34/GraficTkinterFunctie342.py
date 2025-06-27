import tkinter as tk
from tkinter import ttk
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg


def calculate_sequence():
    x_vals = []
    y_vals = []

    for n in range(1, 100):  # Try reasonable range
        S = n + sum(range(n))
        if 20 < S <= 50:
            x_vals.append(n)
            y_vals.append(S)

    return x_vals, y_vals


def main():
    # --- Calculate data ---
    x, y = calculate_sequence()

    # --- GUI setup ---
    root = tk.Tk()
    root.title("Py342 Sequence Graph")

    # --- Create figure ---
    fig, ax = plt.subplots(figsize=(5, 4))
    ax.plot(x, y, marker='o')
    ax.set_title("S = n + sum(0 to n-1)")
    ax.set_xlabel("n")
    ax.set_ylabel("S")

    # --- Embed in Tkinter ---
    canvas = FigureCanvasTkAgg(fig, master=root)
    canvas.draw()
    canvas.get_tk_widget().pack()

    # --- Display final sum and n ---
    if y:
        final_S = y[-1]
        final_n = x[-1]
    else:
        final_S = "N/A"
        final_n = "N/A"

    frame = ttk.Frame(root)
    frame.pack(pady=10)

    ttk.Label(frame, text=f"Final S: {final_S}").pack()
    ttk.Label(frame, text=f"Final n: {final_n}").pack()

    root.mainloop()


if __name__ == "__main__":
    main()
