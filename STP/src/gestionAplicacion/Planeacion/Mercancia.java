package gestionAplicacion.Planeacion;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Destinos.*;
import gestionAplicacion.Vehiculos.*;

import java.util.ArrayList;

public class Mercancia {
	private Usuario usuario;
	private Ruta ruta;
	private ArrayList<Producto> productos;
	private VehiculoCarga vehiculo;
	private Conductor conductor;
	private String fecha;

	public Mercancia(Usuario usuario, ArrayList<Conexion> ruta, ArrayList<Producto> productos, VehiculoCarga vehiculo,
					 Conductor conductor, String fecha) {
		super();
		this.usuario = usuario;
		this.ruta = ruta;
		this.productos = productos;
		this.vehiculo = vehiculo;
		this.conductor = conductor;
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Conexion> getRuta() {
		return ruta;
	}

	public void setRuta(ArrayList<Conexion> ruta) {
		this.ruta = ruta;
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

	public void agregarUsuario(Usuario usuario){
		this.usuario = usuario;
		usuario.agregarMercancia(this);
	}
	public agregarProductos(Producto producto){
		this.productos.add(producto);
	}
}
