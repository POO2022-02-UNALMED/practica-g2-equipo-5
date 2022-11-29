import tkinter as tk
from tkinter import IntVar, messagebox as MessageBox
from gestionAplicacion.Personas.Conductor import *
from gestionAplicacion.Vehiculos.VehiculoCarga import *
from gestionAplicacion.Operatividad.Mercancia  import *
from gestionAplicacion.Operatividad.Producto  import *

from .GenerarRuta import *
from .FieldFrame import *
from gestionAplicacion.Destinos.Conexion  import *
from tkinter import ttk
from .Base import *

from .ErrorAplicacion import *

class EnviarMercancia(Base):
    def __init__(self, master, usuario):
        super().__init__(master, "ENVIAR MERCANCIA")
        self.usuario = usuario
        self.enviarMercancia()



    def enviarMercancia(self):
        #Funciones ---------------------------
        def agregar(linea):
            try:
                self.pp = float(self.Peso.get())
                self.nn = self.Name.get()
                self.mercancia.agregarProducto(Producto(self.nn, self.pp))
                linea += 1.0
                self.lProductos.insert(linea, "- " + self.eNombre.get() + ", " + self.ePeso.get() + " kg\n")
                last1 = len(self.eNombre.get())
                last2 = len(self.ePeso.get())
                self.eNombre.delete(0, last1)
                self.ePeso.delete(0, last2)
            except:
                raise ExceptionAgregar
            
        def validar():
            aProductos = self.mercancia.getProductos()
            if len(aProductos) != 0:
                self.tPesos = sum(list(map(lambda x: int(x.getPeso()), aProductos)))
            else:
                raise ExceptionValidar
        
        #-------------------------------------
        #Mercancia -----------------
        self.mercancia = Mercancia()
        self.mercancia.setUsuario(self.usuario)
        self.mercancia.setRuta(self.usuario.getRuta())
        
        #Ruta
        self.cOrigenString = self.usuario.getRuta().getRuta()[0].value[0]
        self.cDestinoString = self.usuario.getRuta().getRuta()[-1].value[1]
        #-----------------------------

        #Frame Central
        self.Tittle = tk.Label(self.cenFrame, text="ENVIAR MERCANCIA", fg="#000028", font=("Inter", 10), bg="#23d2aa")
        self.Tittle.place(x = 5, y = 5, width=790, height=30)

        self.frameRuta = tk.LabelFrame(self.cenFrame, text="RUTA", width=390, height=100, font=("Inter", 8))
        self.frameRuta.place(x=10, y=40)
        self.cOrigen = tk.Label(self.frameRuta, text="CIUDAD DE ORIGEN", font=("Inter", 8)).place(relwidth=.4, relx=.1, rely=.2)
        self.cDestino = tk.Label(self.frameRuta, text="CIUDAD DE DESTINO", font=("Inter", 8)).place(relwidth=.4, relx=.1, rely=.6)
        self.oEntry = tk.Entry(self.frameRuta, state="disabled", textvariable=tk.StringVar(self.frameRuta, value=self.cOrigenString), justify="center", font=("Inter", 8))
        self.oEntry.place(relwidth=.4, relx=.5, rely=.2)
        self.dEntry = tk.Entry(self.frameRuta, state="disabled", textvariable=tk.StringVar(self.frameRuta, value=self.cDestinoString), justify="center", font=("Inter", 8))
        self.dEntry.place(relwidth=.4, relx=.5, rely=.6)

        self.frameProducto = tk.LabelFrame(self.cenFrame, text="PRODUCTOS", width=390, height=320, font=("Inter", 8))
        self.frameProducto.place(x=10, y=145)

        #Variables 
        self.linea = 0.0
        self.Name = tk.StringVar()
        self.Peso = tk.StringVar()

        self.nombre = tk.Label(self.frameProducto, text="TIPO DE PRODUCTO", font=("Inter", 8)).place(relwidth=.4, relx=.1, rely=.05)
        self.eNombre = tk.Entry(self.frameProducto, textvariable=self.Name)
        self.eNombre.place(relwidth=.4, relx=.5, rely=.05)
        self.pesoKG = tk.Label(self.frameProducto, text="PESO DEL PRODUCTO", font=("Inter", 8)).place(relwidth=.4, relx=.1, rely=.15)
        self.ePeso = tk.Entry(self.frameProducto, textvariable=self.Peso)
        self.ePeso.place(relwidth=.4, relx=.5, rely=.15)
        self.bGuardarP = tk.Button(self.frameProducto, text="GUARDAR PRODUCTO", bg="#000028", fg="white", font=("Inter", 8), command=lambda: agregar(self.linea))
        self.bGuardarP.place(relwidth=.8, relx=.1, rely=.25)
        self.lProductos = tk.Text(self.frameProducto, font=("Inter", 8))
        self.lProductos.place(relwidth=.8, relx=.1, rely=.35, relheight=.52)
        self.bValidar = tk.Button(self.frameProducto, text="VALIDAR CAPACIDAD", bg="#000028", fg="white", font=("Inter", 8), command=lambda:validar()).place(relwidth=.8, rely=.9, relx=.1)

        self.vPosibles = VehiculoCarga.getVehiculos()

        self.tPesos = 0
        self.frameVehiculo= tk.LabelFrame(self.cenFrame, text="VEHICULO", width=380, height=138, font=("Inter", 8))
        self.frameVehiculo.place(x=410, y=40)
        self.etiqueta = tk.Label(self.frameVehiculo, text="SELECCIONE UN VEHICULO", font=("Inter", 8)).place(relwidth=.8, relx=.1, rely=.3)
        self.desplegableVehiculos = tk.ttk.Combobox(self.frameVehiculo ,state="readonly", values=list(map(lambda x: x.presentacion(), self.vPosibles)))
        self.desplegableVehiculos.place(relwidth=.8, relx=.1, rely=.5)

        self.lConductores = Conductor.getConductores()
        self.frameConductor= tk.LabelFrame(self.cenFrame, text="CONDUCTOR", width=380, height=138, font=("Inter", 8))
        self.frameConductor.place(x=410, y=183)
        self.etiqueta = tk.Label(self.frameConductor, text="SELECCIONE UN CONDUCTOR", font=("Inter", 8)).place(relwidth=.8, relx=.1, rely=.3)
        self.desplegableConductor = tk.ttk.Combobox(self.frameConductor ,state="readonly", values=list(map(lambda x: x.presentacion(), self.lConductores)))
        self.desplegableConductor.place(relwidth=.8, relx=.1, rely=.5)


        self.frameFecha= tk.Frame(self.cenFrame, width=380, height=138)
        self.frameFecha.place(x=410, y=326)
        self.fechas = FieldFrame(self.frameFecha, ["DIA", "MES", "AÑO"], "SELECCIONE LA FECHA DE SU ENVÍO")
        

        self.fr.mainloop()

    def guardar(self):
        self.indC = self.desplegableConductor.current()
        self.indV = self.desplegableVehiculos.current()
        self.dd = int(self.fechas.getValue("DIA")) if len(self.fechas.getValue("DIA"))!=0 else '0'
        self.mm = int(self.fechas.getValue("MES")) if len(self.fechas.getValue("MES"))!=0 else '0'
        self.aa = int(self.fechas.getValue("AÑO")) if len(self.fechas.getValue("AÑO"))!=0 else '0'
        if self.indC ==-1 or self.indV ==-1 or self.dd =='0' or self.mm =='0' or self.aa =='0':
            raise ExceptionAceptar
        else:
            if self.vPosibles[self.indV].getCapacidadMaxima() >= self.tPesos:
                if (self.dd < 1 or self.dd > 31) or (self.mm < 1 or self.mm > 13) or (self.aa < 2022):
                    raise ExceptionFecha
                else:
                    self.mercancia.setConductor(self.lConductores[self.indC])
                    self.mercancia.setVehiculo(self.vPosibles[self.indV])
                    self.fecha = str(self.aa)+"/"+str(self.mm)+"/"+str(self.dd)
                    self.mercancia.setFecha(self.fecha)
                    self.usuario.agregarMercancia(self.mercancia)
                    self.fr.destroy()
            else:
                raise ExceptionVehiculoCarga

    def cancelar(self):
        self.fr.destroy()

    def footer(self):
        #Barra inferior
        infFrame = tk.Frame(self.fr, width=800, height=30)
        infFrame.pack()
        #Botones
        bGuardarEM = tk.Button(infFrame, text="GUARDAR", bg="#000028", fg="white", font=("Inter", 10), command=self.guardar)
        bGuardarEM.place(width=400, height=30, x = 0, y = 0)
        bVolverM = tk.Button(infFrame, text="CANCELAR", bg="#000028", fg="white", font=("Inter", 10), command=self.cancelar)
        bVolverM.place(width=400, height=30, x = 400, y = 0)