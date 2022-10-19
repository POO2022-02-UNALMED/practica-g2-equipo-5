package gestionAplicacion.Planeacion;

import gestionAplicacion.Destinos.*;
import gestionAplicacion.Personas.*;

import java.util.ArrayList;

public class Viaje {
	private Ciudad cDestino;
	private Ciudad cOrigen;
	private ArrayList<Conexion> ruta = new ArrayList<Conexion> ();
	private int nPasajeros=0;
	private ArrayList<Usuario> pasajeros = new ArrayList<Usuario>();
	private ArrayList<Conductor> conductor = new ArrayList<Conductor>();
	private String fecha;
	
//Getters and setters
	public Ciudad getcDestino() {
		return cDestino;
	}

	public void setcDestino(Ciudad cDestino) {
		this.cDestino = cDestino;
	}

	public Ciudad getcOrigen() {
		return cOrigen;
	}

	public void setcOrigen(Ciudad cOrigen) {
		this.cOrigen = cOrigen;
	}

	public ArrayList<Conexion> getRuta() {
		return ruta;
	}

	public void setRuta(ArrayList<Conexion> ruta) {
		this.ruta = ruta;
	}

	public int getnPasajeros() {
		return nPasajeros;
	}

	public void setnPasajeros(int nPasajeros) {
		this.nPasajeros = nPasajeros;
	}

	public ArrayList<Usuario> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Usuario> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public ArrayList<Conductor> getConductor() {
		return conductor;
	}

	public void setConductor(ArrayList<Conductor> conductor) {
		this.conductor = conductor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
//methods
	public crearViaje() {
		
	}

	
}
