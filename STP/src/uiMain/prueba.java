package uiMain;

import gestionAplicacion.Destinos.Conexion;
import gestionAplicacion.Personas.Usuario;
import gestionAplicacion.Planeacion.Mercancia;
import gestionAplicacion.Planeacion.Producto;
import gestionAplicacion.Planeacion.Viaje;

import java.util.ArrayList;
import java.util.Scanner;

public class prueba {



	/* Funcionalidad Facturación */
	public static void generarFactura(Usuario usuario){
		Scanner in = new Scanner(System.in);
		System.out.println("1. Mercancia");
		System.out.println("1. Viaje");
		System.out.print("De la anterior lista, seleccine la opción de la cuál desea conocer su factura: ");
		int vEntrada = in.nextInt();

		switch (vEntrada){
			case 1:
				ArrayList<Mercancia> envios = usuario.getMercancia();
				int indMer = 1;
				for (Mercancia merc : envios){
					ArrayList<Conexion> ruta = merc.getRuta().getRuta();
					System.out.println(indMer + ". Origen: " + ruta.get(0) + ". Destino: " + ruta.get(-1));
					indMer++;
				}
				System.out.print("De la lista anterior, seleccione un envio: ");
				int selec = in.nextInt();
				Mercancia mercSeleccionada = envios.get(selec);

				if(selec % 5 == 0){
					usuario.mercBon(mercSeleccionada);
				}
				else{
					usuario.merc(mercSeleccionada);
				}
			case 2:
				ArrayList<Viaje> viajes = usuario.getViaje();
				int indV = 1;
				for(Viaje viaje : viajes){
					ArrayList<Conexion> ruta = viaje.getRuta().getRuta();
					System.out.println(indV + ". Origen: " + ruta.get(0) + ". Destino: " + ruta.get(-1));
					indV++;
				}
				System.out.print("De la lista anterior, seleccione un viaje: ");
				int selec2 = in.nextInt();
				Viaje vSeleccionado = viajes.get(selec2);

				if(selec % 5 == 0){
					usuario.viajBon(vSeleccionado);
				}
				else{
					usuario.viaje(vSeleccionado);
				}
		}

	}
	public void mercBon(Mercancia merc) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + this.getNombre());
		System.out.println("Documento: " + this.getDocumento());
		System.out.println("Lista de productos: ");
		for(Producto prod : merc.getProductos()) {
			System.out.println("- " + prod.getTipo() + ", " + prod.getPeso() + " kg.");
		}
		System.out.println("\n Ciudad de origen: " + merc.getRuta().getRuta().get(0));
		System.out.println("Ciudad de destino: " + merc.getRuta().getRuta().get(-1));
		System.out.println("Distancia: " + merc.getRuta().getDistancia());
		
		double precBon;
		System.out.println("Precio: " + merc.getRuta().getPrecio() + "COP");
		if(merc.getIsBonificacion() == false) {
			System.out.println("\nEn este envío cuentas con una bonificación del 30%");
			double precio = merc.getRuta().getPrecio();
			double des = (precio * 30)/100;
			precBon = precio - des;
		}
		else {
			System.out.println("\nEn este envío cuentas con una bonificación del 45%");
			double precio = merc.getRuta().getPrecio();
			double des = (precio * 45)/100;
			precBon = precio - des;
		}
		System.out.println("Precio con bonificación : " + precBon + "COP");
		
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
	
	public void merc(Mercancia merc) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + this.getNombre());
		System.out.println("Documento: " + this.getDocumento());
		System.out.println("Lista de productos: ");
		for(Producto prod : merc.getProductos()) {
			System.out.println("- " + prod.getTipo() + ", " + prod.getPeso() + " kg.");
		}
		System.out.println("\n Ciudad de origen: " + merc.getRuta().getRuta().get(0));
		System.out.println("Ciudad de destino: " + merc.getRuta().getRuta().get(-1));
		System.out.println("Distancia: " + merc.getRuta().getDistancia());
		System.out.println("Precio: " + merc.getRuta().getPrecio() + "COP");
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
	
	public void ViajBon(Viaje viaje) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + this.getNombre());
		System.out.println("Documento: " + this.getDocumento());
		System.out.println("Lista de acompañantes: ");
		for(Usuario prod : viaje.getPasajeros()) {
			System.out.println("- " + prod.getNombre() + ", " + prod.getEdad() + " años.");
		}
		System.out.println("\n Ciudad de origen: " + viaje.getRuta().getRuta().get(0));
		System.out.println("Ciudad de destino: " + viaje.getRuta().getRuta().get(-1));
		System.out.println("Distancia: " + viaje.getRuta().getDistancia());
		
		System.out.println("Precio: " + viaje.getRuta().getPrecio() + "COP");
		
		double precBon;
		System.out.println("Precio: " + viaje.getRuta().getPrecio() + "COP");
		if(viaje.getIsBonificacion() == false) {
			System.out.println("\nEn este viaje cuentas con una bonificación del 30%");
			double precio = viaje.getRuta().getPrecio();
			double des = (precio * 30)/100;
			precBon = precio - des;
		}
		else {
			System.out.println("\nEn este viaje cuentas con una bonificación del 45%");
			double precio = viaje.getRuta().getPrecio();
			double des = (precio * 45)/100;
			precBon = precio - des;
		}
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
	
	public void Viaj(Viaje viaje) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + this.getNombre());
		System.out.println("Documento: " + this.getDocumento());
		System.out.println("Lista de acompañantes: ");
		for(Usuario prod : viaje.getPasajeros()) {
			System.out.println("- " + prod.getNombre() + ", " + prod.getEdad() + " años.");
		}
		System.out.println("\n Ciudad de origen: " + viaje.getRuta().getRuta().get(0));
		System.out.println("Ciudad de destino: " + viaje.getRuta().getRuta().get(-1));
		System.out.println("Distancia: " + viaje.getRuta().getDistancia());
		System.out.println("Precio: " + viaje.getRuta().getPrecio() + "COP");
		
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
}
