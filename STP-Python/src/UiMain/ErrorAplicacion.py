from tkinter import messagebox

class ErrorAplicacion(Exception):
    def __init__(self, message=""):
        self.message = message
        super().__init__(self.message)

#Excepcion 1
class ExceptionEqual(ErrorAplicacion):
    def __init__(self, titulo, message=""):
        super().__init__("Manejo de errores de la aplicación: " + message)
        messagebox.showerror(titulo, self.message)

class ExceptionConductor(ExceptionEqual):
    def __init__(self):
        super().__init__("Excepción de conductor", "Seleccionaste dos conductores iguales")


class ExceptionCiudad(ExceptionEqual):
    def __init__(self):
        super().__init__("Excepción de ciudad", "Seleccionaste dos ciudades iguales")


#Excepcion 2
class ExceptionClick(ErrorAplicacion):
    def __init__(self, titulo, message=""):
        super().__init__("Manejo de errores de la aplicación: " + message)
        messagebox.showerror(titulo, self.message)

class ExceptionAceptar(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción al guardar", "Tienes campos sin llenar, llénalos")

class ExceptionValidar(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción al validar", "No has ingresado datos, ingresalos.")

class ExceptionAgregar(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción al agregar", "Estás intentando agregar un valor no númerico")

class ExceptionFecha(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción de fecha", "Ingresaste una fecha incorrecta. Revisa")

class ExceptionFactura(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción de factura", "No has seleccionado ningún viaje o envío")

class ExceptionRuta(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción de ruta", "No has seleccionado ninguna ruta")

class ExceptionVehiculoCarga(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción de vehiculo", "El vehiculo seleccionado no puede con la carga que deseas enviar. Selecciona otro")

class ExceptionVehiculoPas(ExceptionClick):
    def __init__(self):
        super().__init__("Excepción de vehiculo", "El vehiculo seleccionado no soporta ese número de pasajeros. Selecciona otro")