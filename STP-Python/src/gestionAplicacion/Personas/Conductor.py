from .Persona import Persona

class Conductor(Persona):
    conductores=[]
    
    def __init__(self, *args):
        if len(args) == 6:
            super().__init__(args[0], args[1], args[2], args[3])
            self._vehiculo = args[4]
            self._experiencia = args[5]
        if len(args) == 5:
            super().__init__(args[0], args[1], None, args[2])
            self._experiencia = args[3]
            self._precio = args[4]
            self.conductores.append(self)



    def setVehiculo (self,vehiculo):
        self._vehiculo = vehiculo

    def getVehiculo(self):
        return self._vehiculo

    def setExperiencia(self,experiencia):
        self._experiencia = experiencia

    def getExperiencia(self):
        return self._experiencia

    def setPrecio(self,precio):
        self._precio=precio
    
    def getPrecio(self):
        return self._precio

    @classmethod
    def setConductores(cls,conductores):
        cls.conductores = conductores

    @classmethod
    def getConductores(cls):
        return cls.conductores
    
    def presentacion(self):
        salida = self._nombre + ", " + str(self._edad) + " años. " + str(self._experiencia) + " años de experiencia"
        return salida 