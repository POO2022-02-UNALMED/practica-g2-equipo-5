package uiMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import gestionAplicacion.Destinos.Conexion;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Vehiculos.*;
import gestionAplicacion.Planeacion.*;
import baseDatos.Deserializador;
import baseDatos.Serializador;

public class Principal {
	
	/**
	 * 
	 * @author angel 
	 */
	
	
	/*funcionalidad generar ruta*/
	
	
	/**
	 * Método menuCiudades muestra las ciudades de operacion
	 * y hace el llamado de todos los métodos correspondientes para presentar un menú e interactuar con el usuario
	 */
	public static void menuGenerarRuta(Usuario usuario) {
		Scanner sc = new Scanner(System.in);
		String[] ciudades = {
				"MEDELLÍN","BOGOTÁ","BUCARAMANGA","SANTA MARTA",
				"BARRANQUILLA","CARTAGENA","QUIBDÓ","PEREIRA",
				"SAN JOSÉ DEL GUAVIARE","CALI"};
		int cont = 1;
		System.out.println("Las ciudades de operación son: ");
		for(String i:ciudades) {
			System.out.println(cont+". "+i);
			cont++;
		}
		
		System.out.print("\n-> Digite un número para elegir la ciudad origen: ");
		int origen = sc.nextInt();
		System.out.print("-> Digite un número para elegir la ciudad destino: ");
		int destino = sc.nextInt();
		Conexion[] c = Conexion.values();
		ArrayList<Conexion> b = new ArrayList<Conexion>();
		Collections.addAll(b, c);
		ArrayList<ArrayList<Conexion>> ru = usuario.rutas(ciudades[origen-1], ciudades[destino-1], b);
		System.out.println("----------------------Rutas disponibles----------------------");
		usuario.recorrerRutas(ru);
	}

	/* Funcionalidad Crear Viaje */
	public static void crearViaje(Usuario usuario) {

		Viaje viaje = new Viaje();

		ArrayList<Ruta> rutas = usuario.getRuta();
		int ultIndex = rutas.size();
		ultIndex--;
		Ruta ruta = rutas.get(ultIndex);

		Scanner scan = new Scanner(System.in);
		System.out.print("-> Ingrese numero de pasajeros: ");
		int nPasajeros = scan.nextInt();

		for (int i = 0; i < nPasajeros; i++) {
			String nombre;
			String edad;
			System.out.print("-> Ingrese nombre de acompañante: ");
			nombre = scan.next();
			System.out.print("-> Ingrese edad de la persona: ");
			edad = scan.next();
			Usuario pasajero = new Usuario(nombre, edad);
			viaje.agregarPasajeros(pasajero);
			viaje.aumentarNPasajeros();
		}

		Integer numConductores;
		if (ruta.getDistancia() >= 1000) {
			numConductores = 2;
		} else {
			numConductores = 1;
		}

		System.out.println("Ahora, se mostrarán los vehiculos que pueden transportar esta cantidad de pasajeros ");

		ArrayList<VehiculoPasajeros> vehiculosPosibles = VehiculoPasajeros.validarCapacidad(numConductores, nPasajeros);
		int indVehiculo = 0;
		for (VehiculoPasajeros vehiculo : vehiculosPosibles) {
			System.out.println(indVehiculo + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo());
			indVehiculo++;
		}
		System.out.print("-> De la lista anterior, seleccione un vehiculo: ");
		int vSeleccionado = scan.nextInt();
		VehiculoPasajeros vSel = vehiculosPosibles.get(vSeleccionado);
		viaje.setVehiculo(vSel);

		if (numConductores == 2) {
			System.out.println("Seleccione los conductores que desea de la siguiente lista: ");
			ArrayList<Conductor> conductores = Conductor.getConductores();
			int indC = 0;
			for (Conductor cond : conductores) {
				System.out.println(indC + ". " + cond.getNombre() + ", " + cond.getEdad() + "años. "
						+ cond.getExperiencia() + " años de experiencia");
				indC++;
			}

			System.out.print("-> Ingrese el número del primer conductor que seleccionó: ");
			int indConductor1 = scan.nextInt();
			Conductor condSeleccionado1 = conductores.get(indConductor1);
			condSeleccionado1.agregarVehiculo(vSel);
			viaje.agregarconductor(condSeleccionado1);

			System.out.print("-> Ingrese el número del segundo conductor que seleccionó: ");
			int indConductor2 = scan.nextInt();
			Conductor condSeleccionado2 = conductores.get(indConductor2);
			condSeleccionado2.agregarVehiculo(vSel);
			viaje.agregarconductor(condSeleccionado2);
		} else {
			System.out.println("Seleccione el conductores que desea de la siguiente lista: ");
			ArrayList<Conductor> conductores = Conductor.getConductores();
			int indC = 0;
			for (Conductor cond : conductores) {
				System.out.println(indC + ". " + cond.getNombre() + ", " + cond.getEdad() + "años. "
						+ cond.getExperiencia() + " años de experiencia");
				indC++;
			}

			System.out.println("-> Escoja conductor");
			int indConductor = scan.nextInt();
			Conductor condSeleccionado = conductores.get(indConductor);
			condSeleccionado.agregarVehiculo(vSel);
			viaje.agregarconductor(condSeleccionado);

			System.out.print("Por último, digite la fecha que desea realiza el viaje (dd/mm/aaaa): ");
			String fecha = scan.nextLine();
			viaje.setFecha(fecha);

			System.out.println("\nFelicidades, ha completado La creacion de su Viaje, que lo disfrute");
		}
		scan.close();
		usuario.agregarViaje(viaje);
	}

	/* Funcionalidad Enviar Mercancia */
	public static void enviarMercancia(Usuario user) {
		Mercancia mercancia = new Mercancia();

		mercancia.agregarUsuario(user);

		ArrayList<Ruta> rutas = user.getRuta();
		int ultIndex = rutas.size();
		ultIndex--;
		mercancia.setRuta(rutas.get(ultIndex));

		Scanner scan = new Scanner(System.in);

		int nProductos;
		System.out.print("-> Ingrese el número de productos a enviar: ");
		nProductos = scan.nextInt();

		int pTotal = 0;
		for (int i = 0; i < nProductos; i++) {

			System.out.print("-> Ingrese el producto a enviar: ");
			String tipo = scan.next();

			System.out.print("-> Ingrese el peso en kg: ");
			double peso = scan.nextDouble();
			pTotal += peso;

			mercancia.agregarProducto(new Producto(tipo, peso));
		}

		System.out.println("El peso total es de: " + pTotal + " kg");
		System.out.println("\nAhora, se mostrarán los vehiculos que pueden soportar ese peso");

		ArrayList<VehiculoCarga> vPosibles = VehiculoCarga.validarCapacidad(pTotal);
		int indV = 0;
		for (VehiculoCarga vehiculo : vPosibles) {
			System.out.println(indV + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo());
			indV++;
		}
		System.out.print("\n-> De la lista anterior, seleccione un vehiculo: ");
		int vSeleccionado = scan.nextInt();
		VehiculoCarga vSel = vPosibles.get(vSeleccionado);
		mercancia.setVehiculo(vSel);

		System.out.println();
		System.out.println("Seleccione el conductor que desea de la siguiente lista");
		ArrayList<Conductor> conductores = Conductor.getConductores();
		int indC = 0;
		for (Conductor cond : conductores) {
			System.out.println(indC + ". " + cond.getNombre() + ", " + cond.getEdad() + " años. "
					+ cond.getExperiencia() + " años de experiencia");
			indC++;
		}

		System.out.print("\n-> Ingrese el número del conductor que seleccionó: ");
		int indConductor = scan.nextInt();
		Conductor condSeleccionado = conductores.get(indConductor);
		condSeleccionado.agregarVehiculo(vSel);
		mercancia.setConductor(condSeleccionado);

		System.out.println();
		System.out.print("-> Por último, digite la fecha que desea realiza el envio (dd/mm/aaaa): ");
		String fecha = scan.next();
		mercancia.setFecha(fecha);

		System.out.println("\nFelicidades, ha completado con éxito su envio.");
		scan.close();
		user.agregarMercancia(mercancia);
	}

	private static void salirDelSistema(Usuario usuario) {
		System.out.println("Muchas gracias por usar STP, vuelva pronto");
		Serializador.serializador(usuario);
		System.exit(0);
	}

	public static void main(String[] args) {
		
		/* Conductores */
		Conductor C1 = new Conductor("Angel", "10011020", "38", 15, 40000);
		Conductor C2 = new Conductor("Ana", "1015215", "40", 20, 50000);
		Conductor C3 = new Conductor("Alejandro", "1520022", "51", 10, 30000);
		Conductor C4 = new Conductor("Andres", "152020", "30", 8, 15000);
		Conductor C5 = new Conductor("Juan", "1651561", "40", 10, 30000);

		/* Vehiculos Pasajeros */
		VehiculoPasajeros DOM = new VehiculoPasajeros("BAJAJ DOMINAR 400", 50000, 2021, "AUX-87X", 1);
		VehiculoPasajeros SR = new VehiculoPasajeros("BMW S1000RR", 150000, 2023, "AUX-88X", 1);
		VehiculoPasajeros ONIX = new VehiculoPasajeros("CHEVROLET ONIX", 200000, 2020, "AUX-89X", 4);
		VehiculoPasajeros SAN = new VehiculoPasajeros("RENAULT SANDERO", 170000, 2018, "AUX-90X", 4);
		VehiculoPasajeros FOR = new VehiculoPasajeros("FORD F150", 350000, 2019, "AUX-91X", 6);
		VehiculoPasajeros BER = new VehiculoPasajeros("CITRÖEN BERLINGO", 90000, 2016, "AUX-92X", 6);
		VehiculoPasajeros TRANS = new VehiculoPasajeros("VOLKSWAGEN TRANSPORTER", 130000, 2015, "AUX-93X", 6);
		VehiculoPasajeros PARADISO = new VehiculoPasajeros("MARCOPOLO PARADISO", 1500000, 2017, "AUX-94X", 45);
		VehiculoPasajeros CITARO = new VehiculoPasajeros("MERCEDES-BENZ CITARO-K", 1500000, 2020, "AUX-95X", 40);

		/* Vehiculos de carga */
		VehiculoCarga DOMI = new VehiculoCarga("BAJAJ DOMINAR 400", 12000, 2012, "AUX-96X", 20);
		VehiculoCarga DMAX = new VehiculoCarga("CHEVROLET DMAX", 15000, 2012, "AUX-97X", 1000);
		VehiculoCarga FRO = new VehiculoCarga("NISSAN FRONTIER D22", 15000, 2019, "AUX-98X", 1000);
		VehiculoCarga AUM = new VehiculoCarga("FOTON AUMARK BJ 1039", 25000, 2017, "AUX-99X", 4000);
		VehiculoCarga T = new VehiculoCarga("KENWORTH T800", 50000, 2012, "AUX-01X", 30000);

		/* Usuario */
		String ub = System.getProperty("user.dir") + "/src/baseDatos/temp/" + "Guzman.txt";
		
		Usuario Guz = Deserializador.deserializador(ub);
		Guz = (Guz.getNombre()==null)?new Usuario("Jaime Alberto Guzmán", "123456789", "20"):Guz;
		Guz.agregarMercancia(new Mercancia());
		Guz.agregarViaje(new Viaje());
		Guz.agregarFacturacion(new Facturacion());

		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------------------------");
		System.out.println("  ____            _____           ____  \n" + " / ___|          |_   _|         |  _ \\ \n"
				+ " \\___ \\   _____    | |    _____  | |_) |\n" + "  ___) | |_____|   | |   |_____| |  __/ \n"
				+ " |____/            |_|           |_|    ");
		System.out.println("  SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");

		System.out.println("\nLISTA DE USUARIOS");
		ArrayList<Usuario> usuarios = Usuario.getUser();
		int indU = 1;
		for (Usuario usuario : usuarios) {
			System.out.println(indU + ". " + usuario.getNombre() + ", CC " + usuario.getDocumento() + ", "
					+ usuario.getEdad() + " años de edad");
			indU++;
		}

		System.out.print("\n-> Seleccione un usuario de la lista anterior: ");
		int indEntrada = scan.nextInt();
		indEntrada--;
		Usuario pUsuario = usuarios.get(indEntrada);

		int entrada;
		do {
			System.out.println("\n-------------------------------------------");
			System.out.println("-> BIENVENIDO " + pUsuario.getNombre() + " <- ");
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

			switch (entrada) {
			case 1:
				
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE CREAR RUTA");
				menuGenerarRuta(Guz);
				break;
			case 2:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE CREAR VIAJE");
				crearViaje(pUsuario);
				break;
			case 3:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE ENVIAR MERCANCIA");
				enviarMercancia(pUsuario);
				break;
			case 4:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE VER BONIFICACIONES");
				break;
			case 5:
				System.out.println("\nSELECCIONÓ LA OPCIÓN DE VER FACTURA");
				break;
			case 6:
				salirDelSistema(pUsuario);
			}

		} while (entrada != 6);
	}
}
