package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Destinos.*;


public class Vehiculo {
	private Conductor conductor;
	private Conexion[] ruta;
	private String placa;
	private String modelo;
	
	//constructor
	public Vehiculo(Conductor conductor, Conexion[] ruta, String placa, String modelo) {
		super();
		this.conductor = conductor;
		this.ruta = ruta;
		this.placa = placa;
		this.modelo = modelo;
	}
	
	//getters and setters 
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public Conexion[] getRuta() {
		return ruta;
	}
	public void setRuta(Conexion[] ruta) {
		this.ruta = ruta;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
}
