package uiMain;

import gestionAplicacion.Personas.Usuario;
import gestionAplicacion.Planeacion.Mercancia;
import gestionAplicacion.Planeacion.Producto;
import gestionAplicacion.Planeacion.Viaje;

public class prueba {
	public void mercBon(Usuario user, Mercancia merc) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + user.getNombre());
		System.out.println("Documento: " + user.getDocumento());
		System.out.println("Lista de productos: ");
		for(Producto prod : merc.getProductos()) {
			System.out.println("- " + prod.getTipo() + ", " + prod.getPeso() + " kg.");
		}
		System.out.println("\n Ciudad de origen: " + merc.getRuta().getRuta().get(0));
		System.out.println("Ciudad de destino: " + merc.getRuta().getRuta().get(-1));
		System.out.println("Distancia: " + merc.getRuta().getDistancia());
		System.out.println("\nEn este envío cuentas con una bonificación del 30%");
		System.out.println("Precio: " + merc.getRuta().getPrecio() + "COP");
		
		double precio = merc.getRuta().getPrecio();
		double des = (precio * 30)/100;
		double precBon = precio - des;
		System.out.println("Precio con bonificación : " + precBon + "COP");
		
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
	
	public void merc(Usuario user, Mercancia merc) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + user.getNombre());
		System.out.println("Documento: " + user.getDocumento());
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
	
	public void ViajBon(Usuario user, Viaje viaje) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + user.getNombre());
		System.out.println("Documento: " + user.getDocumento());
		System.out.println("Lista de acompañantes: ");
		for(Usuario prod : viaje.getPasajeros()) {
			System.out.println("- " + prod.getNombre() + ", " + prod.getEdad() + " años.");
		}
		System.out.println("\n Ciudad de origen: " + viaje.getRuta().getRuta().get(0));
		System.out.println("Ciudad de destino: " + viaje.getRuta().getRuta().get(-1));
		System.out.println("Distancia: " + viaje.getRuta().getDistancia());
		System.out.println("\nEn este viaje cuentas con una bonificación del 30%");
		System.out.println("Precio: " + viaje.getRuta().getPrecio() + "COP");
		
		double precio = viaje.getRuta().getPrecio();
		double des = (precio * 30)/100;
		double precBon = precio - des;
		System.out.println("Precio con bonificación : " + precBon + "COP");
		
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
	
	public void Viaj(Usuario user, Viaje viaje) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + user.getNombre());
		System.out.println("Documento: " + user.getDocumento());
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
