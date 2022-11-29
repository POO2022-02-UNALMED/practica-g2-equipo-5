import tkinter as tk
from .Base import *
from .ErrorAplicacion import *
from gestionAplicacion.Personas.Usuario import *
from tkinter import ttk


class GenerarFactura(Base):
    def __init__(self, master, usuario):
        super().__init__(master, "GENERAR FACTURA")
        self.usuario = usuario
        self.generarFactura()

    def generarFactura(self):
        #Frame central
        self.Tittle = tk.Label(self.cenFrame, text="GENERAR FACTURA", fg="#000028", font=("Inter", 10), bg="#23d2aa")
        self.Tittle.place(x = 5, y = 5, width=790, height=30)

        self.contenedor = tk.Frame(self.cenFrame, bg="#23d2aa")
        self.contenedor.place(x = 5, y = 50, width=790, height=100)


        self.list = tk.Frame(self.cenFrame)
        self.list.place(x = 10, y = 165, width=780, height=295)
        self.desplegable = tk.ttk.Combobox(self.list ,state="readonly", values=[])
        self.desplegable.place(relwidth=.8, relx=.1, rely=.0)

        self.mercancias = []
        self.viajes = []
        self.valor = ""
        def viaje():
            self.viajes = self.usuario.getViajes()
            self.desplegable = tk.ttk.Combobox(self.list ,state="readonly", values=list(map(lambda x: x.presentacion(), self.viajes)))
            self.desplegable.place(relwidth=.8, relx=.1, rely=.0) 
            self.valor = "Viaje"

        def envio():
            self.mercancias = self.usuario.getMercancias()
            self.desplegable = tk.ttk.Combobox(self.list ,state="readonly", values=list(map(lambda x: x.presentacion(), self.mercancias)))
            self.desplegable.place(relwidth=.8, relx=.1, rely=.0)
            self.valor = "Envio"

        self.factura1 = tk.Label(self.list, text="", font=("Inter", 10))
        self.factura1.place(relheight=.7, relx=.1, rely=.2 ,relwidth=.4)
        self.factura2 = tk.Label(self.list, text="", font=("Inter", 10))
        self.factura2.place(relheight=.7, relx=.5, rely=.2 ,relwidth=.4)

        self.text = tk.Label(self.contenedor, text="Para que servicio desea conocer su factura:", fg="#000028", font=("Inter", 10), bg="#23d2aa")
        self.text.place(x = 10, y = 0, width=780, height=40)
        self.contBotones = tk.Frame(self.contenedor, bg="#23d2aa")
        self.contBotones.place(x = 0, y = 40, width=780, height=60)
        self.bEnvio = tk.Button(self.contBotones, text="ENVIOS", bg="#000028", fg="white", font=("Inter", 10), command=envio)
        self.bEnvio.place(relwidth=.2, relheight=.6, relx=.2, rely=.1)
        self.bViaje = tk.Button(self.contBotones, text="VIAJES", bg="#000028", fg="white", font=("Inter", 10), command=viaje)
        self.bViaje.place(relwidth=.2, relheight=.6, relx=.6, rely=.1)

       
    def guardar(self):
        self.indice = self.desplegable.current()
        if self.indice == -1:
            raise ExceptionFactura
        else:
            if self.valor == "Viaje":
                viajeSel = self.viajes[self.indice]
                a1 = "SISTEMA DE TRANSPORTE PERSONALIZADO\n"
                a2 = "----------------------------------------\n"
                a3 = "Usuario: " + str(viajeSel.getUsuario().getNombre()) + "\n"
                a4 = "Origen: " + str(viajeSel.getRuta().getRuta()[0].value[0]) + "\n"
                a5 = "Destino: " + str(viajeSel.getRuta().getRuta()[-1].value[1]) + "\n"
                a6 = "Distancia: " + str(viajeSel.getRuta().getDistancia()) + " km\n"
                precio = viajeSel.getRuta().getPrecio() + viajeSel.getVehiculo().getPrecio() + viajeSel.getConductores()[-1].getPrecio()
                if (self.indice+1) % 5 == 0:
                    if viajeSel.getIsBonificacion() == True:
                        a7 = "Precio: " + str(precio-(precio*0.45)) + "$, tienes 45% de descuento\n"
                    else:
                        a7 = "Precio: " + str(precio-(precio*0.35)) + "$, tienes 35% de descuento\n"
                else:
                    a7 = "Precio: " + str(precio) + "$\n"
                a8 = "Tiempo: " + str(viajeSel.getRuta().getTiempo()) + " minutos\n"
                a9 = "Vehiculo: " + str(viajeSel.getVehiculo().presentacion()) + "\n"
                if len(viajeSel.getConductores()) == 2:
                    a10 = "Conductor 1: " + str(viajeSel.getConductores()[0].getNombre()) + "\n"
                    a11 = "Conductor 2: " + str(viajeSel.getConductores()[-1].getNombre()) + "\n"
                    a12 = "----------------------------------------\n"
                    self.factura1.config(text=a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12)
                else:
                    a10 = "Conductor: " + str(viajeSel.getConductores()[0].getNombre()) + "\n"
                    a11 = "----------------------------------------\n"
                    self.factura1.config(text=a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11)
                pasajeros = list(map(lambda x,y: str(x.getNombre())+", "+str(y.getEdad()+" años"), viajeSel.getPasajeros(), viajeSel.getPasajeros()))
                lPas = "\n".join(pasajeros)
                b1 = "ACOMPAÑANTES\n"
                b2 = "----------------------------------------\n"
                self.factura2.config(text=b1+b2+lPas)
                
            elif self.valor == "Envio":
                mercanciaSel = self.mercancias[self.indice]
                a1 = "SISTEMA DE TRANSPORTE PERSONALIZADO\n"
                a2 = "----------------------------------------\n"
                a3 = "Usuario: " + str(mercanciaSel.getUsuario().getNombre()) + "\n"
                a4 = "Origen: " + str(mercanciaSel.getRuta().getRuta()[0].value[0]) + "\n"
                a5 = "Destino: " + str(mercanciaSel.getRuta().getRuta()[-1].value[1]) + "\n"
                a6 = "Distancia: " + str(mercanciaSel.getRuta().getDistancia()) + " km\n"
                precio = mercanciaSel.getRuta().getPrecio() + mercanciaSel.getVehiculo().getPrecio() + mercanciaSel.getConductor().getPrecio()
                if (self.indice+1) % 5 == 0:
                    if mercanciaSel.getIsBonificacion() == True:
                        a7 = "Precio: " + str(precio-(precio*0.45)) + "$, tienes 45% de descuento\n"
                    else:
                        a7 = "Precio: " + str(precio-(precio*0.35)) + "$, tienes 35% de descuento\n"
                else:
                    a7 = "Precio: " + str(precio) + "$\n"
                a8 = "Tiempo: " + str(mercanciaSel.getRuta().getTiempo()) + " minutos\n"
                a9 = "Vehiculo: " + str(mercanciaSel.getVehiculo().presentacion()) + "\n"
                a10 = "Conductor: " + str(mercanciaSel.getConductor().getNombre()) + "\n"
                a11 = "----------------------------------------\n"
                self.factura1.config(text=a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11)
                productos = list(map(lambda x,y: str(x.getTipo())+", "+str(y.getPeso())+" KG", mercanciaSel.getProductos(), mercanciaSel.getProductos()))
                lPas = "\n".join(productos)
                b1 = "PRODUCTOS\n"
                b2 = "----------------------------------------\n"
                self.factura2.config(text=b1+b2+lPas)

    def cancelar(self):
        self.fr.destroy()

    def footer(self):
        #Barra inferior
        infFrame = tk.Frame(self.fr, width=800, height=30)
        infFrame.pack()
        #Botones
        bGuardarEM = tk.Button(infFrame, text="MOSTRAR", bg="#000028", fg="white", font=("Inter", 10), command=self.guardar)
        bGuardarEM.place(width=400, height=30, x = 0, y = 0)
        bVolverM = tk.Button(infFrame, text="CANCELAR", bg="#000028", fg="white", font=("Inter", 10), command=self.cancelar)
        bVolverM.place(width=400, height=30, x = 400, y = 0)