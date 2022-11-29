from .Vehiculo import Vehiculo

class VehiculoCarga(Vehiculo):
    vehiculos = []

    def __init__(self, *args):
        super().__init__(None, None, args[0], args[1], args[3], args[2]) #marca precio modelo placa       
        self._capacidadMaxima = args[4]
        self.vehiculos.append(self)
        
    def getCapacidadMaxima(self):
        return self._capacidadMaxima
    
    def setCapacidadMaxima(self, capacidadMaxima):
        self._capacidadMaxima = capacidadMaxima
    
    @classmethod
    def getVehiculos(cls):
        return cls.vehiculos

    @classmethod
    def validarCapacidad(cls, peso):
        return list(filter(lambda x: x.getCapacidadMaxima() >= peso, cls.vehiculos))
