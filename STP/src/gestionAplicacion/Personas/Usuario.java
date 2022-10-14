package gestionAplicacion.Personas;
import gestionAplicacion.Planeacion.Mercancia;
import gestionAplicacion.Planeacion.Facturacion;

import java.util.ArrayList;

public class Usuario extends Persona {
	private ArrayList<Viaje> viaje;
	private ArrayList<Mercancia> mercancia;
	private ArrayList<Facturacion> facturacion;
	
//Usuario hereda de persona
public Usuario(String nombre, String documento, String direccion, String edad) {
	super();
	this.nombre=nombre;
	this.documento=documento;
	this.direccion=direccion;
	this.edad=edad;
}

//Getters and setters
public ArrayList<Viaje> getViaje() {
	return viaje;
}

public void setViaje(ArrayList<Viaje> viaje) {
	this.viaje = viaje;
}

public ArrayList<Mercancia> getMercancia() {
	return mercancia;
}

public void setMercancia(ArrayList<Mercancia> mercancia) {
	this.mercancia = mercancia;
}

public ArrayList<Facturacion> getFacturacion() {
	return facturacion;
}

public void setFacturacion(ArrayList<Facturacion> facturacion) {
	this.facturacion = facturacion;
}

//Methods









}
