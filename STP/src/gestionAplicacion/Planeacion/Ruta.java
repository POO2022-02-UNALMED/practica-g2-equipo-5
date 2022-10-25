package gestionAplicacion.Planeacion;
import gestionAplicacion.Destinos.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Ruta implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Conexion> ruta = new ArrayList<Conexion>();
	private double precio;
	private double distancia;
	private String tiempo;
	
	//constructores
	public Ruta(ArrayList<Conexion> ruta, double precio, double distancia, String tiempo) {
		super();
		this.ruta = ruta;
		this.precio = precio;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}
	
	public Ruta() {
		super();
	}
	//getters and setters
	public ArrayList<Conexion> getRuta() {
		return ruta;
	}
	
	public void setRuta(ArrayList<Conexion> ruta) {
		this.ruta = ruta;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	//metodos 

}
