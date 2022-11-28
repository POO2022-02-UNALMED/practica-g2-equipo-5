from gestionAplicacion.Destinos.Conexion import Conexion
from tkinter import *
from tkinter import messagebox, ttk
from gestionAplicacion.Destinos.Ruta import *
from .ErrorAplicacion import *
from .Base import *
class GenerarRuta(Base):
    CIUDADES = [
            "MEDELLÍN","BOGOTÁ","BUCARAMANGA","SANTA MARTA",
            "BARRANQUILLA","CARTAGENA","QUIBDÓ","PEREIRA",
            "CALI","SAN JOSÉ DEL GUAVIARE"
        ]
    def __init__(self,master,usuario) -> None:
        super().__init__(master,"GENERAR RUTA")
        self.usuario = usuario
        self.footer()
        self.genRuta()

    def guardar(self):
        r=self.rutas[self.opcion.get()][1]
        ru = Ruta(r[0],r[1],r[2],r[3])
        self.asignar(ru)
        self.cancelar()

    def asignar(self,ruta):
        self.usuario.setRuta(ruta)

    def limpiar(self):
        for el1 in self.fr2.winfo_children():
            el1.destroy()
        for el2 in self.fr3.winfo_children():
            el2.destroy()
        self.check2.set(False)
        self.check1.set(False)
        self.c1.set('')
        self.c2.set('')

    def genRuta(self):
        self.check1 = BooleanVar()
        self.check2 = BooleanVar()
        self.opcion = IntVar()
        def verDetalle(): 
            Label(self.fr3,text=self.rutas[self.opcion.get()][0][1]).place(relx=.5,rely=.5,anchor=CENTER)
        def est():
            if not self.check1.get():
                btDet = Button(self.fr2,text="DETALLE",bg="#000028", fg="white", font=("Inter", 11),command=verDetalle)
                btDet.place(relx=.5,rely=.7,anchor = CENTER)

                self.check1.set(True)
        def ru():
            origen = self.c1.get()
            destino = self.c2.get()
            if origen == destino:
                raise ExceptionCiudad
            else:
                if not self.check2.get():
                    self.rutas = self.rutas(origen,destino)
                    fila = 0
                    for x in range(len(self.rutas)):
                        Radiobutton(self.fr2,text=self.rutas[x][0][0],variable = self.opcion,value = x, command=est).place(y=fila)
                        fila+=40
                    self.check2.set(True)
        fc = self.fr
        self.fr1 = LabelFrame(fc, text="CIUDADES", width=780, height=100, font=("Inter", 8))
        self.fr1.place(x=10, y=40)
        self.fr1.grid_propagate(False)

        self.fr2 = LabelFrame(fc, text="RUTAS", width=780, height=205, font=("Inter", 8))
        self.fr2.pack_propagate(False)
        self.fr2.place(x=10, y=145)

        self.fr3 = LabelFrame(fc, text="RESUMEN", width=780, height=100, font=("Inter", 8))
        self.fr3.place(x=10, y=355)
        self.fr3.grid_propagate(False)



        lb1=Label(self.fr1, text="CIUDAD ORIGEN", font=("Inter", 8))
        lb1.place(relx=.02,rely=.25, anchor=W)
        self.c1 = ttk.Combobox(
            self.fr1,
            state="readonly",
            values= GenerarRuta.CIUDADES,
            width=40
        )
        self.c1.place(relx=.2,rely=.25, anchor=W)
        lb2=Label(self.fr1, text="CIUDAD DESTINO", font=("Inter", 8))
        lb2.place(relx=.02,rely=.75, anchor=W)
        self.c2 = ttk.Combobox(
            self.fr1,
            state="readonly",
            values= GenerarRuta.CIUDADES,
            width=40
        )
        self.c2.place(relx=.2,rely=.75, anchor=W)

        btCiudad = Button(self.fr1,text="ACEPTAR",bg="#000028", fg="white", font=("Inter", 8),command=ru)
        btCiudad.place(relx=.83,rely=.5, anchor=W)


    def cancelar(self):
        self.fr.destroy()
    def footer(self):

        infFrame = Frame(self.fr, width=1090, height=50)
        infFrame.pack()
        bLimpiar = Button(infFrame, text="CANCELAR", bg="#000028", fg="white", font=("Inter", 11), command=self.cancelar)
        bLimpiar.place(width=266, height=30, x = 266, y = 0)
        bGuardarEM = Button(infFrame, text="GUARDAR", bg="#000028", fg="white", font=("Inter", 11),command=self.guardar)
        bGuardarEM.place(width=266, height=30, x = 0, y = 0)
        bVolverM = Button(infFrame, text="LIMPIAR", bg="#000028", fg="white", font=("Inter", 11),command=self.limpiar)
        bVolverM.place(width=266, height=30, x = 532, y = 0)
    def rutaAux(self,act,destino,ruta,res,conexiones:Conexion = Conexion):
        if act==destino: 
            res.append(ruta)
        else:
            aux = [x for x in list(conexiones) if x.ciudadA == act]
            for i in aux:
                cop = ruta.copy()
                if i not in cop:
                    cop.append(i)
                    self.rutaAux(i.ciudadB,destino,cop,res)
    def rutas(self,origen:str,destino:str,conexiones:Conexion = Conexion):
        res = []
        ruta = []
        aux = [x for x in list(conexiones) if x.ciudadA == origen]
        for i in aux:
            cop = ruta.copy()
            cop.append(i)
            self.rutaAux(i.ciudadB,destino,cop,res)
        res.sort(key=lambda x: len(x))
        return self.formato(res[:3]) if len(res[0])!=1 else self.formato(res[:1])
    def pintarRuta(self,ruta):
        print(ruta[0].ciudadA)
        for i in ruta:
            print(i.ciudadB)
    def hm(self,t):
        horas = t//60
        minutos = t%60
        return f"{horas} horas y {minutos} minutos"
    def suma(self,ruta,s):
        suma = 0
        for i in ruta:
            if s == "D":
                suma+=i.distancia
            elif s == "T":
                suma+=i.tiempo
            elif s == "P":
                suma+=i.precio
        return suma

    def formato(self,rutas):
        l =[]
        for ruta in rutas:
        
            recorrido = "-".join([ruta[0].ciudadA]+[x.ciudadB for x in ruta])
            distancia = self.suma(ruta,'D')
            precio = self.suma(ruta,'P')
            tiempo = self.suma(ruta,'T')
            l.append([[recorrido,f"DISTANCIA: {distancia} km\nPRECIO: ${precio}\nTIEMPO: {self.hm(tiempo)}"],[ruta,precio,distancia,tiempo]])
            
        return l