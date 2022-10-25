package uiMain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;

import gestionAplicacion.Destinos.Conexion;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Vehiculos.*;
import gestionAplicacion.Planeacion.*;
import baseDatos.Deserializador;
import baseDatos.Serializador;

public class Principal {

	/* Funcionalidad Facturación */
	public static void generarFactura(Usuario usuario) {
		Scanner in = new Scanner(System.in);
		System.out.println("1. Mercancia");
		System.out.println("2. Viaje");
		System.out.print("-> De la anterior lista, seleccine la opción de la cuál desea conocer su factura: ");
		int vEntrada = in.nextInt();

		switch (vEntrada) {
		case 1:
			ArrayList<Mercancia> envios = usuario.getMercancia();
			int indMer = 1;
			System.out.println();
			for (Mercancia merc : envios) {
				ArrayList<Conexion> ruta = merc.getRuta().getRuta();
				int tRuta = ruta.size();
				tRuta--;
				System.out.println(indMer + ". Origen: " + ruta.get(0).ciudadA + ". Destino: " + ruta.get(tRuta).ciudadB);
				indMer++;
			}
			System.out.print("\n-> De la lista anterior, seleccione un envio: ");
			int selec = in.nextInt();
			selec--;
			Mercancia mercSeleccionada = envios.get(selec);
			selec++;
			if (selec % 5 == 0) {
				usuario.mercBon(mercSeleccionada);
			} else {
				usuario.merc(mercSeleccionada);
			}
			break;
		case 2:
			ArrayList<Viaje> viajes = usuario.getViaje();
			int indV = 1;
			System.out.println();
			for (Viaje viaje : viajes) {
				ArrayList<Conexion> ruta = viaje.getRuta().getRuta();
				int tRuta = ruta.size();
				tRuta--;
				System.out.println(indV + ". Origen: " + ruta.get(0).ciudadA + ". Destino: " + ruta.get(tRuta).ciudadB);
				indV++;
			}
			System.out.print("\n-> De la lista anterior, seleccione un viaje: ");
			int selec2 = in.nextInt();
			selec2--;
			Viaje vSeleccionado = viajes.get(selec2);
			selec2++;
			if (selec2 % 5 == 0) {
				usuario.viajBon(vSeleccionado);
			} else {
				usuario.viaj(vSeleccionado);
			}
			break;
		}

	}

	/* Funcionalidad Generar Ruta */

	public static void menuGenerarRuta(Usuario usuario) {
		Scanner sc = new Scanner(System.in);
		String[] ciudades = { "MEDELLÍN", "BOGOTÁ", "BUCARAMANGA", "SANTA MARTA", "BARRANQUILLA", "CARTAGENA", "QUIBDÓ",
				"PEREIRA", "SAN JOSÉ DEL GUAVIARE", "CALI" };
		int cont = 1;
		System.out.println("Las ciudades de operación son: ");
		System.out.println();
		for (String i : ciudades) {
			System.out.println(cont + ". " + i);
			cont++;
		}

		System.out.print("\n-> Digite un número para elegir la ciudad origen: ");
		int origen = sc.nextInt();
		System.out.print("-> Digite un número para elegir la ciudad destino: ");
		int destino = sc.nextInt();
		Conexion[] c = Conexion.values();
		ArrayList<Conexion> b = new ArrayList<Conexion>();
		Collections.addAll(b, c);
		ArrayList<ArrayList<Conexion>> ru = usuario.rutas(ciudades[origen - 1], ciudades[destino - 1], b);
		System.out.println("----------------------Rutas disponibles----------------------");
		usuario.recorrerRutas(ru);
	}

	/* Funcionalidad Crear Viaje */
	public static void crearViaje(Usuario usuario) {

		Viaje viaje = new Viaje();

		Ruta ruta = usuario.getRuta();
		viaje.setRuta(ruta);

		Scanner scan = new Scanner(System.in);
		System.out.print("-> Ingrese numero de acompañantes: ");
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

		System.out.println("\nAhora, se mostrarán los vehiculos que pueden transportar esta cantidad de pasajeros ");
		
		nPasajeros++;
		ArrayList<VehiculoPasajeros> vehiculosPosibles = VehiculoPasajeros.validarCapacidad(numConductores, nPasajeros);
		System.out.println();
		int indVehiculo = 1;
		for (VehiculoPasajeros vehiculo : vehiculosPosibles) {
			System.out.println(indVehiculo + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo());
			indVehiculo++;
		}
		System.out.print("\n-> De la lista anterior, seleccione un vehiculo: ");
		int vSeleccionado = scan.nextInt();
		vSeleccionado--;
		VehiculoPasajeros vSel = vehiculosPosibles.get(vSeleccionado);
		viaje.setVehiculo(vSel);

		if (numConductores == 2) {
			System.out.println("\nSeleccione los conductores que desea de la siguiente lista: ");
			ArrayList<Conductor> conductores = Conductor.getConductores();
			System.out.println();
			int indC = 1;
			for (Conductor cond : conductores) {
				System.out.println(indC + ". " + cond.presentacion());
				indC++;
			}

			System.out.print("\n-> Ingrese el número del primer conductor que seleccionó: ");
			int indConductor1 = scan.nextInt();
			indConductor1--;
			Conductor condSeleccionado1 = conductores.get(indConductor1);
			condSeleccionado1.agregarVehiculo(vSel);
			viaje.agregarconductor(condSeleccionado1);

			System.out.print("\n-> Ingrese el número del segundo conductor que seleccionó: ");
			int indConductor2 = scan.nextInt();
			indConductor2--;
			Conductor condSeleccionado2 = conductores.get(indConductor2);
			condSeleccionado2.agregarVehiculo(vSel);
			viaje.agregarconductor(condSeleccionado2);
		} else {
			System.out.println("\nSeleccione el conductores que desea de la siguiente lista: ");
			ArrayList<Conductor> conductores = Conductor.getConductores();
			System.out.println();
			int indC = 1;
			for (Conductor cond : conductores) {
				System.out.println(indC + ". " + cond.getNombre() + ", " + cond.getEdad() + " años. "
						+ cond.getExperiencia() + " años de experiencia");
				indC++;
			}

			System.out.println("\n -> Escoja el conductor");
			int indConductor = scan.nextInt();
			indConductor--;
			Conductor condSeleccionado = conductores.get(indConductor);
			condSeleccionado.agregarVehiculo(vSel);
			viaje.agregarconductor(condSeleccionado);
		}
		
		System.out.print("Por último, digite la fecha que desea realiza el viaje (yyyy-MM-dd): ");
		
		String fecha = scan.next();
		viaje.setFecha(fecha);

		System.out.println("\nFelicidades, ha completado La creacion de su Viaje, que lo disfrute");

		usuario.agregarViaje(viaje);
	}

	/* Funcionalidad Enviar Mercancia */
	public static void enviarMercancia(Usuario user) {
		Mercancia mercancia = new Mercancia();

		mercancia.agregarUsuario(user);

		Ruta ruta = user.getRuta();
		mercancia.setRuta(ruta);

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
		int indV = 1;
		for (VehiculoCarga vehiculo : vPosibles) {
			System.out.println(indV + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo());
			indV++;
		}
		System.out.print("\n-> De la lista anterior, seleccione un vehiculo: ");
		int vSeleccionado = scan.nextInt();
		vSeleccionado--;
		VehiculoCarga vSel = vPosibles.get(vSeleccionado);
		mercancia.setVehiculo(vSel);

		System.out.println();
		System.out.println("Seleccione el conductor que desea de la siguiente lista");
		ArrayList<Conductor> conductores = Conductor.getConductores();
		int indC = 1;
		for (Conductor cond : conductores) {
			System.out.println(indC + ". " + cond.presentacion());
			indC++;
		}

		System.out.print("\n-> Ingrese el número del conductor que seleccionó: ");
		int indConductor = scan.nextInt();
		indConductor--;
		Conductor condSeleccionado = conductores.get(indConductor);
		condSeleccionado.agregarVehiculo(vSel);
		mercancia.setConductor(condSeleccionado);

		System.out.println();
		System.out.print("-> Por último, digite la fecha que desea realizar el envio (yyyy-MM-dd): ");
		String fecha = scan.next();
		mercancia.setFecha(fecha);

		System.out.println("\nFelicidades, ha completado con éxito su envio.");
		user.agregarMercancia(mercancia);
	}

	/* Funcionalidad Bonificación */
	public static void Bonificacion(Usuario usuario) throws ParseException {
		Scanner input = new Scanner(System.in);

		int cantidadViajes = usuario.getViaje().size();
		int cantidadMercancia = usuario.getMercancia().size();

		cantidadViajes++;
		cantidadMercancia++;

		System.out.println("-> BONIFICACION <-" + "\nCada 4 viajes, obtiene un 5to viaje con 30% de descuento"
				+ "\nCada 4 envíos de mercancia, en el 5to obtiene 30% de descuento");

		System.out.print("\nServicios:" + "\n1. Viaje" + "\n2. Mercancia");
		System.out.print("\n-> Para que servicio desea obtener la bonificación: ");
		int iServicio = input.nextInt();

		if (iServicio == 1) {
			if (cantidadViajes % 5 != 0) {
				System.out.println(" \n-> NO PUEDE OBTENER LA BONIFICACION <-");
				System.out.println("Ahora sólo cuenta con " + usuario.getViaje().size() + " viajes");
			} else {
				System.out.println("\nA continuacion por favor cree el nuevo viaje con reduccion del 30% en el precio");
				menuGenerarRuta(usuario);
				crearViaje(usuario);

				ArrayList<Viaje> viajes = usuario.getViaje();
				int tamañoViajes = viajes.size();
				tamañoViajes--;

				Viaje viaje = viajes.get(tamañoViajes);

				String fecha = viaje.getFecha();
				
				TimeZone timezone = TimeZone.getDefault();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date fEnvio = null;
				try{
					fEnvio = format.parse(fecha);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(fEnvio);
				int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
				
				String Valor_dia = null;

				if (diaSemana == 1) {
					Valor_dia = "Domingo";
				} else if (diaSemana == 2) {
					Valor_dia = "Lunes";
				} else if (diaSemana == 3) {
					Valor_dia = "Martes";
				} else if (diaSemana == 4) {
					Valor_dia = "Miercoles";
				} else if (diaSemana == 5) {
					Valor_dia = "Jueves";
				} else if (diaSemana == 6) {
					Valor_dia = "Viernes";
				} else if (diaSemana == 7) {
					Valor_dia = "Sabado";
				}
				String dia = Valor_dia;

				if (dia == "Martes") {
					System.out
							.println("\nAdicionalmente, por ser día martes se le reducirá un 10% del precio del viaje");
					viaje.setIsBonificacion(true);
				}

			}
		} else {
			if (cantidadMercancia % 5 != 0) {
				System.out.println(" -> NO PUEDE OBTENER LA BONIFICACION <-");
				System.out.println("Ahora sólo cuenta con " + usuario.getMercancia().size() + " envíos");
			} else {
				System.out.println("\nA continuacion por favor realize el nuevo envío con reduccion del 30% en el precio");
				menuGenerarRuta(usuario);
				enviarMercancia(usuario);

				ArrayList<Mercancia> mercancias = usuario.getMercancia();
				int tamañoM = mercancias.size();
				tamañoM--;

				Mercancia mercancia = mercancias.get(tamañoM);

				String fecha = mercancia.getFecha();
				
				TimeZone timezone = TimeZone.getDefault();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date fEnvio = null;
				try{
					fEnvio = format.parse(fecha);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(fEnvio);
				int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
				
				String Valor_dia = null;
				if (diaSemana == 1) {
					Valor_dia = "Domingo";
				} else if (diaSemana == 2) {
					Valor_dia = "Lunes";
				} else if (diaSemana == 3) {
					Valor_dia = "Martes";
				} else if (diaSemana == 4) {
					Valor_dia = "Miercoles";
				} else if (diaSemana == 5) {
					Valor_dia = "Jueves";
				} else if (diaSemana == 6) {
					Valor_dia = "Viernes";
				} else if (diaSemana == 7) {
					Valor_dia = "Sabado";
				}
				String dia = Valor_dia;

				if (dia == "Martes") {
					System.out
							.println("\nAdicionalmente, por ser día martes se le reducirá un 10% del precio del viaje");
					mercancia.setIsBonificacion(true);
				}

			}
		}
	}

	private static void salirDelSistema(Usuario usuario) {
		System.out.println("Muchas gracias por usar STP, vuelva pronto");
		Serializador.serializador(usuario);
		System.exit(0);
	}

	public static void main(String[] args) throws ParseException{

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
		String ub = System.getProperty("user.dir") + "/STP/src/baseDatos/temp/" + "Guzman.txt";

		Usuario Guz = Deserializador.deserializador(ub);
		Guz = (Guz.getErrorS() == "error") ? new Usuario("Jaime Alberto Guzmán", "123456789", "20") : Guz;

		ArrayList<Conexion> ruta1 = new ArrayList<Conexion>();
		ruta1.add(Conexion.A);
		Ruta ruta = new Ruta(ruta1, 115000, 150, "4 horas");

		Guz.agregarMercancia(new Mercancia(ruta));
		Guz.agregarMercancia(new Mercancia(ruta));
		Guz.agregarMercancia(new Mercancia(ruta));
		Guz.agregarMercancia(new Mercancia(ruta));
		Guz.agregarViaje(new Viaje(ruta));
		Guz.agregarViaje(new Viaje(ruta));
		Guz.agregarViaje(new Viaje(ruta));

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
			System.out.println(indU + ". " + usuario.presentacion());
			indU++;
		}

		System.out.print("\n-> Seleccione un usuario de la lista anterior: ");
		int indEntrada = scan.nextInt();
		indEntrada--;
		Usuario pUsuario = usuarios.get(indEntrada);
		
		System.out.println("\n-> BIENVENIDO <- "
				+ "\n" + pUsuario.getNombre() );
		int entrada;
		do {
			System.out.println("\n-------------------------------------------");
			System.out.println("-> Funcionalidades <-");
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
				menuGenerarRuta(pUsuario);
				break;
			case 2:
				crearViaje(pUsuario);
				break;
			case 3:
				enviarMercancia(pUsuario);
				break;
			case 4:
				Bonificacion(pUsuario);
				break;
			case 5:
				generarFactura(pUsuario);
				break;
			case 6:
				salirDelSistema(pUsuario);
			}

		} while (entrada != 6);
	}
}
