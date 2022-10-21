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

	/* Funcionalidad */
	public Mercancia enviarMercancia(){
		Mercancia mercancia = new Mercancia();
		
		mercancia.agregarUsuario(this);
		
		ArrayList<Ruta> rutas = this.getRuta();
		mercancia.setRuta(rutas.get(-1));
		
		Scanner scan = new Scanner(System.in);

		int nProductos;
		System.out.print("-> Ingrese el número de productos a enviar ");
		nProductos = scan.nextInt();
		
		int pTotal = 0;
		for(int i = 0; i < nProductos; i++) {
			Producto P1 = new Producto();
			
			System.out.print("-> Ingrese el tipo de producto: ");
			String tipo = scan.nextLine();
			P1.setTipo(tipo);
			
			System.out.print("-> Ingrese el peso: ");
			double peso = scan.nextDouble();
			pTotal += peso;
			P1.setPeso(peso);
			
			mercancia.agregarProducto(P1);
		}
		
		System.out.println("El peso total es de: " + pTotal);
		System.out.println("Ahora, se mostrarán los vehiculos que pueden soportar ese peso");
		
		ArrayList<VehiculoCarga> vPosibles = VehiculoCarga.validarCapacidad(pTotal);
		int indV = 0;
		for(VehiculoCarga vehiculo: vPosibles) {
			System.out.println(indV + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo());
			indV++;
		}
		System.out.print("-> De la lista anterior, seleccione un vehiculo: ");
		int vSeleccionado = scan.nextInt();
		VehiculoCarga vSel = vPosibles.get(vSeleccionado);
		mercancia.setVehiculo(vSel);
		
		
		System.out.println();
		System.out.println("Seleccione el conductor que desea de la siguiente lista");
		ArrayList<Conductor> conductores = Conductor.getConductores();
		int indC = 0;
		for(Conductor cond: conductores) {
			System.out.println(indC + ". " + cond.getNombre() + ", " + cond.getEdad() +"años. "
					+ cond.getExperiencia() + " años de experiencia");
			indC++;
		}
		
		System.out.print("-> Ingrese el número del conductor que seleccionó: ");
		int indConductor = scan.nextInt();
		Conductor condSeleccionado = conductores.get(indConductor); 
		condSeleccionado.agregarVehiculo(vSel);
		mercancia.setConductor(condSeleccionado);
		
		System.out.println();
		System.out.print("-> Por último, digite la fecha que desea realiza el envio (dd/mm/aaaa): ");
		String fecha = scan.nextLine();
		mercancia.setFecha(fecha);
		
		System.out.println("\nFelicidades, ha completado con éxito su envio.");
		scan.close();
		return mercancia;
	}
}
