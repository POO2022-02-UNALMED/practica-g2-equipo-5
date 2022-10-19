package uiMain;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------------------------");
		System.out.println("  ____            _____           ____  \n"
				+ " / ___|          |_   _|         |  _ \\ \n"
				+ " \\___ \\   _____    | |    _____  | |_) |\n"
				+ "  ___) | |_____|   | |   |_____| |  __/ \n"
				+ " |____/            |_|           |_|    ");
		System.out.println("  SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.print("\n-> Ingrese su nombre: ");
		String nombre = scan.nextLine();
		
		int entrada;
		do {
			System.out.println("\n-------------------------------------------");
			System.out.println("-> BIENVENIDO " + nombre +" <- ");
			System.out.println("-> FUNCIONALIDADES <-");
			System.out.println("\n1. GENERAR RUTA");
			System.out.println("2. CREAR VIAJE");
			System.out.println("3. ENVIAR MERCANCIA");
			System.out.println("4. BONIFICACION");
			System.out.println("5. GENERAR FACTURA");
			System.out.println("6. SALIR");
			System.out.println("-------------------------------------------");
			System.out.print("\n-> Seleccione una opción: ");
			entrada = scan.nextInt();
			System.out.println("-------------------------------------------");
			
			switch(entrada) {
			case 1:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE CREAR RUTA");
				break;
			case 2:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE CREAR VIAJE");
				break;
			case 3:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE ENVIAR MERCANCIA");
				break;
			case 4:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE VER BONIFICACIONES");
				break;
			case 5:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE VER FACTURA");
				break;
			case 6:
				System.out.println("\nSALISTE DEL SISTEMA. MUCHAS GRACIAS POR USAR STP");
			}
				
		} while(entrada != 6);
	}
}
