
from Persona import Persona

class Usuario(Persona):
    user=[]

    """def __init__(self, nombre, documento, edad, viajes, mercancias, facturas, ruta):
        super().__init__(nombre, documento, None, edad)
        self._viajes = [viajes]
        self._mercancias = [mercancias]
        self._facturas = [facturas]
        self._ruta = ruta
        Usuario.user.append(self)
        """

    def __init__(self, *args):
        if len(args)==7:
            #super().__init__(nombre, documento, None #direccion, edad)
            super().__init__(args[0], args[1], None, args[2])  
            self._viajes = [args[3]] #De tipo Viaje
            self._mercancias = [args[4]] #De tipo Mercancia
            self._facturas = [args[5]] #De tipo Factura
            self._ruta = args[6] #De tipo ruta
            Usuario.user.append(self)

        if len(args)==2:
            super().__init__(args[0], None, None, args[1])

        if len(args)==3:
            super().__init__(args[0],args[1],None,args[2])
            self._viajes = [] #De tipo Viaje
            self._mercancias = [] #De tipo Mercancia
            self._facturas = [] #De tipo Factura
            self._ruta = None
            Usuario.user.append(self)
        
        if len(args)==0:
            super.__init__()
    
    def presentacion():
        return 

    def setViajes(self, viajes):
        self._viajes = viajes

    def getViajes(self):
        return self._viajes

    def setMercancias(self, mercancias):
        self._mercancias = mercancias
    
    def getMercancias(self):
        return self._mercancias
    
    def setFacturas(self,facturas):
        self._facturas = facturas

    def getFacturas (self):
        return self._facturas
    
    def setRuta(self, ruta):
        self._ruta=ruta
    
    def getRuta(self):
        return self._ruta

    def agregarMercancia(self, mercancia):
        self._mercancias.append(mercancia)

    def agregarViaje(self, viaje):
        self._viajes.append(viaje)

    @classmethod
    def setUser(cls,user):
        cls._user = user

    @classmethod
    def getUser(cls):
        return cls._user


def mercanciaBonificado(self, merc):
    print("-------------------------------------------")
    print("SISTEMA DE TRANSPORTE PERSONALIZADO")
    print("-------------------------------------------")
    print("Nombre :" + self.getNombre())
    print("Documento: " + self.getDocumento())
    print("Lista de productos: ")
    for prod in merc.getProductos():
        print("- " + prod.getTipo() + ", " + prod.getPeso() + " kg.")

    rutaGenerada = merc.getRuta().getRuta().get(0)
    precio = rutaGenerada.precio
    precio += merc.getVehiculo().getPrecio()
    precio += merc.getConductor().getPrecio()
    print("\nCiudad de origen: " + rutaGenerada.ciudadA)
    print("Ciudad de destino: " + rutaGenerada.ciudadB)
    print("Distancia: " + rutaGenerada.distancia + " km")
    print("Precio: " + str(precio) + "COP")

    precBon = None
    if merc.getIsBonificacion() == False:
        print("\nEn este envío cuentas con una bonificación del 30%")
        des = (precio * 30)/100
        precBon = precio - des
    else:
        print("\nEn este envío cuentas con una bonificación del 45%")
        des = (precio * 45)/100
        precBon = precio - des
    print("Precio con bonificación : " + str(precBon) + "COP")

    print("-------------------------------------------")
    print("Gracias por confiar en nostros. STP.")
    print("-------------------------------------------")

def mercancia(self, merc):
    print("-------------------------------------------")
    print("SISTEMA DE TRANSPORTE PERSONALIZADO")
    print("-------------------------------------------")
    print("Nombre :" + self.getNombre())
    print("Documento: " + self.getDocumento())
    print("Lista de productos: ")
    for prod in merc.getProductos():
        print("- " + prod.getTipo() + ", " + prod.getPeso() + " kg.")
    rutaGenerada = merc.getRuta().getRuta().get(0)
    precio = rutaGenerada.precio
    precio += merc.getVehiculo().getPrecio()
    precio += merc.getConductor().getPrecio()
    print("\nCiudad de origen: " + rutaGenerada.ciudadA)
    print("Ciudad de destino: " + rutaGenerada.ciudadB)
    print("Distancia: " + rutaGenerada.distancia + " km")
    print("Precio: " + str(precio) + "COP")

    print("-------------------------------------------")
    print("Gracias por confiar en nostros. STP.")
    print("-------------------------------------------")

def viajeBonificado(self, viaje):
    print("-------------------------------------------")
    print("SISTEMA DE TRANSPORTE PERSONALIZADO")
    print("-------------------------------------------")
    print("Nombre :" + self.getNombre())
    print("Documento: " + self.getDocumento())
    print("Lista de acompañantes: ")
    for prod in viaje.getPasajeros():
        print("- " + prod.getNombre() + ", " + prod.getEdad() + " años.")
    rutaGenerada = viaje.getRuta().getRuta().get(0)
    precio = rutaGenerada.precio
    precio += viaje.getVehiculo().getPrecio()
    precioConductores = 0
    for cond in viaje.getConductor():
        precioConductores += cond.getPrecio()
    precio += precioConductores

    print("\nCiudad de origen: " + rutaGenerada.ciudadA)
    print("Ciudad de destino: " + rutaGenerada.ciudadB)
    print("Distancia: " + rutaGenerada.distancia + " km")
    print("Precio: " + str(precio) + "COP")

    precBon = 0
    print("Precio: " + viaje.getRuta().getPrecio() + "COP")
    if viaje.getIsBonificacion() == False:
        print("\nEn este viaje cuentas con una bonificación del 30%")
        des = (precio * 30)/100
        precBon = precio - des
    else:
        print("\nEn este viaje cuentas con una bonificación del 45%")
        des = (precio * 45)/100
        precBon = precio - des
    print("-------------------------------------------")
    print("Gracias por confiar en nostros. STP.")
    print("-------------------------------------------")

def viaje(self, viaje):
    print("-------------------------------------------")
    print("SISTEMA DE TRANSPORTE PERSONALIZADO")
    print("-------------------------------------------")
    print("Nombre :" + self.getNombre())
    print("Documento: " + self.getDocumento())
    print("Lista de acompañantes: ")
    for prod in viaje.getPasajeros():
        print("- " + prod.getNombre() + ", " + prod.getEdad() + " años.")
    rutaGenerada = viaje.getRuta().getRuta().get(0)
    precio = rutaGenerada.precio
    precio += viaje.getVehiculo().getPrecio()
    precioConductores = 0
    for cond in viaje.getConductor():
        precioConductores += cond.getPrecio()
    precio += precioConductores
    print("\nCiudad de origen: " + rutaGenerada.ciudadA)
    print("Ciudad de destino: " + rutaGenerada.ciudadB)
    print("Distancia: " + rutaGenerada.distancia + " km")
    print("Precio: " + str(precio) + "COP")

    print("-------------------------------------------")
    print("Gracias por confiar en nostros. STP.")
    print("-------------------------------------------")

