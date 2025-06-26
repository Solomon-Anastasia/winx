from tkinter import *
from queue import LifoQueue


class Drawer(Frame):
    def __init__(self, root, **kw):
        super().__init__(**kw)
        self.root = root
        self.stack = LifoQueue()
        self.canvas = Canvas(root, width=500, height=500)
        self.canvas.grid(row=1, column=0)
        self.canvas.bind('<Button-1>', self.addPoint)
        self.label = Label(self.canvas, text="Label lol")
        self.label.place(relx=0.5, rely=0.05, anchor=CENTER)
        self.buttonQuit = Button(self.root, text="Quit", padx=20, pady=20, command=self.quit).grid(row=0, column=0)
        self.buttonClear = Button(self.root, text="Clear", padx=20, pady=20, command=self.clear).grid(row=0, column=1)
        #self.canvas.pack()

    def addPoint(self, event):
        self.label.configure(text="Am pus un punct la " + str(event.x) + " si " + str(event.y))
        if not self.stack.empty():
            point1 = self.stack.get()
            self.canvas.create_line(point1[0], point1[1], event.x, event.y)
            # self.canvas.pack()
        self.stack.put((event.x, event.y))

    def quit(self):
        import sys
        sys.exit()

    def clear(self):
        self.label.configure(text="Am sters tot!")
        self.canvas.delete("all")
        #self.canvas.pack()
        while not self.stack.empty():
            self.stack.get()


def main():
    root = Tk()
    root.title("cod maimuta")
    drawer = Drawer(root)
    root.mainloop()


if __name__ == '__main__':
    main()