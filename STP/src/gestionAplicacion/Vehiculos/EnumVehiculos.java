package gestionAplicacion.Vehiculos;

public enum EnumVehiculos {
	DOMINAR400("BAJAJ", (double) 50000, 2021, "AUX-87X"), 
	S1000RR("BMW", (double) 150000, 2023, "AUX-88X"),

	ONIXTURBO("CHEVROLET", (double) 200000, 2020, "AUX-89X"), 
	SANDERO("RENAULT", (double) 170000, 2018, "AUX-90X"),

	F150("FORD", (double) 350000, 2019, "AUX-91X"),

	BERLINGO("CITRÖEN", (double) 90000, 2016, "AUX-92X"),

	TRANSPORTER("VOLKSWAGEN", (double) 130000, 2015, "AUX-93X"),

	PARADISO_1200_G7("MARCOPOLO", (double) 1500000, 2017, "AUX-94X"),
	CITARO_K("MERCEDES-BENZ", (double) 1500000, 2020, "AUX-95X"),

	DMAX("CHEVROLET", (double) 120000, 2012, "AUX-96X"), 
	FRONTIER_D22("NISSAN", (double) 100000, 2009, "AUX-97X"),

	AUMARK_BJ_1039("FOTON", (double) 250000, 2017, "AUX-98X"),

	T800("KENWORTH", (double) 2000000, 2012, "AUX-99X");

	private final String marca;
	private final double precio;
	private final int modelo;
	private final String placa;

	private EnumVehiculos(String marca, double precio, int modelo, String placa) {
		this.marca = marca;
		this.precio = precio;
		this.modelo = modelo;
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public double getPrecio() {
		return precio;
	}

	public int getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

}
