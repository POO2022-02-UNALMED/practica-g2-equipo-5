class Facturacion():

    def __init__(self, *args):
        if len(args) == 6:
            self._pasajeros = args[0]
            self._productos = args[1]
            self._distancia = args[2]
            self._peso = args[3]
            self._precio = args[4]
            self._tiempo = args[5]
        elif len(args) == 0:
            self._pasajeros = []
            self._productos = []
            self._distancia = None
            self._peso = None
            self._precio = None
            self._tiempo = None
    
    def getPasajeros(self):
        return self._pasajeros
    
    def getProductos(self):
        return self._productos
    
    def getDistancia(self):
        return self._distancia
    
    def getPeso(self):
        return self._peso
    
    def getPrecio(self):
        return self._precio
    
    def getTiempo(self):
        return self._precio

    def setPasajeros(self, pasajeros):
        self._pasajeros = pasajeros
    
    def setProductos(self, productos):
        self._productos = productos

    def setDistancia(self, distancia):
        self._distancia = distancia
    
    def setPeso(self, peso):
        self._peso = peso

    def setPrecio(self, precio):
        self._precio = precio
    
    def setTiempo(self, tiempo):
        self._tiempo = tiempo