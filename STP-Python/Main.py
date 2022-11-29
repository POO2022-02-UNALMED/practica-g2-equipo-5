import os
import tkinter as tk
from tkinter import IntVar, messagebox as MessageBox
from UiMain.GenerarFactura import *
from gestionAplicacion.Personas.Usuario import Usuario
from gestionAplicacion.Personas.Conductor import Conductor
from gestionAplicacion.Vehiculos.VehiculoPasajero import VehiculoPasajeros
from UiMain.GenerarRuta import *
from UiMain.GenerarBonificacion import *
from UiMain.CrearViaje import *

from pickle import *
from UiMain.GenerarBonificacion import *
from gestionAplicacion.Destinos.Conexion import *

#Usuario ------------------------------------------------------------------------------
try:
    with open("./baseDatos/usuario","rb") as f:
        GUZ = load(f)
    print("sesión recuperada de db")
except Exception as e:
    print("no hay sesión de usuario guardada")
    GUZ = Usuario("Jaime Alberto Guzman", "123456789", 20)

MAN = Conductor("Manuela Rivera", "5151531", 23, 10, 1000000)
ANG = Conductor("Angel", "10011020", "38", 15, 40000)
ANA = Conductor("Ana", "1015215", "40", 20, 50000)
ALE = Conductor("Alejandro", "1520022", "51", 10, 30000)
AND = Conductor("Andres", "152020", "30", 8, 15000)
JUA = Conductor("Juan", "1651561", "40", 10, 30000)

DOMI = VehiculoCarga("BAJAJ DOMINAR 400", 120000, 2012, "AUX-96X", 20)
DMAX = VehiculoCarga("CHEVROLET DMAX", 150000, 2012, "AUX-97X", 1000)
FRO = VehiculoCarga("NISSAN FRONTIER D22", 1500000, 2019, "AUX-98X", 1000)
AUM = VehiculoCarga("FOTON AUMARK BJ 1039", 2500000, 2017, "AUX-99X", 4000)
KEN = VehiculoCarga("KENWORTH T800", 5000000, 2012, "AUX-01X", 30000)

DOMCARGA = VehiculoPasajeros("BAJAJ DOMINAR 400", 50000, 2021, "AUX-87X", 1)
SR = VehiculoPasajeros("BMW S1000RR", 150000, 2023, "AUX-88X", 1)
ONIX = VehiculoPasajeros("CHEVROLET ONIX", 200000, 2020, "AUX-89X", 4)
SAN = VehiculoPasajeros("RENAULT SANDERO", 170000, 2018, "AUX-90X", 4)
FOR = VehiculoPasajeros("FORD F150", 350000, 2019, "AUX-91X", 6)
BER = VehiculoPasajeros("CITRÖEN BERLINGO", 90000, 2016, "AUX-92X", 6)
TRANS = VehiculoPasajeros("VOLKSWAGEN TRANSPORTER", 130000, 2015, "AUX-93X", 6)
PARADISO = VehiculoPasajeros("MARCOPOLO PARADISO", 1500000, 2017, "AUX-94X", 45)
CITARO = VehiculoPasajeros("MERCEDES-BENZ CITARO-K", 1500000, 2020, "AUX-95X", 40)
#--------------------------------------------------------------------------------------

#Ventana de inicio
def ventInicio():
    #----------------------------------------------------------------------------------------------------------------
     
    #----------------------------------------------------------------------------------------------------------------

    root = tk.Tk()
    root.title("SISTEMA DE TRANSPORTE PERSONALIZADO")
    root.config(bg="white")
    root.geometry("800x500")

    barMenu = tk.Menu(root)
    root.config(menu=barMenu)

    mInicio = tk.Menu(barMenu, tearoff=0)

    barMenu.add_cascade(label="INICIO", menu=mInicio)

    def descripcion():
        ventanaEmergente = tk.Frame(root, bg="#000028")
        ventanaEmergente.place(relwidth=.8, relheight=.3, relx=.1)
        des = tk.Label(ventanaEmergente, text="STP es una aplicación que brinda al ususario\nla posibilidad de planear un viaje o envío al gusto\nSelecciona tu ruta y listo.", font=("Inter", 11), bg= "#000028", fg="white")
        des.pack(expand=True)
        cerrar = tk.Button(ventanaEmergente, text="CERRAR", font=("Inter", 11), command=lambda: ventanaEmergente.destroy(), width=70)
        cerrar.pack(pady=(10,10), padx=(10,10))


    mInicio.add_command(label="DESCRIPCIÓN", font=("Inter", 11), command=descripcion)
    mInicio.add_separator()

    def salir():
 
        root.destroy()

    mInicio.add_command(label="SALIR", font=("Inter", 11), command=salir)

    #----------------------------------------------------------------------------------------------------------------
    
    #----------------------------------------------------------------------------------------------------------------
    stringBienvenida = "¡Hola!" + "\nGracias por confíar en nosotros"

    #Pantalla - Inicio
    pantallaInicio = tk.Frame(root, bg="white")
    pantallaInicio.place(x = 5, y = 5, width=800, height=500)

    #Bienvenida al sistema
    P3 = tk.Frame(pantallaInicio, bg="white")
    P3.place(x=25, y=10, relwidth=.45, relheight=.45)
    messageBienvenida = tk.Label(P3, font=("Inter", 15) ,text=stringBienvenida, bg= "#23d2aa", fg="#000028")
    messageBienvenida.place(relheight=1, relwidth=1)

    #Fotos del sistema y entrada
    P4 = tk.Frame(pantallaInicio, bg="white")
    P4.place(x=25, y=250, relwidth=.45, relheight=.45)

    r = os.getcwd()+'/Fotos/Logo.png'
    logo= tk.PhotoImage(file=r)
    fotoSistema = tk.Frame(P4)
    fotoSistema.place(relwidth=1, relheight=.8)
    lab1 = tk.Label(fotoSistema, image=logo).pack(expand=True)

    def entrarSistema():
        root.destroy()
        entrarMenu()
        
    botonSistema = tk.Button(P4, text="INGRESO AL SISTEMA", font=("Inter", 10), bg="#000028", fg="white", command=entrarSistema)
    botonSistema.place(relwidth=1, relheight=.15, rely=.85)

    # Hoja de vida de los desarrolladores
    P5 = tk.Frame(pantallaInicio)
    P5.place(x=410, y=10, relwidth=.45, relheight=.45) 
    P5Label = tk.Label(P5, bg= "#000028", fg="white")
    P5Label.place(relwidth=1, relheight=1)

    d1 = "Juan Diego Aguirre Moreno\n\n  Estudiante de Ingeniería de Sistemas e Informática\n Lugar de Nacimiento: Caramanta\n Año de Nacimiento: 2002"
    d2 = "Angel David Brand Londoño\n\n  Estudiante de Ingeniería de Sistemas e Informática\n Lugar de Nacimiento: Frontino\n Año de Nacimiento: 2000"
    d3 = "Ana María Barragán Ariza\n\n Estudiante de Ingeniería de Sistemas e Informática\n Lugar de Nacimiento: Tame\n Año de Nacimiento: 2002"
    d4 = "Alejandro Giraldo Quiceno\n\n  Estudiante de Ingeniería de Sistemas e Informática\n Lugar de Nacimiento: Medellín\n Año de Nacimiento: 2002"    
    d5 = "Andrés Felipe Díez Ángel\n\n Estudiante de Ingeniería de Sistemas e Informática\n Lugar de Nacimiento: Medellín\n Año de Nacimiento: 2001"                

    ind = IntVar()
    ind.set(0)

    arrayDescription = [d1, d2, d3, d4, d5]
    P5Label.config(text=arrayDescription[ind.get()], font=("Inter", 10))

    #Imágenes de los desarrolladores
    P6 = tk.Frame(pantallaInicio)
    P6.place(x=410, y=250, relwidth=.45, relheight=.45)

    #Frame Diego
    frameDiego = tk.Frame(P6)
    frameDiego.place(relwidth=1, relheight=1)

    imgD1 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Diego/D1.png')
    imgD1 = imgD1.subsample(1,1)

    imgD2 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Diego/D2.png')
    imgD2 = imgD2.subsample(1,1)

    imgD3 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Diego/D3.png')
    imgD3 = imgD3.subsample(1,1)

    imgD4 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Diego/D4.png')
    imgD4 = imgD4.subsample(1,1)

    lab1 = tk.Label(frameDiego, image=imgD1).grid(row=0, column=0)
    lab2 = tk.Label(frameDiego, image=imgD2).grid(row=1, column=0)
    lab3 = tk.Label(frameDiego, image=imgD3).grid(row=0, column=1)
    lab4 = tk.Label(frameDiego, image=imgD4).grid(row=1, column=1)

    #Frame Angel
    frameAngel = tk.Frame(P6, width=360, height=225)

    imgAN1= tk.PhotoImage(file=os.getcwd()+'/Fotos/Angel/A1.png')
    imgAN1 = imgAN1.subsample(1,1)

    imgAN2 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Angel/A2.png')
    imgAN2 = imgAN2.subsample(1,1)

    imgAN3 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Angel/A3.png')
    imgAN3 = imgAN3.subsample(1,1)

    imgAN4 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Angel/A4.png')
    imgAN4 = imgAN4.subsample(1,1)

    lab10 = tk.Label(frameAngel, image=imgAN1).grid(row=0, column=0)
    lab20 = tk.Label(frameAngel, image=imgAN2).grid(row=1, column=0)
    lab30 = tk.Label(frameAngel, image=imgAN3).grid(row=0, column=1)
    lab40 = tk.Label(frameAngel, image=imgAN4).grid(row=1, column=1)

    #Frame Ana
    frameAna = tk.Frame(P6, width=360, height=225)

    imgANA1 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Ana/AN1.png')
    imgANA1 = imgANA1.subsample(1,1)

    imgANA2 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Ana/AN2.png')
    imgANA2 = imgANA2.subsample(1,1)

    imgANA3 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Ana/AN3.png')
    imgANA3 = imgANA3.subsample(1,1)

    imgANA4 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Ana/AN4.png')
    imgANA4 = imgANA4.subsample(1,1)

    lab10 = tk.Label(frameAna, image=imgANA1).grid(row=0, column=0)
    lab20 = tk.Label(frameAna, image=imgANA2).grid(row=1, column=0)
    lab30 = tk.Label(frameAna, image=imgANA3).grid(row=0, column=1)
    lab40 = tk.Label(frameAna, image=imgANA4).grid(row=1, column=1)

    #Frame Alejo
    frameAL = tk.Frame(P6, width=360, height=225)

    imgAL1 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Alejo/A1.png')
    imgAL1 = imgAL1.subsample(1,1)

    imgAL2 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Alejo/A2.png')
    imgAL2 = imgAL2.subsample(1,1)

    imgAL3 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Alejo/A3.png')
    imgAL3 = imgAL3.subsample(1,1)

    imgAL4 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Alejo/A4.png')
    imgAL4 = imgAL4.subsample(1,1)

    lab10 = tk.Label(frameAL, image=imgAL1).grid(row=0, column=0)
    lab20 = tk.Label(frameAL, image=imgAL2).grid(row=1, column=0)
    lab30 = tk.Label(frameAL, image=imgAL3).grid(row=0, column=1)
    lab40 = tk.Label(frameAL, image=imgAL4).grid(row=1, column=1)

    #Frame Andrés
    frameAND = tk.Frame(P6, width=360, height=225)

    imgAND1 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Andres/A1.png')
    imgAND1 = imgAND1.subsample(1,1)

    imgAND2 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Andres/A2.png')
    imgAND2 = imgAND2.subsample(1,1)

    imgAND3 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Andres/A3.png')
    imgAND3 = imgAND3.subsample(1,1)

    imgAND4 = tk.PhotoImage(file=os.getcwd()+'/Fotos/Andres/A4.png')
    imgAND4 = imgAND4.subsample(1,1)

    lab10 = tk.Label(frameAND, image=imgAND1).grid(row=0, column=0)
    lab20 = tk.Label(frameAND, image=imgAND2).grid(row=1, column=0)
    lab30 = tk.Label(frameAND, image=imgAND3).grid(row=0, column=1)
    lab40 = tk.Label(frameAND, image=imgAND4).grid(row=1, column=1)

    arrayFotos = [frameDiego, frameAngel, frameAna, frameAL, frameAND]

    def cambiar(evento):
        if ind.get() == 4:
            arrayFotos[ind.get()].place(x=0, y=0, width=0, height=0)
            ind.set(0)
            P5Label.config(text=arrayDescription[ind.get()], font=("Inter", 10))
            arrayFotos[ind.get()].place(width=360, height=225)
        else:
            arrayFotos[ind.get()].place(x=0, y=0, width=0, height=0)
            ind.set(ind.get()+1)
            P5Label.config(text=arrayDescription[ind.get()], font=("Inter", 10))
            arrayFotos[ind.get()].place(width=360, height=225)

    P5Label.bind("<Button>", cambiar)

    #Ventana emergente
    ventanaEmergente = tk.Frame(pantallaInicio, bg="#000028")
    labelDescription = tk.Label(ventanaEmergente, text="DESCRIPCIÓN", height=27, font=("Inter", 11), fg="white", bg="#000028")
    labelDescription.place(width=890, height=435)
    #------------------------------------------------------------------------------------------------------------------------------
    root.resizable(width=False, height=False)
    root.mainloop()

def entrarMenu():
    ventanaPrincipal = tk.Tk()
    ventanaPrincipal.title("SISTEMA DE TRANSPORTE PERSONALIZADO")
    ventanaPrincipal.geometry("800x500")
    
    #------------------------------------------------------------------------------------------------------

    #Menu ---------------------------------------------
    barMenu = tk.Menu(ventanaPrincipal)
    ventanaPrincipal.config(menu=barMenu)
    #---------------------------------------------------

    #Archivo ------------------------------------------
    mArchivo = tk.Menu(barMenu, tearoff=0)

    def aplicacion():
        MessageBox.showinfo("Aplicación", "STP es una aplicación de transporte. Puedes planear tús viajes y envíos")

    mArchivo.add_command(label="APLICACIÓN", font=("Inter", 11), command=aplicacion)
    mArchivo.add_separator()

    def salirSistema():
        try:
            with open("./baseDatos/usuario","wb") as f:
                dump(GUZ,f)
        except Exception as e:
            print(e)
        ventanaPrincipal.destroy()
        ventInicio()

    mArchivo.add_command(label="SALIR", font=("Inter", 11), command=salirSistema)
    #---------------------------------------------------

    #Procesos y consultas ------------------------------
    mProcesosConsulta = tk.Menu(barMenu, tearoff=0)

    def crearRuta():
        obj = GenerarRuta(ventanaPrincipal, GUZ)
        obj.fr.mainloop()
    mProcesosConsulta.add_command(label="CREAR RUTA", font=("Inter", 11),command=crearRuta)

    def crearViaje():
        if GUZ.getRuta() == None:
            raise ExceptionRuta
        else:
            CrearViaje(ventanaPrincipal, GUZ)
    mProcesosConsulta.add_command(label="CREAR VIAJE", font=("Inter", 11), command=crearViaje)

    def enviarMercancia():
        if GUZ.getRuta() == None:
            raise ExceptionRuta
        else:
            EnviarMercancia(ventanaPrincipal, GUZ)
    mProcesosConsulta.add_command(label="ENVIAR MERCANCIA", font=("Inter", 11), command=enviarMercancia)


    def generarBonificacion():
        GenerarBonificacion(ventanaPrincipal, GUZ)

    mProcesosConsulta.add_command(label="BONIFICACION", font=("Inter", 11), command=generarBonificacion)

    def generarFactura():
        GenerarFactura(ventanaPrincipal, GUZ)
    mProcesosConsulta.add_command(label="FACTURA", font=("Inter", 11), command=generarFactura)
    #---------------------------------------------------

    #Ayuda----------------------------------------------
    def acercaDe():
        MessageBox.showinfo("Integrantes", "\nJuan Diego Aguirre Moreno\nAngel David Brand Londoño\nAna María Barragán Ariza\nAndrés Felipe Díez Ángel\nAlejandro Giraldo Quiceno\n")

    mHelp = tk.Menu(barMenu, tearoff=0)
    mHelp.add_command(label="Acerca de", font=("Inter", 11), command=acercaDe)

    barMenu.add_cascade(label="ARCHIVO", menu=mArchivo)
    barMenu.add_cascade(label="PROCESOS Y CONSULTAS", menu=mProcesosConsulta)
    barMenu.add_cascade(label="AYUDA", menu=mHelp)
    #---------------------------------------------------
    #-------------------------------------------------------------------------------------------------------------
    ventanaPrincipal.resizable(width=False, height=False)
    ventanaPrincipal.mainloop()


if __name__ == "__main__":
    ventInicio()