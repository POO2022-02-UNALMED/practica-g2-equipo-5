from abc import ABC

class Persona(ABC):
    def __init__(self, *args):
        if len(args) == 4:
            self._nombre = args[0]
            self._documento = args[1]
            self._direccion = args[2]
            self._edad = args[3]
        
        elif len(args)==0:
            self._nombre = None
            self._documento = None
            self._direccion = None
            self._edad = None


    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getDocumento(self):
        return self._documento
    
    def setDocumento(self,documento):
        self._documento = documento

    def getDireccion(self):
        return self._direccion

    def setDireccion(self,direccion):
        self._direccion = direccion

    def getEdad(self):
        return self._edad

    def setEdad(self,edad):
        self._edad = edad
