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

	/* Conductores */
	Conductor C1 = new Conductor("Angel", "10011020", "38", 15, 40000);
	Conductor C2 = new Conductor("Ana", "1015215", "40", 20, 50000);
	Conductor C3 = new Conductor("Alejandro", "1520022", "51", 10, 30000);
	Conductor C4 = new Conductor("Andres", "152020", "30", 8, 15000);
	Conductor C5 = new Conductor("Juan", "1651561", "40", 10, 30000);

	/* Vehiculos Pasajeros */
	VehiculoPasajeros DOM = new VehiculoPasajeros("BAJAJ DOMINAR 400", 50000, 2021, "AUX-87X", 1);
	VehiculoPasajeros SR = new VehiculoPasajeros("BMW S1000RR", 150000, 2023, "AUX-88X", 1);
	VehiculoPasajeros ONIX = new VehiculoPasajeros("CHEVROLET ONIX", 200000, 2020, "AUX-89X", 4);
	VehiculoPasajeros SAN = new VehiculoPasajeros("RENAULT SANDERO", 170000, 2018, "AUX-90X", 4);
	VehiculoPasajeros FOR = new VehiculoPasajeros("FORD F150", 350000, 2019, "AUX-91X", 6);
	VehiculoPasajeros BER = new VehiculoPasajeros("CITRÖEN BERLINGO", 90000, 2016, "AUX-92X", 6);
	VehiculoPasajeros TRANS = new VehiculoPasajeros("VOLKSWAGEN TRANSPORTER", 130000, 2015, "AUX-93X", 6);
	VehiculoPasajeros PARADISO = new VehiculoPasajeros("MARCOPOLO PARADISO", 1500000, 2017, "AUX-94X", 45);
	VehiculoPasajeros CITARO = new VehiculoPasajeros("MERCEDES-BENZ CITARO-K", 1500000, 2020, "AUX-95X", 40);

	/* Vehiculos de carga */
	VehiculoCarga DOMI = new VehiculoCarga("BAJAJ DOMINAR 400", 12000, 2012, "AUX-96X", 20);
	VehiculoCarga DMAX = new VehiculoCarga("CHEVROLET DMAX", 15000, 2012, "AUX-97X", 1000);
	VehiculoCarga FRO = new VehiculoCarga("NISSAN FRONTIER D22", 15000, 2019, "AUX-98X", 1000);
	VehiculoCarga AUM = new VehiculoCarga("FOTON AUMARK BJ 1039", 25000, 2017, "AUX-99X", 4000);
	VehiculoCarga T = new VehiculoCarga("KENWORTH T800", 50000, 2012, "AUX-01X", 30000);
	
	/* Usuario */
	Usuario Guz = new Usuario("Jaime Alberto Guzmán", "123456789", "20");
	
}
