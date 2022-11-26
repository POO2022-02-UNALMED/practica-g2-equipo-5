from dis import dis


class Ruta():
    
    def __init__(self, *args):
        if len(args) == 4:
            self._ruta = args[0]
            self._precio = args[1]
            self._distanica = args[2]
            self._tiempo = args[3]
        elif len(args) == 0:
            self._ruta = []
            self._precio = []
            self._distanica = []
            self._tiempo = []
    
    def getRuta(self):
        return self._ruta

    def getPrecio(self):
        return self._precio

    def getDistancia(self):
        return self._distanica

    def getTiempo(self):
        return self._distanica

    def setRuta(self, ruta):
        self._ruta = ruta
    
    def setPrecio(self, precio):
        self._precio = precio
    
    def setDistancia(self, distancia):
        self._distanica = distancia
    
    def setTiempo(self, tiempo):
        self._tiempo = tiempo
    


