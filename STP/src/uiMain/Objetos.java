package uiMain;
import gestionAplicacion.Destinos.*;
import gestionAplicacion.Vehiculos.*;
import gestionAplicacion.Personas.*;

public class Objetos {
	/* Se guardan todos los objetos necesarios */
	
	/* Ciudades */
	Ciudad Med = new Ciudad("MEDELLÍN", "ANTIOQUIA");
	Ciudad Bog = new Ciudad("BOGOTÁ", "CUNDINAMARCA");
	Ciudad Bar = new Ciudad("BARRANQUILLA", "ATLÁNTICO");
	Ciudad Car = new Ciudad("CARTAGENA", "BOLIVAR");
	Ciudad Per = new Ciudad("PEREIRA", "RISARALDA");
	Ciudad Cal = new Ciudad("CALI", "VALLE DEL CAUCA");
	Ciudad Buc = new Ciudad("BUCARAMANGA", "SANTANDER");
	Ciudad Jos = new Ciudad("SAN JOSÉ DEL GUAVIARE", "GUAVIARE");
	Ciudad Qui = new Ciudad("QUIBDÓ", "CHOCÓ");
	Ciudad Mar = new Ciudad("SANTA MARTA", "MAGDALENA");
	
	/* Conexiones */
	Conexion MedBog = new Conexion(Med, Bog, 415, 495, 70000);
	Conexion BogBuc = new Conexion(Bog, Buc, 424, 500, 75000);
	Conexion BucMar = new Conexion(Buc, Mar, 539, 562, 80000);
	Conexion MarBar = new Conexion(Mar, Bar, 104, 93, 35000);
	Conexion BarCar = new Conexion(Bar, Car, 119, 138, 40000);
	Conexion CarMed = new Conexion(Car, Med, 640, 730, 90000);
	Conexion MedQui = new Conexion(Med, Qui, 229, 367, 50000);
	Conexion MedPer = new Conexion(Med, Per, 243, 324, 60000);
	Conexion PerCal = new Conexion(Per, Cal, 209, 192, 30000);
	Conexion BogJos = new Conexion(Bog, Jos, 399, 426, 60000);

	/* Conductores */
	Conductor C1 = new Conductor("Angel", "10011020", "38", 15, 40000);
	Conductor C2 = new Conductor("Ana", "1015215", "40", 20, 50000);
	Conductor C3 = new Conductor("Alejandro", "1520022", "51", 10, 30000);
	Conductor C4 = new Conductor("Andres", "152020", "30", 8, 15000);
	Conductor C5 = new Conductor("Juan", "1651561", "40", 10, 30000);

	/* Vehiculos Pasajeros */
	VehiculoPasajeros DOM = new VehiculoPasajeros(EnumVehiculos.DOMINAR400.getMarca(), 
			EnumVehiculos.DOMINAR400.getPrecio(), EnumVehiculos.DOMINAR400.getModelo(),
			EnumVehiculos.DOMINAR400.getPlaca(), 1);
	
	VehiculoPasajeros SR = new VehiculoPasajeros(EnumVehiculos.S1000RR.getMarca(), 
			EnumVehiculos.S1000RR.getPrecio(), EnumVehiculos.S1000RR.getModelo(),
			EnumVehiculos.S1000RR.getPlaca(), 1);
			
	VehiculoPasajeros ONIX = new VehiculoPasajeros(EnumVehiculos.ONIXTURBO.getMarca(), 
			EnumVehiculos.ONIXTURBO.getPrecio(), EnumVehiculos.ONIXTURBO.getModelo(),
			EnumVehiculos.ONIXTURBO.getPlaca(), 4);
	
	VehiculoPasajeros SAN = new VehiculoPasajeros(EnumVehiculos.SANDERO.getMarca(), 
			EnumVehiculos.SANDERO.getPrecio(), EnumVehiculos.SANDERO.getModelo(),
			EnumVehiculos.SANDERO.getPlaca(), 4);
	
	VehiculoPasajeros BER = new VehiculoPasajeros(EnumVehiculos.BERLINGO.getMarca(), 
			EnumVehiculos.BERLINGO.getPrecio(), EnumVehiculos.BERLINGO.getModelo(),
			EnumVehiculos.BERLINGO.getPlaca(), 6);
	
	VehiculoPasajeros TRANS = new VehiculoPasajeros(EnumVehiculos.TRANSPORTER.getMarca(), 
			EnumVehiculos.TRANSPORTER.getPrecio(), EnumVehiculos.TRANSPORTER.getModelo(),
			EnumVehiculos.TRANSPORTER.getPlaca(), 6);
	
	VehiculoPasajeros PARADISO = new VehiculoPasajeros(EnumVehiculos.PARADISO_1200_G7.getMarca(), 
			EnumVehiculos.PARADISO_1200_G7.getPrecio(), EnumVehiculos.PARADISO_1200_G7.getModelo(),
			EnumVehiculos.PARADISO_1200_G7.getPlaca(), 45);
	
	VehiculoPasajeros CITARO = new VehiculoPasajeros(EnumVehiculos.CITARO_K.getMarca(), 
			EnumVehiculos.CITARO_K.getPrecio(), EnumVehiculos.CITARO_K.getModelo(),
			EnumVehiculos.CITARO_K.getPlaca(), 40);
	
	/* Vehiculos de carga */
	VehiculoCarga DMAX = new VehiculoCarga(EnumVehiculos.DMAX.getMarca(), 
			EnumVehiculos.DMAX.getPrecio(), EnumVehiculos.DMAX.getModelo(),
			EnumVehiculos.DMAX.getPlaca(), 1000);
	
	VehiculoCarga DOMI = new VehiculoCarga(EnumVehiculos.DOMINAR400.getMarca(), 
			EnumVehiculos.DOMINAR400.getPrecio(), EnumVehiculos.DOMINAR400.getModelo(),
			EnumVehiculos.DOMINAR400.getPlaca(), 20);
	
	VehiculoCarga FRO = new VehiculoCarga(EnumVehiculos.FRONTIER_D22.getMarca(), 
			EnumVehiculos.FRONTIER_D22.getPrecio(), EnumVehiculos.FRONTIER_D22.getModelo(),
			EnumVehiculos.FRONTIER_D22.getPlaca(), 1000);
	
	VehiculoCarga AUM = new VehiculoCarga(EnumVehiculos.AUMARK_BJ_1039.getMarca(), 
			EnumVehiculos.AUMARK_BJ_1039.getPrecio(), EnumVehiculos.AUMARK_BJ_1039.getModelo(),
			EnumVehiculos.AUMARK_BJ_1039.getPlaca(), 4000);
	
	VehiculoCarga T = new VehiculoCarga(EnumVehiculos.T800.getMarca(), 
			EnumVehiculos.T800.getPrecio(), EnumVehiculos.T800.getModelo(),
			EnumVehiculos.T800.getPlaca(), 30000);
	
}
