from .Vehiculo import Vehiculo


class VehiculoPasajeros(Vehiculo):
    vehiculos = []
    def __init__(self, *args):
        super().__init__(None, None, args[0], args[1], args[3], args[2]) #(marca,precio,modelo,placa)   
        self.nAsientos = args[4] 
        self.vehiculos.append(self)

    def getnAsientos(self):
        return self.nAsientos

    def setnAsientos(self, nAsientos):
        self.nAsientos = nAsientos

    @classmethod
    def getVehiculos(cls):
        return cls.vehiculos

    @classmethod
    def validarCapacidad(cls, nPas):
        return list(filter(lambda x: int(x.getnAsientos()) >= nPas, cls.vehiculos))
        