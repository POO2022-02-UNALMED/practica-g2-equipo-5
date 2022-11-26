import tkinter as tk
import tkinter as tk
from tkinter import IntVar, messagebox as MessageBox
from Conductor import Conductor
from Ruta import Ruta
from Usuario import Usuario
from VehiculoPasajero import VehiculoPasajeros
from Viaje import Viaje
from FieldFrame import *


import tkinter as tk
from tkinter import ttk
from Base import *
from ErrorAplicacion import *

class CrearViaje(Base):
    def __init__(self, master, usuario):
        super().__init__(master, "CREAR VIAJE")
        self.usuario = usuario
        self.crearViaje()

    def crearViaje(self):
        #Funciones ---------------------------
        def agregar(linea):
            try:
                self.pp = int(self.edad.get())
                self.nn = self.Name.get()
                self.viaje.agregarPasajeros(Usuario(self.nn, self.pp))
                linea += 1.0
                self.lAcompañantes.insert(linea, "- " + self.eNombre.get() + ", " + self.eEdad.get() + " años\n")
                last1 = len(self.eNombre.get())
                last2 = len(self.eEdad.get())
                self.eNombre.delete(0, last1)
                self.eEdad.delete(0, last2)
            except:
                raise ExceptionAgregar

        def validar():
            global vPosibles
            nPas = self.viaje.getPasajeros()
            if len(nPas) == 0: 
                raise ExceptionValidar
            else:
                if float(self.usuario.getRuta().getDistancia()) >= 1000:
                    nPasajeros = int(len(nPas))+2
                    vPosibles = VehiculoPasajeros.validarCapacidad(nPasajeros)
                else:
                    nPasajeros = int(len(nPas))+1
                    vPosibles = VehiculoPasajeros.validarCapacidad(nPasajeros)
                desplegableVehiculos = tk.ttk.Combobox(self.frameVehiculo ,state="readonly", values=list(map(lambda x: x.presentacion(), self.vPosibles)))
                desplegableVehiculos.place(relwidth=.8, relx=.1, rely=.5)

        #-------------------------------------
        #Viaje -----------------
        self.viaje = Viaje()
        self.viaje.setUsuario(self.usuario)
        
        #Ruta
        self.rutaSeleccionada = self.usuario.getRuta()
        self.cOrigenString = self.rutaSeleccionada.getRuta()[0]
        self.cDestinoString = self.rutaSeleccionada.getRuta()[-1]
        #-----------------------------

        #Frame Central

        self.frameTittle = tk.LabelFrame(self.cenFrame, width=1070, height=80, bg="#23d2aa")
        self.frameTittle.place(x=10, y=10)
        self.Tittle = tk.Label(self.frameTittle, text="CREAR VIAJE", fg="#000028", font=("Inter", 15), bg="#23d2aa")
        self.Tittle.place(x = 0, y = 0, width=1070, height=70)

        self.frameRuta = tk.LabelFrame(self.cenFrame, text="RUTA", width=530, height=150, font=("Inter", 10))
        self.frameRuta.place(x=10, y=100)
        self.cOrigen = tk.Label(self.frameRuta, text="CIUDAD DE ORIGEN", font=("Inter", 11)).place(relwidth=.4, relx=.1, rely=.2)
        self.cDestino = tk.Label(self.frameRuta, text="CIUDAD DE DESTINO", font=("Inter", 11)).place(relwidth=.4, relx=.1, rely=.6)
        self.oEntry = tk.Entry(self.frameRuta, state="disabled", textvariable=tk.StringVar(self.frameRuta, value=self.cOrigenString), justify="center", font=("Inter", 11))
        self.oEntry.place(relwidth=.4, relx=.5, rely=.2)
        self.dEntry = tk.Entry(self.frameRuta, state="disabled", textvariable=tk.StringVar(self.frameRuta, value=self.cDestinoString), justify="center", font=("Inter", 11))
        self.dEntry.place(relwidth=.4, relx=.5, rely=.6)

        self.frameAcompañantes = tk.LabelFrame(self.cenFrame, text="ACOMPAÑANTES", width=530, height=525, font=("Inter", 10))
        self.frameAcompañantes.place(x=10, y=255)

        #Variables 
        self.linea = 0.0
        self.Name = tk.StringVar()
        self.edad = tk.StringVar()

        self.nombre = tk.Label(self.frameAcompañantes, text="NOMBRE", font=("Inter", 11)).place(relwidth=.4, relx=.1, rely=.05)
        self.eNombre = tk.Entry(self.frameAcompañantes, textvariable=self.Name)
        self.eNombre.place(relwidth=.4, relx=.5, rely=.05)
        self.edadKG = tk.Label(self.frameAcompañantes, text="EDAD", font=("Inter", 11)).place(relwidth=.4, relx=.1, rely=.15)
        self.eEdad = tk.Entry(self.frameAcompañantes, textvariable=self.edad)
        self.eEdad.place(relwidth=.4, relx=.5, rely=.15)
        self.bGuardarP = tk.Button(self.frameAcompañantes, text="AGREGAR PASAJERO", bg="#000028", fg="white", font=("Inter", 11), command=lambda: agregar(self.linea))
        self.bGuardarP.place(relwidth=.8, relx=.1, rely=.25)
        self.lAcompañantes = tk.Text(self.frameAcompañantes, font=("Inter", 11))
        self.lAcompañantes.place(relwidth=.8, relx=.1, rely=.35, relheight=.52)
        self.bValidar = tk.Button(self.frameAcompañantes, text="VALIDAR CAPACIDAD", bg="#000028", fg="white", font=("Inter", 11), command=lambda:validar()).place(relwidth=.8, rely=.9, relx=.1)

        self.vPosibles = VehiculoPasajeros.getVehiculos()

        self.frameVehiculo= tk.LabelFrame(self.cenFrame, text="VEHICULO", width=530, height=218, font=("Inter", 10))
        self.frameVehiculo.place(x=550, y=100)
        self.etiqueta = tk.Label(self.frameVehiculo, text="SELECCIONE UN VEHICULO", font=("Inter", 11)).place(relwidth=.8, relx=.1, rely=.3)
        if (self.usuario.getRuta().getDistancia())<=1000:
            self.desplegableVehiculos = tk.ttk.Combobox(self.frameVehiculo ,state="readonly", values=list(map(lambda x: x.presentacion(), self.vPosibles)))
            self.desplegableVehiculos.place(relwidth=.8, relx=.1, rely=.5)
        else:
            self.desplegableVehiculos = tk.ttk.Combobox(self.frameVehiculo ,state="readonly", values=list(map(lambda x: x.presentacion(), self.vPosibles[1:])))
            self.desplegableVehiculos.place(relwidth=.8, relx=.1, rely=.5)

        self.lConductores = Conductor.getConductores()
        self.frameConductor= tk.LabelFrame(self.cenFrame, text="CONDUCTOR", width=530, height=222, font=("Inter", 10))
        self.frameConductor.place(x=550, y=328)
        if (self.usuario.getRuta().getDistancia())<=1000:
            self.etiqueta = tk.Label(self.frameConductor, text="SELECCIONE UN CONDUCTOR", font=("Inter", 11)).place(relwidth=.8, relx=.1, rely=.3)
            self.desplegableConductor1 = tk.ttk.Combobox(self.frameConductor ,state="readonly", values=list(map(lambda x: x.presentacion(), self.lConductores)))
            self.desplegableConductor1.place(relwidth=.8, relx=.1, rely=.5)
        else:
            self.etiqueta = tk.Label(self.frameConductor, text="SELECCIONE DOS CONDUCTORES", font=("Inter", 11)).place(relwidth=.8, relx=.1, rely=.2)
            self.desplegableConductor1 = tk.ttk.Combobox(self.frameConductor ,state="readonly", values=list(map(lambda x: x.presentacion(), self.lConductores)))
            self.desplegableConductor1.place(relwidth=.8, relx=.1, rely=.4)
            self.desplegableConductor2 = tk.ttk.Combobox(self.frameConductor ,state="readonly", values=list(map(lambda x: x.presentacion(), self.lConductores)))
            self.desplegableConductor2.place(relwidth=.8, relx=.1, rely=.6)


        self.frameFecha= tk.Frame(self.cenFrame, width=530, height=218)
        self.frameFecha.place(x=550, y=560)
        self.fechas = FieldFrame(self.frameFecha, ["DIA", "MES", "AÑO"], "SELECCIONE LA FECHA DE SU VIAJE")

        self.fr.mainloop()

    def cancelar(self):
            self.fr.destroy()

    def guardar(self):
            if self.usuario.getRuta().getDistancia() <= 1000:
                self.indC = self.desplegableConductor1.current()
                self.indV = self.desplegableVehiculos.current()
                self.dd = int(self.fechas.getValue("DIA")) if len(self.fechas.getValue("DIA"))!=0 else '0'
                self.mm = int(self.fechas.getValue("MES")) if len(self.fechas.getValue("MES"))!=0 else '0'
                self.aa = int(self.fechas.getValue("AÑO")) if len(self.fechas.getValue("AÑO"))!=0 else '0'
                if self.indC ==-1 or self.indV ==-1 or self.dd == '0' or self.mm == '0' or self.aa == '0':
                    raise ExceptionAceptar
                else:
                    if (self.dd < 1 or self.dd > 31) or (self.mm < 1 or self.mm > 13) or (self.aa < 2022):
                        raise ExceptionFecha
                    else:
                        self.viaje.setConductores([self.lConductores[self.indC]])
                        self.viaje.setVehiculo(self.vPosibles[self.indV])
                        self.fecha = str(self.aa)+"/"+str(self.mm)+"/"+str(self.dd)
                        self.viaje.setFecha(self.fecha)
                        self.usuario.agregarViaje(self.viaje)
                        self.fr.destroy()
            else:
                self.indC1 = self.desplegableConductor1.current()
                self.indC2 = self.desplegableConductor2.current()
                self.indV = self.desplegableVehiculos.current()
                self.dd = int(self.fechas.getValue("DIA")) if len(self.fechas.getValue("DIA"))!=0 else '0'
                self.mm = int(self.fechas.getValue("MES")) if len(self.fechas.getValue("MES"))!=0 else '0'
                self.aa = int(self.fechas.getValue("AÑO")) if len(self.fechas.getValue("AÑO"))!=0 else '0'
                if self.indC1 ==-1 or self.indC2 ==-1 or self.indV ==-1 or self.dd == '0' or self.mm == '0' or self.aa == '0':
                    raise ExceptionAceptar
                else:
                    if (self.dd < 1 or self.dd > 31) or (self.mm < 1 or self.mm > 13) or (self.aa < 2022):
                        raise ExceptionFecha
                    else:
                        if self.lConductores[self.indC1] != self.lConductores[self.indC2]:
                            self.viaje.setConductores([self.lConductores[self.indC1], self.lConductores[self.indC2]])
                            self.viaje.setVehiculo(self.vPosibles[self.indV])
                            self.fecha = str(self.aa)+"/"+str(self.mm)+"/"+str(self.dd)
                            self.viaje.setFecha(self.fecha)
                            self.usuario.agregarViaje(self.viaje)
                            self.fr.destroy()
                        else:
                            raise ExceptionConductor

    def footer(self):
        #Barra inferior
        infFrame = tk.Frame(self.fr, width=1090, height=50)
        infFrame.pack()
        #Botones
        bGuardarEM = tk.Button(infFrame, text="GUARDAR", bg="#000028", fg="white", font=("Inter", 11), command=self.guardar)
        bGuardarEM.place(width=544, height=50, x = 0, y = 0)
        bVolverM = tk.Button(infFrame, text="CANCELAR", bg="#000028", fg="white", font=("Inter", 11), command=self.cancelar)
        bVolverM.place(width=544, height=50, x = 544, y = 0)