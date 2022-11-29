class Mercancia():
    
    def __init__(self, *args):
        if len(args) == 8:
            self._usuario = args[0]
            self._ruta = args[1]
            self._productos = args[2]
            self._vehiculo = args[3]
            self._conductor = args[4]
            self._factura = args[5]
            self._fecha = args[6]
            self._isBonificacion = args[7]
        elif len(args) == 0:
            self._usuario = None
            self._ruta = None
            self._productos = []
            self._vehiculo = None
            self._conductor = None
            self._factura = None
            self._fecha = None
            self._isBonificacion = None

    def getUsuario(self):
        return self._usuario
    
    def getRuta(self):
        return self._ruta
    
    def getProductos(self):
        return self._productos
    
    def getVehiculo(self):
        return self._vehiculo
    
    def getConductor(self):
        return self._conductor
    
    def getFactura(self):
        return self._factura

    def getFecha(self):
        return self._fecha
    
    def getIsBonificacion(self):
        return self._isBonificacion

    def setUsuario(self, usuario):
        self._usuario = usuario
    
    def setRuta(self, ruta):
        self._ruta = ruta
    
    def setProductos(self, productos):
        self._productos = productos
    
    def setVehiculo(self, vehiculo):
        self._vehiculo = vehiculo
    
    def setConductor(self, conductor):
        self._conductor = conductor
    
    def setFactura(self, factura):
        self._factura = factura

    def setFecha(self, fecha):
        self._fecha = fecha
    
    def setIsBonificacion(self, isBonificacion):
        self._isBonificacion = isBonificacion

    def agregarProducto(self, producto):
        self._productos.append(producto)

    def presentacion(self):
        cA = self.getRuta().getRuta()[0].value[0]
        cB = self.getRuta().getRuta()[-1].value[1]
        return "Ruta: " + cA + " - " + cB + ". Fecha: " + self._fecha
