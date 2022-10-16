package gestionAplicacion.Planeacion;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Destinos.*;
import gestionAplicacion.Vehiculos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Mercancia {
	private Usuario usuario;
	private Ruta ruta;
	private ArrayList<Producto> productos;
	private VehiculoCarga vehiculo;
	private Conductor conductor;
	private Facturacion factura;
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

	/* Funcionalidad */
	public Mercancia enviarMercancia(Ruta ruta){
		Mercancia mercancia = new Mercancia();
		
		mercancia.setRuta(ruta);
		ArrayList<Ciudad> listCiudades = ruta.listCiudades();
		
		Scanner scan = new Scanner(System.in);

		int nProductos;
		System.out.print("Ingrese el número de productos a enviar ");
		nProductos = scan.nextInt();
		
		double pTotal = 0;
		for(int i = 0; i < nProductos; i++) {
			Producto P1 = new Producto();
			
			System.out.print("Ingrese el tipo de producto: ");
			String tipo = scan.nextLine();
			P1.setTipo(tipo);
			
			System.out.print("Ingrese el peso: ");
			double peso = scan.nextDouble();
			pTotal += peso;
			P1.setPeso(peso);
			
			System.out.println("Ahora de la siguiente lista seleccione la ciudad de destino");
			int ind = 0;
			for(Ciudad ciudad: listCiudades) {
				System.out.println(ind+". "+ ciudad.getNombre()+", "+ciudad.getDepartamento());
				ind++;
			}
			System.out.print("Seleccione el número de la ciudad: ");
			int nCiudad = scan.nextInt();
			
			P1.setcDestino(listCiudades.get(nCiudad));
			
			mercancia.agregarProducto(P1);
		}
		
		System.out.println("El peso total es de: " + pTotal);
		System.out.println("Ahora, se mostrarán los vehiculos que pueden soportar ese peso");
		
		
		

	}
}
