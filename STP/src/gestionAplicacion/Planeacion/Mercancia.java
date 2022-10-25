package gestionAplicacion.Planeacion;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Destinos.*;
import gestionAplicacion.Vehiculos.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Mercancia implements Serializable{
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Ruta ruta;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private VehiculoCarga vehiculo;
	private Conductor conductor;
	private Facturacion factura;
	private String fecha;
	private boolean isBonificacion = false;
	
	
	
	public String toString() {
		return "Envio de: " + this.getUsuario();
	}
	public Mercancia(Ruta ruta) { 
		this.ruta = ruta;
	}
	public Mercancia() {
	}
	

	public boolean getIsBonificacion() {
		return isBonificacion;
	}
	public void setIsBonificacion(boolean isBonificacion) {
		this.isBonificacion= isBonificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public VehiculoCarga getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoCarga vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Facturacion getFactura() {
		return factura;
	}

	public void setFactura(Facturacion factura) {
		this.factura = factura;
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
