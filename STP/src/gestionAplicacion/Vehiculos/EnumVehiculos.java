package gestionAplicacion.Vehiculos;

public enum EnumVehiculos {
	DOMINAR400("BAJAJ", (double) 50000, 2021), 
	S1000RR("BMW",(double) 150000, 2023),

	ONIXTURBO("CHEVROLET",(double) 200000, 2020),
	SANDERO("RENAULT",(double) 170000, 2018), 
	
	F150("FORD",(double) 350000, 2019),
	
	BERLINGO("CITRÖEN",(double) 90000, 2016),
	
	TRANSPORTER("VOLKSWAGEN",(double) 130000, 2015),
	
	PARADISO_1200_G7("MARCOPOLO",(double) 1500000, 2017),
	CITARO_K("MERCEDES-BENZ",(double) 1500000, 2020), 
	
	DMAX("CHEVROLET",(double) 120000, 2012),
	FRONTIER_D22("NISSAN",(double) 100000, 2009), 

	AUMARK_BJ_1039("FOTON",(double) 250000, 2017),

	T800("KENWORTH",(double) 2000000, 2012);

	private final String marca;
	private final Double precio;
	private final Integer modelo;

	private EnumVehiculos(String marca, Double precio, Integer modelo) {
		this.marca = marca;
		this.precio = precio;
		this.modelo = modelo;
	}
}
