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


    def generarFactura(self):



        def selecMercancia():
            
            print("1. Mercancia")
            print("2. Viaje")
            selec = int(input("Seleccione la opción de la cuál desea conocer su factura: "))

    #Caso - Mercancia
            if selec == 1:
                envios = usuario.getMercancias()
                indE = 0
                
                for envio in envios:
                    cDestino = (envio.getRuta().getRuta())[-1]
                    print(f'{indE}. {cDestino}, Distancia: {envio.getRuta().getDistancia()}')
                    indE += 1
                    sEnvio = (int(input("Seleccione un envío: ")))-1
                    
                if sEnvio % 5 == 0:
                    suario.mercanciaBonificado(envios[sEnvio])
            
                else:
                    usuario.mercancia(envios[sEnvio])


    #Caso - Viaje
            elif selec == 2:
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

frameExplicacion = tk.LabelFrame(ventPrin, width=780, height=70, bg="#23d2aa")
frameExplicacion.place(x=10, y=85)
explicacion1 = "En esta seccion se muestra la factura de su viaje o del envio de su mercancia, por favor"
explicacion2="\n\n indique cual factura desea conocer"
subtitulo = tk.Label(frameExplicacion, text=explicacion1+explicacion2 , fg="#000028", font=("Inter", 14), bg="#23d2aa")
subtitulo.place(x = 0, y = 0)


ventPrin.mainloop()