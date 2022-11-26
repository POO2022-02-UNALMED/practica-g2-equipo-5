from enum import Enum

class Conexion(Enum):

    MedBog = ("MEDELLÍN", "BOGOTÁ", 415, 495, 70000)
    BogMed = ("BOGOTÁ", "MEDELLÍN", 415, 495, 70000)
    BogBuc = ("BOGOTÁ", "BUCARAMANGA", 424, 500, 75000)
    BucBog = ("BUCARAMANGA", "BOGOTÁ", 424, 500, 75000)
    BucSan = ("BUCARAMANGA", "SANTA MARTA", 539, 562, 80000)
    SanBuc = ("SANTA MARTA", "BUCARAMANGA", 539, 562, 80000)
    SanBar = ("SANTA MARTA", "BARRANQUILLA", 104, 93, 35000)
    BarSan = ("BARRANQUILLA", "SANTA MARTA", 104, 93, 35000)
    BarCar = ("BARRANQUILLA", "CARTAGENA", 119, 138, 40000)
    CarBar = ("CARTAGENA", "BARRANQUILLA", 119, 138, 40000)
    CarMed = ("CARTAGENA", "MEDELLÍN", 640, 730, 90000)
    MedCar = ("MEDELLÍN", "CARTAGENA", 640, 730, 90000)
    MedQui = ("MEDELLÍN", "QUIBDÓ", 229, 367, 50000)
    QuiMed = ("QUIBDÓ", "MEDELLÍN", 229, 367, 50000)
    MedPer = ("MEDELLÍN", "PEREIRA", 243, 324, 60000)
    PerMed = ("PEREIRA", "MEDELLÍN", 243, 324, 60000)
    PerCal = ("PEREIRA", "CALI", 209, 192, 30000)
    CalPer = ("CALI", "PEREIRA", 209, 192, 30000)
    BogSjo = ("BOGOTÁ", "SAN JOSÉ DEL GUAVIARE", 399, 426, 60000)
    SjoBog = ("SAN JOSÉ DEL GUAVIARE", "BOGOTÁ", 399, 426, 60000)

    def __init__(self, a, b,d,t,p):
        self.a = a
        self.b = b 
        self.d = d
        self.t = t
        self.p = p

    @property       
    def ciudadA(self):
        return self.a

    @property       
    def ciudadB(self):
        return self.b 
    @property       
    def distancia(self):
        return self.d 
    @property       
    def tiempo(self):
        return self.t 
    @property       
    def precio(self):
        return self.p