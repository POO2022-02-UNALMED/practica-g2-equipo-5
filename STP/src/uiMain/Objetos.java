package uiMain;
import gestionAplicacion.Destinos.*;

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

}
