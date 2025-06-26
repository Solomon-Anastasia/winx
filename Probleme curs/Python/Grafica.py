from tkinter import*
master =TK()
w=Canvas(master,width=200,height=100)
w.pack()
w.create_line(0,0,200,100)
l=w.create_line(0,100,200,0,fill="red",dash=(4,4))
r=w.create_rectangle(50,25,150,75,fill="blue")
mainloop()
#pt modif directe
w.itemconfig(r,fill"red")
w.delete(l) #w.delete(ALL)