import tkinter as tk
import tkinter as tk
from tkinter import IntVar, messagebox as MessageBox
from Usuario import *
from GenerarRuta import *
import tkinter
from tkinter import ttk
from Base import *
from CrearViaje import *
from GenerarRuta import *
from EnviarMercancia import *

#-----BONIFICACION--------
class GenerarBonificacion(Base):
    def __init__(self, master, usuario):
        super().__init__(master, "GENERAR BONIFICACIÓN")
        self.generarBonificacion(usuario)



    def generarBonificacion(self, usuario):
        
        """ventanaPrincipal = Tk()
        ventanaPrincipal.geometry("500x300")

        frame = tk.Frame(ventanaPrincipal, width=1090, height=835)
        frame.place(x=0, y=0)"""

        #------------------
        cantidadMercancias = len(usuario.getMercancias())
        cantidadViajes = len(usuario.getViajes())
        #-----------------

        #Funciones ---------------------------
        def validarMercancia():
            if cantidadMercancias % 5 != 0:
                Mensaje="-> NO PUEDE OBTENER LA BONIFICACION <- \n\nAhora sólo cuenta con "
                nEnvios=str(len(usuario.getMercancias()))
                messagebox.showinfo(message=Mensaje+nEnvios+" envios", title="No cuenta con bonificación")

            else:
                messagebox.showinfo(message="A continuacion por favor realize el nuevo envío con reduccion del 30% en el precio", title="Cuenta con bonificación")
                GenerarRuta(self.master, usuario)
                EnviarMercancia(self.master, usuario)

                mercancias = usuario.getMercancia()
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
                nEnvios=str(len(usuario.getViajes()))
                messagebox.showinfo(message=Mensaje+nEnvios+" viajes", title="No cuenta con bonificación")

            else:
                messagebox.showinfo(message="A continuacion por favor cree el nuevo viaje con reduccion del 30% en el precio", title="Cuenta con bonificación")

                GenerarRuta(self.master,usuario)
                CrearViaje(self.master,usuario)

                viajes = usuario.getViaje()
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

        frameTittle = tk.LabelFrame(self.cenFrame, width=1070, height=80, bg="#23d2aa")
        frameTittle.place(x=10, y=10)
        Tittle = tk.Label(frameTittle, text="GENERAR BONIFICACION", fg="#000028", font=("Inter", 15), bg="#23d2aa")
        Tittle.place(x = 0, y = 0, width=1070, height=70)

        frameExplicacion = tk.LabelFrame(self.cenFrame, width=1070, height=80, bg="#23d2aa")
        frameExplicacion.place(x=10, y=100)
        explicacion1 = "Cada 4 viajes, obtiene un 5to viaje con 30% de descuento y cada 4 envíos de mercancia, en el 5to obtiene 30% de descuento."
        explicacion2="\n\nPara que servicio desea obtener la bonificación:"
        subtitulo = tk.Label(frameExplicacion, text=explicacion1+explicacion2 , fg="#000028", font=("Inter", 10), bg="#23d2aa")
        subtitulo.place(x = 0, y = 0, width=1070, height=70)

        frameOpciones = tk.LabelFrame(self.cenFrame, width=1070, height=800)
        frameOpciones.place(x=300, y=250)
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