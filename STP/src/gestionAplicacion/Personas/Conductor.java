package gestionAplicacion.Personas;
import java.util.ArrayList;

import gestionAplicacion.Vehiculos.*;


public class Conductor extends Persona {
	private Vehiculo vehiculo;
	private int experiencia;
	private double precio;
	public static ArrayList<Conductor> conductores = new ArrayList<Conductor>();
	
	//constructores
	public Conductor(String nombre, String documento, String direccion, String edad, Vehiculo vehiculo,
			int experiencia) {
		super(nombre, documento, direccion, edad);
		this.vehiculo = vehiculo;
		this.experiencia = experiencia;
	}
	public Conductor(String nombre, String documento,  String edad, 
			int experiencia,double precio) {
		super(nombre, documento, null, edad);
		this.experiencia = experiencia;
		this.precio = precio;
		Conductor.conductores.add(this);
	}

	public String presentacion() {
		return "Nombre: " + this.nombre + ". Edad: " + this.edad + " años. Experiencia: " + this.experiencia + " años"; 
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
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	//metodos 
	public void agregarVehiculo(Vehiculo v) {
		this.vehiculo = v;
		v.setConductor(this);
	}
	
	public static ArrayList<Conductor> getConductores(){
		return Conductor.conductores;
	}
}
