class Vehiculo ():

    def __init__(self, conductor, ruta, marca, precio, placa, modelo):
        self._conductor = conductor
        self._ruta = ruta
        self._marca = marca
        self._precio = precio
        self._placa = placa
        self._modelo = modelo
    
    def getConductor(self):
        return self._conductor
    def getRuta(self):
        return self._ruta
    def getMarca(self):
        return self._marca
    def getPlaca(self):
        return self._placa
    def getModelo(self):
        return self._modelo
    def getPrecio(self):
        return self._precio

    def setConductor(self, conductor):
        self._conductor = conductor
    def setRCuta(self, ruta):
        self._ruta = ruta
    def setMarca(self, marca):
        self._marca = marca
    def setPrecio(self, precio):
        self._precio = precio
    def setPlaca(self, placa):
        self._placa = placa
    def setModelo(self, modelo):
        self._modelo = modelo
    
    def presentacion(self):
        sal = str(self._marca) + ", " + str(self._modelo)
        return sal 
