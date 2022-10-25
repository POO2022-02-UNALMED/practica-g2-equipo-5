package gestionAplicacion.Planeacion;

import java.io.Serializable;
import java.util.ArrayList;

import gestionAplicacion.Personas.Conductor;
import gestionAplicacion.Personas.Usuario;
import gestionAplicacion.Vehiculos.VehiculoPasajeros;

public class Viaje implements Serializable{
	private static final long serialVersionUID = 1L;
	private Usuario uPrincipal; 
	private Ruta ruta;
	private int nPasajeros=0;
	private ArrayList<Usuario> pasajeros = new ArrayList<Usuario>();
	private ArrayList<Conductor> conductor = new ArrayList<Conductor>();
	private String fecha;
	private VehiculoPasajeros vehiculo;
	private boolean isBonificacion = false;
	
	
	public Viaje(Ruta ruta) {
		this.ruta = ruta;
	}
	
	public Viaje() {
		
	}

	//Getters and setters
	
	public boolean getIsBonificacion() {
		return isBonificacion;
	}
	public Usuario getuPrincipal() {
		return uPrincipal;
	}

	public void setuPrincipal(Usuario uPrincipal) {
		this.uPrincipal = uPrincipal;
	}

	public void setBonificacion(boolean isBonificacion) {
		this.isBonificacion = isBonificacion;
	}

	public void setIsBonificacion(boolean isBonificacion) {
		this.isBonificacion= isBonificacion;
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
