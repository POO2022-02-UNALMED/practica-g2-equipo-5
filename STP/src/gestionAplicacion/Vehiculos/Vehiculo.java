package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;

import java.util.ArrayList;

import gestionAplicacion.Destinos.*;


public class Vehiculo {
	private Conductor conductor;
	private ArrayList<Conexion> ruta = new ArrayList<Conexion>();
	private String placa;
	private int modelo;
	private String marca;
	private double precio;
	
	//constructores
	public Vehiculo(Conductor conductor, ArrayList<Conexion> ruta, String placa, int modelo) {
		super();
		this.conductor = conductor;
		this.ruta = ruta;
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public Vehiculo(String marca,double precio,int modelo,String placa) {
		this.marca = marca;
		this.precio = precio;
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
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
