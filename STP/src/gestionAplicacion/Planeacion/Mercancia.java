package gestionAplicacion.Planeacion;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Destinos.*;
import gestionAplicacion.Vehiculos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Mercancia {
	private Usuario usuario;
	private Ruta ruta;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private VehiculoCarga vehiculo;
	private Conductor conductor;
	private Facturacion factura;
	private String fecha;

	public Mercancia(Usuario usuario, Ruta ruta, ArrayList<Producto> productos, VehiculoCarga vehiculo,
					 Conductor conductor, String fecha) {
		super();
		this.usuario = usuario;
		this.ruta = ruta;
		this.productos = productos;
		this.vehiculo = vehiculo;
		this.conductor = conductor;
		this.fecha = fecha;
	}
	public Mercancia() {
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
		usuario.agregarMercancia(this);
	}
}
