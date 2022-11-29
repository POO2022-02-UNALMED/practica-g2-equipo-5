import tkinter as tk

from tkinter import IntVar, messagebox as MessageBox

from .GenerarRuta import *
import tkinter
from tkinter import ttk
from .Base import *
from .CrearViaje import *
from .EnviarMercancia import *
from .ErrorAplicacion import *

#-----BONIFICACION--------
class GenerarBonificacion(Base):
    def __init__(self, master, usuario):
        super().__init__(master, "GENERAR BONIFICACIÓN")
        self.usuario = usuario
        self.generarBonificacion()



    def generarBonificacion(self):
        
        #------------------
        cantidadMercancias = len(self.usuario.getMercancias())
        cantidadViajes = len(self.usuario.getViajes())
        #-----------------

        #Funciones ---------------------------
        def validarMercancia():
            if cantidadMercancias % 5 != 0:
                Mensaje="-> NO PUEDE OBTENER LA BONIFICACION <- \n\nAhora sólo cuenta con "
                nEnvios=str(len(self.usuario.getMercancias()))
                messagebox.showinfo(message=Mensaje+nEnvios+" envios", title="No cuenta con bonificación")

            else:
                messagebox.showinfo(message="A continuacion por favor realize el nuevo envío con reduccion del 30% en el precio", title="Cuenta con bonificación")
                
                if (self.usuario.getRuta()==None):
                    self.fr.destroy()
                    raise ExceptionRuta
                else:
                    EnviarMercancia(self.fr, self.usuario)

                mercancias = self.usuario.getMercancia()
                tamañoM = len(mercancias)
                tamañoM -= 1

                mercancia = mercancias.get(tamañoM)

                fecha = mercancia.getFecha()   
                ##AGREGAR BONIFICACION SEGUN EL DIA DE LA SEMANA
                splitFecha= fecha.split(sep='/')

                dia = splitFecha[2]
                mes = splitFecha[1]
                year = splitFecha[0]

                if year < 1583:
                    print('Solo acepta fechas mayores a 1582')
                else:
                    a = (14 - mes) // 12
                    y = year - a
                    m = mes + 12 * a - 2

                    d = (dia + year + (year//4) - (year//100) + (year//400) + ((31 * m)//12)) % 7

                    if d == 0:
                        diaSemana = 'Domingo'
                    elif d == 1:
                        diaSemana = 'Lunes'
                    elif d == 2:
                        diaSemana = 'Martes'
                    elif d == 3:
                        diaSemana = 'Miercoles'
                    elif d == 4:
                        diaSemana = 'Jueves'

                if diaSemana=="Martes":
                    messagebox.showinfo(message="Adicionalmente, por ser día martes se le reducirá un 10% del precio del envío", title="Adición")
                    mercancia.setIsBonificacion(True)

                self.fr.destroy()

        def validarViaje():
            if cantidadViajes % 5 != 0:
                Mensaje="-> NO PUEDE OBTENER LA BONIFICACION <- \n\nAhora sólo cuenta con "
                nEnvios=str(len(self.usuario.getViajes()))
                messagebox.showinfo(message=Mensaje+nEnvios+" viajes", title="No cuenta con bonificación")

            else:
                messagebox.showinfo(message="A continuacion por favor cree el nuevo viaje con reduccion del 30% en el precio", title="Cuenta con bonificación")

                if (self.usuario.getRuta()==None):
                    self.fr.destroy()
                    raise ExceptionRuta
                else:
                    CrearViaje(self.fr, self.usuario)

                viajes = self.usuario.getViaje()
                tamañoViajes = len(viajes)
                tamañoViajes-=1

                viaje = viajes.get(tamañoViajes)
                fecha = viaje.getFecha()

                ##AGREGAR BONIFICACION SEGUN EL DIA DE LA SEMANA

                splitFecha= fecha.split(sep='/')

                dia = splitFecha[2]
                mes = splitFecha[1]
                year = splitFecha[0]

                if year < 1583:
                    print('Solo acepta fechas mayores a 1582')
                else:
                    a = (14 - mes) // 12
                    y = year - a
                    m = mes + 12 * a - 2

                    d = (dia + year + (year//4) - (year//100) + (year//400) + ((31 * m)//12)) % 7

                    if d == 0:
                        diaSemana = 'Domingo'
                    elif d == 1:
                        diaSemana = 'Lunes'
                    elif d == 2:
                        diaSemana = 'Martes'
                    elif d == 3:
                        diaSemana = 'Miercoles'
                    elif d == 4:
                        diaSemana = 'Jueves'

                if diaSemana=="Martes":
                    messagebox.showinfo(message="Adicionalmente, por ser día martes se le reducirá un 10% del precio del viaje", title="Adición")
                    viaje.setIsBonificacion(True)

                self.fr.destroy()
                
        #---------------
        #cenFrame = tk.Frame(frame, width=1090, height=785)
        #cenFrame.pack()

        Tittle = tk.Label(self.cenFrame, text="GENERAR BONIFICACION", fg="#000028", font=("Inter", 11), bg="#23d2aa")
        Tittle.place(x = 5, y = 5, width=790, height=30)

        frameExplicacion = tk.Frame(self.cenFrame, bg="#23d2aa")
        frameExplicacion.place(x=10, y=85, width=780, height=80)
        explicacion1 = "\nCada 4 viajes, obtiene un 5to viaje con 30% de descuento\nCada 4 envíos de mercancia, en el 5to obtiene 30% de descuento."
        explicacion2="\n\nPara qué servicio desea obtener la bonificación:\n"
        subtitulo = tk.Label(frameExplicacion, text=explicacion1+explicacion2 , fg="#000028", font=("Inter", 10), bg="#23d2aa")
        subtitulo.pack(expand=True)

        frameOpciones = tk.LabelFrame(self.cenFrame, width=480, height=138)
        frameOpciones.place(x=160, y=200)
        frameOpciones.columnconfigure(0, weight=1)
        frameOpciones.columnconfigure(1, weight=1)

        frameOpciones.rowconfigure(0, weight=1)
        frameOpciones.rowconfigure(1, weight=1)



        #BOTONES
        botonViaje = tk.Button(frameOpciones, text="Creación de viajes", bg="#000028", fg="white", font=("Inter", 11), command=validarViaje)
        botonViaje.grid(row=0, column=2, columnspan=1, pady=8, padx=8)
        botonMercancia = tk.Button(frameOpciones, text="Envío de mercancía", bg="#000028", fg="white", font=("Inter", 11), command=validarMercancia)
        botonMercancia.grid(row=1, column=2, columnspan=1, pady=8, padx=8)

        #TEXTO
        textoViaje = tkinter.Label(frameOpciones, text="Para seleccionar viajes, oprima aquí: ", font="arial 12")
        textoViaje.grid(row=0, column=0, columnspan=2, pady=8, padx=8)
        textoMercancia = tkinter.Label(frameOpciones, text="Para seleccionar mercancía, oprima aquí: ", font="arial 12")
        textoMercancia.grid(row=1, column=0, columnspan=2, pady=8, padx=8)

        self.fr.mainloop()
        #ventanaPrincipal.mainloop()