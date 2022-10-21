package gestionAplicacion.Destinos;

import java.util.ArrayList;

public enum Conexion {
	
	
	A("MEDELLÍN", "BOGOTÁ", 415, 495, 70000),
	B("BOGOTÁ", "BUCARAMANGA", 424, 500, 75000),
	C("BUCARAMANGA", "SANTA MARTA", 539, 562, 80000),
	D("SANTA MARTA", "BARRANQUILLA", 104, 93, 35000),
	E("BARRANQUILLA", "CARTAGENA", 119, 138, 40000),
	F("CARTAGENA", "MEDELLÍN", 640, 730, 90000),
	G("MEDELLÍN", "QUIBDÓ", 229, 367, 50000),
	H("MEDELLÍN", "PEREIRA", 243, 324, 60000),
	I("PEREIRA", "CALI", 209, 192, 30000),
	J("BOGOTÁ", "SAN JOSÉ DEL GUAVIARE", 399, 426, 60000);

	
	public final String ciudadA;
	public final String ciudadB;
	public final double distancia;
	public final int tiempo;
	public final double precio;


	private Conexion(String ciudadA, String ciudadB, double distancia, int tiempo, double precio) {
		this.ciudadA = ciudadA;
		this.ciudadB = ciudadB;
		this.distancia = distancia;
		this.tiempo = tiempo;
		this.precio = precio;
	}
	
}
