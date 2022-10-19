package gestionAplicacion.Personas;

import gestionAplicacion.Destinos.Ciudad;
import gestionAplicacion.Planeacion.*;
import gestionAplicacion.Vehiculos.VehiculoCarga;
import gestionAplicacion.Vehiculos.VehiculoPasajeros;
import gestionAplicacion.Destinos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Persona {
	private ArrayList<Viaje> viaje = new ArrayList<Viaje>();
	private ArrayList<Mercancia> mercancia = new ArrayList<Mercancia>();
	private ArrayList<Facturacion> facturacion = new ArrayList<Facturacion>();
	private ArrayList<Ruta> ruta = new ArrayList<Ruta>();
	private static ArrayList<Usuario> user = new ArrayList<Usuario>();

//Usuario hereda de persona

	public Usuario(String nombre, String documento, String edad, ArrayList<Viaje> viaje, ArrayList<Mercancia> mercancia,
			ArrayList<Facturacion> facturacion, ArrayList<Ruta> ruta) {
		super(nombre, documento, null, edad);
		this.viaje = viaje;
		this.mercancia = mercancia;
		this.facturacion = facturacion;
		this.ruta = ruta;
		Usuario.user.add(this);
	}

	public Usuario(String nombre, String edad) {
		super(nombre, null, null, edad);
	}

	public Usuario(String nombre, String documento, String edad) {
		super(nombre, documento, null, edad);
		Usuario.user.add(this);
	}
//Getters and setters

	public ArrayList<Viaje> getViaje() {
		return viaje;
	}

	public void setViaje(ArrayList<Viaje> viaje) {
		this.viaje = viaje;
	}

	public ArrayList<Mercancia> getMercancia() {
		return mercancia;
	}

	public void setMercancia(ArrayList<Mercancia> mercancia) {
		this.mercancia = mercancia;
	}

	public ArrayList<Facturacion> getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(ArrayList<Facturacion> facturacion) {
		this.facturacion = facturacion;
	}

	public ArrayList<Ruta> getRuta() {
		return ruta;
	}

	public void setRuta(ArrayList<Ruta> ruta) {
		this.ruta = ruta;
	}

	public static ArrayList<Usuario> getUser() {
		return user;
	}

	public static void setUser(ArrayList<Usuario> user) {
		Usuario.user = user;
	}

//Methods

	public void agregarViaje(Viaje viaje) {
		this.viaje.add(viaje);

	}

	public void agregarMercancia(Mercancia mercancia) {
		this.mercancia.add(mercancia);

	}

	public void agregarFacturacion(Facturacion facturacion) {
		this.facturacion.add(facturacion);
	}

	public void agregarRuta(Ruta ruta) {
		this.ruta.add(ruta);
	}

	/* Funcionalidad Enviar Mercancia*/
	
	public Mercancia enviarMercancia() {
		Mercancia mercancia = new Mercancia();

		mercancia.agregarUsuario(this);

		/*
		 * ArrayList<Ruta> rutas = this.getRuta(); int ultIndex = rutas.size();
		 * ultIndex--; mercancia.setRuta(rutas.get(ultIndex));
		 */

		Scanner scan = new Scanner(System.in);

		int nProductos;
		System.out.print("-> Ingrese el número de productos a enviar ");
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
		return mercancia;
	}

	// Funcionalidad Crear Viaje
	
	public Viaje crearViaje() {
		Viaje viaje = new Viaje();
		//falta lo de la ruta 
		Scanner scan = new Scanner(System.in);
		System.out.print("-> Ingrese numero de pasajeros: ");
		int nPasajeros= scan.nextInt();

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
		return viaje;
	}
	
	/********************************************************
	 * **********funcionalidad Bonificacion*****************
	 *****************************************************/

	/*
	 * Serializacion: (class Usuario implements Serializable)
	 * 
	 * --Usuario.viaje --Usuario.mercancia --Usuario.facturacion try{
	 * ObjectOutputStream guardaViajes = new ObjectOutputStream(new
	 * FileOutputStream("C:/Users/Desktop/proyectoPoo/viajePersona.txt"));
	 * guardaViajes.writeObject(Instancia_usuario. //Objeto que se serializa//);
	 * guardaViajes.close();
	 * 
	 * ObjectInputStream recuperaViajes=new ObjectInputstream(New
	 * FileInputStream("C:/Users/Desktop/proyectoPoo/viajePersona.txt"))
	 * ArrayList<Viaje> viajesRecuperados = (ArrayList<Viaje>)
	 * recuperaViajes.readObject(); viajesRecuperados.close();
	 * 
	 * 
	 * }catch(Exception e){ if (viajesRecuperados.length<5){ sout
	 * ("No hay bonificacion") } } int x = viajesRecuperados.length; int
	 * numeroBonificaciones=0; for (int i ==1; x<i, i++){ if (x>=5){
	 * numeroBonificaciones+=1; x-=5; } }
	 * 
	 * ArrayList<String> ciudadesBonificacion = viajesRecuperados
	 * 
	 */

	public void Bonificacion() {
		Scanner input = new Scanner(System.in);
		//Facturacion bonificacion;
		
		int cantidadViajes = this.getViaje().size();
		int cantidadMercancia = this.getMercancia().size();

		System.out.println("Usted ha seleccionado la opción Bonificaciones, la cual consta de lo siguiente: "
				+ "\nCada que el usuario realice 5 viajes o 5 envios de mercancia, tendra la opcion de obtener un descuento "
				+ "del 30% en su siguiente viaje o un descuento en el precio del conductor para su siguiente envio de mercancia."
				+ "\nEn este momento, el usuario ");
		if (cantidadViajes%5==0 || cantidadMercancia%5==0) {
			System.out.println("puede obtener la bonificacion.");
		}else {
			System.out.println("no puede obtener la bonificacion debido a que hasta el momento cuenta con "+cantidadViajes+" viajes, y "+cantidadMercancia+" envios de mercancia.");
		}
		
		if (cantidadViajes%5==0 || cantidadMercancia%5==0) {
			System.out.println("\n\nDesea aplicar el descuento para un nuevo viaje o un envio de mercancia."
					+ "\n1. Nuevo viaje."
					+ "\n2. Envio de mercancia.");
			int opcionBonificacion = input.nextInt();
			
			System.out.println("Ha seleccionado la opcion: " + opcionBonificacion +"");
			
			if (opcionBonificacion == 1) { // OPCION VIAJE
				System.out.println("\nA continuacion por favor cree el nuevo viaje con reduccion del 30% en el precio");
				Viaje viajeBonificado = crearViaje();
				generarFacturacion(viajeBonificado);
				
				
			
			} else if (opcionBonificacion == 2) { //OPCION BONIFICACION
				System.out.println("\nA continuacion por favor genere el envio de mercancia con reduccion del 30% en el costo del vehiculo");
				Mercancia mercanciaBonificado = enviarMercancia();
				generarFacturacion(mercanciaBonificado);
			}
			
		}
	}
	
	/**************FUNCIONALIDAD FACTURACION*****************/
	
	
	//Todavia está malo unu 
	public Facturacion generarFacturacion(Viaje viaje) {
		
		
		/////////////////////////////////////////////////
		//////FACTURA PARA BONIFICACION DE VIAJE (HOLI ANA):
		///////////////////////////////////////////////////
		if (viaje.esBonificacion()) {
			
		}
			
			
		//////////////////////////////////////////////////
		Viaje instViaje = new Viaje();
		Facturacion insFacturacion = new Facturacion();
		
		String nom = this.getNombre();
		String doc = this.getDocumento();
		String fech = instViaje.getFecha();
		Ciudad ori = instViaje.getcOrigen();
		Ciudad dest = instViaje.getcDestino();
		double pre = insFacturacion.getPrecio();
		
		System.out.println("-----------------------------------------------\n"
				+ "-------------FACTURA DE VENTA VIAJE-------------\n"
				+ "------------------------------------------------\n");
		System.out.println("Nombre: "+nom);
		System.out.println("Documento: "+doc);
		System.out.println("Fecha: "+fech);
		System.out.println("Origen: "+ori);
		System.out.println("Destino: "+dest);
		System.out.println("------------------------------------------------");
		System.out.println("TOTAL A PAGAR: "+pre);
		System.out.println("------------------------------------------------\n"
				+ "              Los atendió %($)/#($              \n"
				+ "------------------------------------------------\n"
				+ "************************************************\n"
				+ "             GRACIAS POR PREFERIRNOS            \n"
				+ "************************************************\n");
		
		
		
		
		}
	
	public Facturacion generarFacturacion(Mercancia mercancia) {
		
		/////////////////////////////////////////////////
		//////FACTURA PARA BONIFICACION DE MERCANCIA (HOLI ANA):
		///////////////////////////////////////////////////
		if (mercancia.esBonificacion()) {
			
		}else {};


		//////////////////////////////////////////////////
		
		
		Viaje inViaje = new Viaje();
		Facturacion inFact = new Facturacion();
		
		
		String no = this.getNombre();
		String Do = this.getDocumento();
		Ciudad or = inViaje.getcOrigen();
		Ciudad de = inViaje.getcDestino();
		ArrayList <Producto> pro = inFact.getProducto();
		
		
		System.out.println("-------------------------------------------------\n"
				+ "-----------FACTURA DE VENTA MERCANCIA------------\n"
				+ "-------------------------------------------------\n");
		System.out.println("Nombre: "+no);
		System.out.println("Documento: "+Do);
		System.out.println("Origen: "+or);
		System.out.println("Destino: "+de);
		System.out.println("Productos: ");
		System.out.println("k");
		System.out.println("-------------------------------------------------");
		System.out.println("TOTAL A PAGAR: ");
		System.out.println("-------------------------------------------------\n"
				+ "            Los atendió $(#(/=(=(=()/            \n"
				+ "-------------------------------------------------\n"
				+ "*************************************************\n"
				+ "              GRACIAS POR PREFERIRNOS            \n"
				+ "*************************************************\n");
		
	}
	
	//metodos generar rutas
	public String formato(double x) {
		double num = x/60;
		double min = x%60;
		double horas = num - num%1;
		
		
		String s = String.format(
				"%d horas y %d minutos",
				Math.round(horas),Math.round(min));
		return s;
		
	}
	public void menuCiudades() {
		String[] ciudades = {
				"MEDELLÍN","BOGOTÁ","BUCARAMANGA","SANTA MARTA",
				"BARRANQUILLA","CARTAGENA","QUIBDÓ","PEREIRA",
				"SAN JOSÉ DEL GUAVIARE","CALI"};
		int cont = 1;
		System.out.println("Las ciudades de operación son: ");
		for(String i:ciudades) {
			System.out.println(cont+i);
			cont++;
		}
		
		
		
	}
	public  ArrayList<ArrayList<Conexion>> rutas(String a,String b,ArrayList<Conexion> todas){
		ArrayList<ArrayList<Conexion>> res = new ArrayList<ArrayList<Conexion>>();
		ArrayList<Conexion> ruta  = new ArrayList<Conexion>();
		ArrayList<Conexion> aux  = new ArrayList<Conexion>();
		todas.stream().filter(
				x->x.ciudadA==a
				)
				.forEach(
						item->
							aux.add(item)
				);
		
		for(Conexion i:aux) {
			ArrayList<Conexion> cop  = (ArrayList<Conexion>)ruta.clone();
			cop.add(i);
			rutas(i.ciudadB,b,cop,res,todas);
		}
		return res;
	}
	
	
	
	
	void rutas(String act,String b, ArrayList<Conexion> ruta,ArrayList<ArrayList<Conexion>> res,ArrayList<Conexion> todas){
		if(act==b) {
			res.add(ruta);
		}
		else {
			ArrayList<Conexion> aux  = new ArrayList<Conexion>();
			todas.stream().filter(
					x->x.ciudadA==act
					)
					.forEach(
							item->
								aux.add(item)
					);
			
			for(Conexion i:aux) {
				ArrayList<Conexion> cop  = (ArrayList<Conexion>)ruta.clone();
				if(!cop.contains(i)) {
					cop.add(i);
					rutas(i.ciudadB,b,cop,res,todas);
				}
				
			}
		}
		
	}
	
	public double suma(String c,ArrayList<Conexion> ruta) {
		double suma = 0;
		switch (c){
	        case "d":{
	        	suma = ruta.stream()
	        		      .mapToDouble(i->i.distancia)
	        		      .sum();
	            break;
	        }
	
	        case "t":{
	        	suma = ruta.stream()
	        		      .mapToDouble(i->i.tiempo)
	        		      .sum();
	            break;
	        }
	        case "p":{
	        	suma = ruta.stream()
	        		      .mapToDouble(i->i.precio)
	        		      .sum();
	            break;
	        }
		}
		return suma;
	}
	
	public String ciudadesRuta(ArrayList<Conexion> ruta){
		String res = "";
		res+=ruta.get(0).ciudadA;
		for(Conexion i:ruta) {
			res+="-"+i.ciudadB;
		}
		return res;
		
	}
	
	public void pintar(int r,ArrayList<Conexion> ruta) {
		
		String s = String.format(
				"%d. Las ciudades a recorrer son:\n%s\n"
				+ "Detalles del recorrido:\n"
				+ "Precio: $%d\n"
				+ "Distancia: %d km\n"
				+ "Tiempo: %s\n"
				+ "----------------\n\n",
				r,
				ciudadesRuta(ruta),
				Math.round(suma("p",ruta)),
				Math.round(suma("d",ruta)),
				formato(suma("t",ruta))
				);
		System.out.println(s);
	}
	
	public void recorrerRutas(ArrayList<ArrayList<Conexion>> rutas) {
		int en = 1;
		for(ArrayList<Conexion> i:rutas) {
			pintar(en,i);
			en++;
		}
		
	}

	
	
	
}