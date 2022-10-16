package gestionAplicacion.Personas;
import java.util.ArrayList;

import gestionAplicacion.Vehiculos.*;


public class Conductor extends Persona {
	private Vehiculo vehiculo;
	private int experiencia;
	public static ArrayList<Conductor> conductores;
	
	//constructores
	public Conductor(String nombre, String documento, String direccion, String edad, Vehiculo vehiculo,
			int experiencia) {
		super(nombre, documento, direccion, edad);
		this.vehiculo = vehiculo;
		this.experiencia = experiencia;
	}
	public Conductor(String nombre, String documento,  String edad, 
			int experiencia) {
		super(nombre, documento, null, edad);
		this.experiencia = experiencia;
		Conductor.conductores.add(this);
	}

	//getters and setters
	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public int getExperiencia() {
		return experiencia;
	}


	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	//metodos 
	public void agregarVehiculo(Vehiculo v) {
		this.vehiculo = v;
		v.setConductor(this);
	}
	
}
