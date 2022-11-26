from tkinter import *
class Base:
    def __init__(self,master,tittle = '',a=None) -> None:
        self.fr = Frame(master, width=1090, height=835)
        self.cenFrame = Frame(self.fr, width=1090, height=785)
        self.cenFrame.pack()
        self.fr.place(x=0,y=0)
        self.a = tittle
        self.header(tittle)
        if a==None:
            self.footer()
   
    def header(self,tittle):
        frameTittle = LabelFrame(self.cenFrame, width=1070, height=80, bg="#23d2aa")
        frameTittle.place(x=10, y=10)
        Tittle = Label(frameTittle, text=tittle, fg="#000028", font=("Inter", 15), bg="#23d2aa")
        Tittle.place(x = 0, y = 0, width=1070, height=70)

    def footer(self):
        def cancelar():
            self.fr.destroy()
        #Barra inferior
        infFrame = Frame(self.fr, width=1090, height=50)
        infFrame.pack()
        #Botones
        
        bGuardarEM = Button(infFrame, text="GUARDAR", bg="#000028", fg="white", font=("Inter", 11))
        bGuardarEM.place(width=544, height=50, x = 0, y = 0)
        bVolverM = Button(infFrame, text="CANCELAR", bg="#000028", fg="white", font=("Inter", 11), command=cancelar)
        bVolverM.place(width=544, height=50, x = 544, y = 0)
