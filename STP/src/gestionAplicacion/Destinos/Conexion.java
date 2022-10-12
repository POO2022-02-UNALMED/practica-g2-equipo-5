package gestionAplicacion.Destinos;

public class Conexion {
	private Ciudad ciudadA;
	private Ciudad ciudadB;
	private double distancia;
	private Integer tiempo;
	private double precio;
	
	public Conexion(Ciudad ciudadA, Ciudad ciudadB, double distancia, Integer tiempo, double precio) {
		this.ciudadA = ciudadA;
		this.ciudadB = ciudadB;
		this.distancia = distancia;
		this.tiempo = tiempo;
		this.precio = precio;
	}

	public Ciudad getCiudadA() {
		return ciudadA;
	}

	public void setCiudadA(Ciudad ciudadA) {
		this.ciudadA = ciudadA;
	}

	public Ciudad getCiudadB() {
		return ciudadB;
	}

	public void setCiudadB(Ciudad ciudadB) {
		this.ciudadB = ciudadB;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
