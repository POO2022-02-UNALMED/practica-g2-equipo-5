package gestionAplicacion.Vehiculos;

public enum EnumVehiculos {
	DOMINAR400("BAJAJ", (double) 18000000, 2021), 
	S1000RR("BMW",(double) 150000000, 2023),

	ONIXTURBO("CHEVROLET",(double) 70000000, 2020),
	SANDERO("RENAULT",(double) 42500000, 2018), 
	
	F150("FORD",(double) 160000000, 2019),
	
	BERLINGO("CITRÖEN",(double) 60000000, 2016),
	
	TRANSPORTER("VOLKSWAGEN",(double) 67000000, 2015),
	
	PARADISO_1200_G7("MARCOPOLO",(double) 400000000, 2017),
	CITARO_K("MERCEDES-BENZ",(double) 530000000, 2020), 
	
	DMAX("CHEVROLET",(double) 53000000, 2012),
	FRONTIER_D22("NISSAN",(double) 40000000, 2009), 

	AUMARK_BJ_1039("FOTON",(double) 92000000, 2017),

	T800("KENWORTH",(double) 580000000, 2012);

	private final String marca;
	private final Double precio;
	private final Integer modelo;

	private EnumVehiculos(String marca, Double precio, Integer modelo) {
		this.marca = marca;
		this.precio = precio;
		this.modelo = modelo;
	}
}
