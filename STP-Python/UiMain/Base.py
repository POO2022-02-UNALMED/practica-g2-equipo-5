from tkinter import *
class Base:
    def __init__(self,master,tittle = '',a=None) -> None:
        self.fr = Frame(master, width=800, height=500)
        self.cenFrame = Frame(self.fr, width=800, height=470)
        self.cenFrame.pack()
        self.fr.place(x=0,y=0)
        self.a = tittle
        self.header(tittle)
        if a==None:
            self.footer()
   
    def header(self,tittle):
        Tittle = Label(self.fr, text=tittle, fg="#000028", font=("Inter", 10), bg="#23d2aa")
        Tittle.place(x = 5, y = 5, width=790, height=30)

    def footer(self):
        def cancelar():
            self.fr.destroy()
        #Barra inferior
        infFrame = Frame(self.fr, width=790, height=30)
        infFrame.pack()
        
        #Botones
        bGuardarEM = Button(infFrame, text="GUARDAR", bg="#000028", fg="white", font=("Inter", 11))
        bGuardarEM.place(width=400, height=30, x = 0, y = 0)
        bVolverM = Button(infFrame, text="CANCELAR", bg="#000028", fg="white", font=("Inter", 11), command=cancelar)
        bVolverM.place(width=400, height=30, x = 400, y = 0)
