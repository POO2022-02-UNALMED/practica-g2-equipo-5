package gestionAplicacion.Personas;
import gestionAplicacion.Vehiculos.*;


public class Conductor extends Persona {
	private Vehiculo vehiculo;
	private int experiencia;
	
	
	//constructores
	public Conductor(String nombre, String documento, String direccion, String edad, Vehiculo vehiculo,
			int experiencia) {
		super(nombre, documento, direccion, edad);
		this.vehiculo = vehiculo;
		this.experiencia = experiencia;
	}
}
