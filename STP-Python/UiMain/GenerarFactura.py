from Base import*
import tkinter as tk
import tkinter

ventPrin = Tk()
ventPrin.geometry("800x500")

frame = tk.Frame(ventPrin, width=1090, height=835)
frame.place(x=0, y=0)


class GenerarFactura(Base):
    def __init__(self, master, usuario):
        super().__init__(master, "GENERAR FACTURA")
        self.usuario = usuario
        self.generarFactura()

#Caso - Mercancia
    def selecMercancia(usuario):
        Mercancia = Mercancia
        Viaje = Viaje
        
        if Mercancia == Mercancia:
            envios = usuario.getMercancias()
            indE = 0
            
            for envio in envios:
                cDestino = (envio.getRuta().getRuta())[-1]
                print(f'{indE}. {cDestino}, Distancia: {envio.getRuta().getDistancia()}')
                indE += 1
                sEnvio = (int(input("Seleccione un envío: ")))-1
                    
            if sEnvio % 5 == 0:
                usuario.mercanciaBonificado(envios[sEnvio])
            
            else:
                usuario.mercancia(envios[sEnvio])


#Caso - Viaje
    def selectVaije(usuario):
        if Viaje == Viaje:
            viajes = usuario.getViajes()
            indV = 0
                
            for viaje in viajes:
                cDestino = (viaje.getRuta().getRuta())[-1]
                print(f'{indV}. {cDestino}, Distancia: {viaje.getRuta().getDistancia()}')
                indV += 1
                sViaje = (int(input('Seleccione un viaje: ')))-1
                
                if sViaje % 5 == 0:
                    usuario.viajeBonificado(viajes[-1])
            
                else:
                    usuario.viaje(viajes[-1])



frameTittle = tk.LabelFrame(ventPrin, width=780, height=70, bg="#23d2aa")
frameTittle.place(x=10, y=10)
Tittle = tk.Label(frameTittle, text="GENERAR FACTURA", fg="#000028", font=("Inter", 15), bg="#23d2aa")
Tittle.place(x = 0, y = 5, width=800, height=50)

frameExplain = tk.LabelFrame(ventPrin, width=780, height=70, bg="#23d2aa")
frameExplain.place(x=10, y=80)
explain1 = "En esta seccion se muestra la factura de su viaje o del envio de su mercancia, por favor"
explain2="\n\n indique cual factura desea conocer"
subtitulo = tk.Label(frameExplain, text=explain1+explain2 , fg="#000028", font=("Inter", 14), bg="#23d2aa")
subtitulo.place(x = 0, y = 0)

frameOpciones = tk.LabelFrame(ventPrin, width=480, height=138)
frameOpciones.place(x=235, y=200)
frameOpciones.columnconfigure(0, weight=1)
frameOpciones.columnconfigure(1, weight=1)

frameOpciones.rowconfigure(0, weight=1)
frameOpciones.rowconfigure(1, weight=1)

textoViaje = tkinter.Label(frameOpciones, text="Conocer factura de viajes: ", font="arial 12")
textoViaje.grid(row=0, column=0, columnspan=2, pady=8, padx=8)
textoMercancia = tkinter.Label(frameOpciones, text="Conocer factura de mercancia: ", font="arial 12")
textoMercancia.grid(row=1, column=0, columnspan=2, pady=8, padx=8)

botonViaje = tk.Button(frameOpciones, text="Viaje", bg="#000028", fg="white", font=("Inter", 11))
botonViaje.grid(row=0, column=2, columnspan=1, pady=8, padx=8)
botonMercancia = tk.Button(frameOpciones, text="Mercancia", bg="#000028", fg="white", font=("Inter", 11))
botonMercancia.grid(row=1, column=2, columnspan=1, pady=8, padx=8)

ventPrin.mainloop()