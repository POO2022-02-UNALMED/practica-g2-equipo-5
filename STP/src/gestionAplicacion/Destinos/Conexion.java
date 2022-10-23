package gestionAplicacion.Destinos;


public enum Conexion {
	
	
	A("MEDELLÍN", "BOGOTÁ", 415, 495, 70000),
	AA("BOGOTÁ", "MEDELLÍN", 415, 495, 70000),
	B("BOGOTÁ", "BUCARAMANGA", 424, 500, 75000),
	BB("BUCARAMANGA", "BOGOTÁ", 424, 500, 75000),
	C("BUCARAMANGA", "SANTA MARTA", 539, 562, 80000),
	CC("SANTA MARTA", "BUCARAMANGA", 539, 562, 80000),
	D("SANTA MARTA", "BARRANQUILLA", 104, 93, 35000),
	DD("BARRANQUILLA", "SANTA MARTA", 104, 93, 35000),
	E("BARRANQUILLA", "CARTAGENA", 119, 138, 40000),
	EE("CARTAGENA", "BARRANQUILLA", 119, 138, 40000),
	F("CARTAGENA", "MEDELLÍN", 640, 730, 90000),
	FF("MEDELLÍN", "CARTAGENA", 640, 730, 90000),
	G("MEDELLÍN", "QUIBDÓ", 229, 367, 50000),
	M("QUIBDÓ", "MEDELLÍN", 229, 367, 50000),
	H("MEDELLÍN", "PEREIRA", 243, 324, 60000),
	K("PEREIRA", "MEDELLÍN", 243, 324, 60000),
	I("PEREIRA", "CALI", 209, 192, 30000),
	L("CALI", "PEREIRA", 209, 192, 30000),
	J("BOGOTÁ", "SAN JOSÉ DEL GUAVIARE", 399, 426, 60000),
	N("SAN JOSÉ DEL GUAVIARE", "BOGOTÁ", 399, 426, 60000);

	
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
