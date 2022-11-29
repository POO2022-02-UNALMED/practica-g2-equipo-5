class Viaje():
    def __init__(self, *args):
        if len(args) == 8:
            self._usuario = args[0]
            self._ruta = args[1]
            self._pasajeros = args[2]
            self._vehiculo = args[3]
            self._conductores = args[4]
            self._factura = args[5]
            self._fecha = args[6]
            self._isBonificacion = args[7]
        elif len(args) == 0:
            self._usuario = None
            self._ruta = None
            self._pasajeros = []
            self._vehiculo = None
            self._conductores = []
            self._factura = None
            self._fecha = None
            self._isBonificacion = None

    def getUsuario(self):
        return self._usuario
    
    def getRuta(self):
        return self._ruta
    
    def getPasajeros(self):
        return self._pasajeros
    
    def getVehiculo(self):
        return self._vehiculo
    
    def getConductores(self):
        return self._conductores
    
    def getFactura(self):
        return self._factura

    def getFecha(self):
        return self.getFecha
    
    def getIsBonificacion(self):
        return self._isBonificacion

    def setUsuario(self, usuario):
        self._usuario = usuario
    
    def setRuta(self, ruta):
        self._ruta = ruta
    
    def setPasajeros(self, pasajeros):
        self._pasajeros = pasajeros
    
    def setVehiculo(self, vehiculo):
        self._vehiculo = vehiculo
    
    def setConductores(self, conductores):
        self._conductores = conductores
    
    def setFactura(self, factura):
        self._factura = factura

    def setFecha(self, fecha):
        self._fecha = fecha
    
    def setIsBonificacion(self, isBonificacion):
        self._isBonificacion = isBonificacion

    def agregarPasajeros(self, pasajero):
        self._pasajeros.append(pasajero)
    
    def agregarConductor(self, conductor):
        self._conductores.append(conductor)

    def presentacion(self):
        cA = self.getRuta().getRuta()[0].value[0]
        cB = self.getRuta().getRuta()[-1].value[1]
        return "Ruta: " + cA + " - " + cB + ". Fecha: " + self._fecha
    