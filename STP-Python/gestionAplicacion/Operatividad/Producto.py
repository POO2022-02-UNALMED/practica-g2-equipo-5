class Producto():

    def __init__(self, tipo, peso):
        self._tipo = tipo
        self._peso = peso

    def getTipo(self):
        return self._tipo

    def getPeso(self):
        return self._peso

    def setTipo(self, tipo):
        self._tipo = tipo

    def setPeso(self, peso):
        self._peso = peso
        