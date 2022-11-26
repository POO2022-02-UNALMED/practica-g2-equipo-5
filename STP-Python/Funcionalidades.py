from Usuario import Usuario
from Conductor import Conductor

from Mercancia import Mercancia
from Producto import Producto
from Viaje import Viaje

from VehiculoCarga import VehiculoCarga
from VehiculoPasajero import VehiculoPasajeros
from Conexion import Conexion

import math


# Clase Principal
# Agregar acá las funcionalidades

#Funcionalidad Generar Factura
def generarFactura (usuario):
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
            usuario.mercanciaBonificado(envios[sEnvio])
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



#Funcionalidad Enviar Mercancia
def enviarMercancia(usuario):

    #Usuario
    mercancia = Mercancia()
    mercancia.setUsuario(usuario)

    #Ruta
    #ruta = usuario.getRuta()

    #Productos
    nProductos = int(input("Ingrese el número de productos a envíar: "))
    for i in range(nProductos):
        tProd = input("Ingrese el producto a enviar: ")
        pProd = int(input("Ingrese el peso en kg: "))
        mercancia.agregarProducto(Producto(tProd, pProd))
    
    aProductos = mercancia.getProductos()
    tPesos = sum(list(map(lambda x: x.getPeso(), aProductos)))
    print("El peso total del envío es de: ", tPesos, " kg")

    #Vehiculos
    print("Ahora se mostrarán los vehiculos que pueden soportar ese peso")

    vPosibles = VehiculoCarga.validarCapacidad(tPesos)
    indV = 1
    for veh in vPosibles:
        print(f'{indV}. {veh.getMarca()}, {veh.getModelo()}')
        indV += 1
    vSelec = int(input("Seleccione un vehiculo: "))

    mercancia.setVehiculo(vPosibles[(vSelec-1)])

    #Conductor
    aConductores = Conductor.getConductores()
    indC = 1
    for cond in aConductores:
        print(f'{indC}. {cond.presentacion()}')
        indC += 1
    cSelec = int(input("Seleccione un conductor: "))

    mercancia.setConductor(aConductores[(cSelec-1)])

    #Fecha
    fEnvio = input("Digíte la fecha que desea realizar el envío (yyyy-MM-dd): ")
    mercancia.setFecha(fEnvio)

    print("Felicidades, ha completado con éxito su envío.")
    usuario.agregarMercancia(mercancia)




    #funcionalidad generarRuta
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
        return res[:3] if len(res[0])!=1 else res[:1]
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
        for ruta in rutas:
            recorrido = "-".join([ruta[0].ciudadA]+[x.ciudadB for x in ruta])
            s = f"Las ciudades a recorrer son: {recorrido}\nDistancia: {self.suma(ruta,'D')} km\nPrecio: ${self.suma(ruta,'P')}\nTiempo: {self.hm(self.suma(ruta,'T'))}\n"
            print(s)
         

    def menuGenerarRuta(self):
        CIUDADES = [
            "MEDELLÍN","BOGOTÁ","BUCARAMANGA","SANTA MARTA",
            "BARRANQUILLA","CARTAGENA","QUIBDÓ","PEREIRA",
            "CALI","SAN JOSÉ DEL GUAVIARE"
            ]
        print("Ciudades de operación: ")
        i = 1
        for ciudad in CIUDADES:
            print(f"{i} {ciudad}")
            i+=1
        origen = CIUDADES[int(input("-> Elija la ciudad origen: "))-1]
        destino = CIUDADES[int(input("-> Elija la ciudad destino: "))-1]

        rutas = self.rutas(origen,destino)
      
        #self.pintarRuta(rutas[0])
        self.formato(rutas)

    #funcionalidad crearViaje
    def crearViaje (usuario):
        viaje = Viaje()
        viaje.setUsuario = usuario

        ruta = usuario.getRuta()

        print("-> Ingrese numero de acompañantes: ")
        numeroAcompañantes = int(input())
        

        for i in range(numeroAcompañantes-1):
            nombre = ""
            edad = ""
            print("-> Ingrese nombre de acompañante: ")
            nombre = input()
            print("-> Ingrese edad de acompañante: ")
            edad = input()
            pasajero = (nombre, edad)
            viaje.agregarPasajeros(pasajero)

        numeroConductores = 0
        if (ruta.getDistancia > 1000):
            numeroConductores = 2
        else:
            numeroConductores = 1
        
        print("Ahora, se mostrarán los vehiculos que pueden transportar esta cantidad de pasajeros ")
        numeroAcompañantes += 1
        vehiculosPosibles = []
        vehiculosPosibles = VehiculoPasajeros.validarCapacidad(numeroConductores, numeroAcompañantes)
        indVehiculo = 0
        for vehiculo in vehiculosPosibles :
            indVehiculo = indVehiculo + 1
            print(indVehiculo + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo())
        
        print("-> De la lista anterior, seleccione un vehiculo: ")
        vehiculoSeleccionado = int(input())
        viaje.setVehiculo(vehiculosPosibles[vehiculoSeleccionado-1])

        if numeroConductores == 2:
            aConductores = Conductor.getConductores()
            indC = 1
            for cond in aConductores:
                print(f'{indC}. {cond.presentacion()}')
                indC += 1
            conductorSelec = int(input("Seleccione el primer conductor: "))
            conductorSelec2 = int(input("Seleccione el segundo conductor: "))

            viaje.agregarConductor(conductorSelec)
            viaje.agregarConductor(conductorSelec2)
            
        elif numeroConductores == 1:
            aConductores = Conductor.getConductores()
            indC = 1
            for cond in aConductores:
                print(f'{indC}. {cond.presentacion()}')
                indC += 1
            conductorSelec = int(input("Seleccione el conductor: "))
            viaje.agregarConductor(conductorSelec)

        fEnvio = input("Digíte la fecha que desea realizar el envío (yyyy-MM-dd): ")
        mercancia.setFecha(fEnvio)

        print("Felicidades, ha completado con éxito su envío.")
        usuario.agregarMercancia(mercancia)

#Funcionalidad generarBonificacion
    def generarBonificacion(usuario):

        cantidadViajes = len(usuario.getViajes())
        cantidadMercancias = len(usuario.getMercancias())

        cantidadViajes+=1
        cantidadMercancias+=1

        print("-> BONIFICACION <-", "\nCada 4 viajes, obtiene un 5to viaje con 30% de descuento."
				, "\nCada 4 envíos de mercancia, en el 5to obtiene 30% de descuento.")

        print("\nServicios: \n1. Viaje \n2. Mercancia")

        iServicio = int(input("\n-> Para que servicio desea obtener la bonificación: "))

        if iServicio == 1:
            if cantidadViajes % 5 != 0:
                print(" \n-> NO PUEDE OBTENER LA BONIFICACION <-Ahora sólo cuenta con ", len(usuario.getViajes()), " viajes")

            else:
                print("\nA continuacion por favor cree el nuevo viaje con reduccion del 30% en el precio")
                
                menuGenerarRuta(usuario)
                crearViaje(usuario)

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
                    print("\nAdicionalmente, por ser día martes se le reducirá un 10% del precio del viaje"), 
                    viaje.setIsBonificacion(True)

            #####
            

        else:
            if cantidadMercancias % 5 != 0:
                print(" \n-> NO PUEDE OBTENER LA BONIFICACION <-Ahora sólo cuenta con ", len(usuario.getMercancias()), " envios")

            else: 
                print("\nA continuacion por favor realize el nuevo envío con reduccion del 30% en el precio")

                menuGenerarRuta(usuario)
                enviarMercancia(usuario)

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
                    print("\nAdicionalmente, por ser día martes se le reducirá un 10% del precio del viaje")
                    mercancia.setIsBonificacion(True)




