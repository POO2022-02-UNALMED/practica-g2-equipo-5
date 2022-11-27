from tkinter import *

class FieldFrame(Frame):
    def __init__(self, master, criterios = [], label = ""):
        self.label = label
        self.frameFecha = LabelFrame(master, text="FECHA", font=("Inter", 8))
        self.frameFecha.place(relwidth=1, relheight=1)
        self.criterios = criterios

        self.title = Label(self.frameFecha, text=self.label, font=("Inter", 8))
        self.title.pack(pady=(3,3))
        self.cont = Frame(self.frameFecha)
        self.cont.pack(pady=(3,3))

        self.entradas = []
        for i in range(len(self.criterios)):
            self.lab = Label(self.cont, text=self.criterios[i], font=("Inter", 8)).grid(row=i+1, column=0, padx=(3,3), pady=(3,3), columnspan=2)
            self.ent = Entry(self.cont, justify="center")
            self.ent.grid(row=i+1, column=3, padx=(3,3), pady=(3,3), columnspan=2)
            self.entradas.append(self.ent)

    def getEntradas(self):
        lResultados = []
        for i in self.entradas:
            lResultados.append(i.get())
        return lResultados

    def getValue(self, criterio):
        ind = self.criterios.index(criterio)
        lR = self.getEntradas()
        return lR[ind]