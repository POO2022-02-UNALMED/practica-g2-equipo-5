package gestionAplicacion.Planeacion;

import java.util.ArrayList;

import gestionAplicacion.Destinos.Ciudad;
import gestionAplicacion.Personas.Conductor;
import gestionAplicacion.Personas.Usuario;
import gestionAplicacion.Vehiculos.VehiculoPasajeros;

public class Viaje {
	private Ciudad cDestino;
	private Ciudad cOrigen;
	private Ruta ruta;
	private int nPasajeros=0;
	private ArrayList<Usuario> pasajeros = new ArrayList<Usuario>();
	private ArrayList<Conductor> conductor = new ArrayList<Conductor>();
	private String fecha;
	private VehiculoPasajeros vehiculo;
	

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

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public int getnPasajeros() {
		return nPasajeros;
	}

	public void setnPasajeros(int nPasajeros) {
		this.nPasajeros = nPasajeros;
	}
	
	public void aumentarNPasajeros() {
		nPasajeros++;
	}
	
	public ArrayList<Usuario> getPasajeros() {
		return pasajeros;
	}
	public void agregarPasajeros(Usuario pasajero) {
		this.pasajeros.add(pasajero);
	}
	public void setPasajeros(ArrayList<Usuario> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public ArrayList<Conductor> getConductor() {
		return conductor;
	}
	
	public void agregarconductor(Conductor conductor) {
		this.conductor.add(conductor);
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
	
	public VehiculoPasajeros getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(VehiculoPasajeros vehiculo) {
		this.vehiculo = vehiculo;
	}
}
