package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;

import java.util.ArrayList;

import gestionAplicacion.Destinos.*;


public class Vehiculo {
	private Conductor conductor;
	private ArrayList<Conexion> ruta;
	private String placa;
	private String modelo;
	
	//constructores
	public Vehiculo(Conductor conductor, ArrayList<Conexion> ruta, String placa, String modelo) {
		super();
		this.conductor = conductor;
		this.ruta = ruta;
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public Vehiculo(String placa,String modelo) {
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
	public ArrayList<Conexion> getRuta() {
		return ruta;
	}
	public void setRuta(ArrayList<Conexion> ruta) {
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
