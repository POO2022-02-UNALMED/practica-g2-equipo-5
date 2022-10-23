package gestionAplicacion.Personas;

import gestionAplicacion.Destinos.Ciudad;

import gestionAplicacion.Planeacion.*;
import gestionAplicacion.Vehiculos.VehiculoCarga;
import gestionAplicacion.Vehiculos.VehiculoPasajeros;

import gestionAplicacion.Destinos.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Usuario extends Persona  implements Serializable{
	
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
	public Usuario() {
		super();
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

	// Funcionalidad Crear Viaje
	
	
	
	/* Funcionalidad Bonificación */
	
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
	
	//metodos generar rutas
	/**
	 * 
	 * @param x. Minutos en formato double.
	 * @return Devuelve un string en formato horas:minutos.
	 */
	public String formato(double x) {
		double num = x/60;
		double min = x%60;
		double horas = num - num%1;
		
		
		String s = String.format(
				"%d horas y %d minutos",
				Math.round(horas),Math.round(min));
		return s;
		
	}
	
	/**
	 * Método menuCiudades muestra las ciudades de operacion
	 * y hace el llamado de todos los métodos correspondientes para presentar un menú e interactuar con el usuario
	 */
	public void menuCiudades() {
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
		ArrayList<ArrayList<Conexion>> ru = rutas(ciudades[origen-1], ciudades[destino-1], b);
		System.out.println("----------------------Rutas disponibles----------------------");
		recorrerRutas(ru);
	}
	
	/**
	 * Metodo rutas obtiene todas las rutas posibles dentro de las conexiones establecidas.
	 * @param a. Ciudad origen.
	 * @param b. Ciudad destino.
	 * @param todas. Lista de todas las conexiones que se tienen
	 * @return Devuelve las rutas posibles dado una ciudad origen y una ciudad destino.
	 */
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
	
	
	/**
	 * Método rutas es recursivo y se utiliza para actualizar las rutas. 
	 * @param act. Es la conexion o nodo para el cual se quieren obtener conexiones.
	 * @param b. Ciudad destino.
	 * @param ruta. Es la ruta que actual.
	 * @param res. Lista de rutas
	 * @param todas. Lista de todas las conexiones.
	 */
	
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
	
	/**
	 * 
	 * Método suma recorre una lista de conexiones
	 * dependiendo del parametro c obtiene los totales para distancia, tiempo y precio.
	 * @param c. Indica si se quiere obtener precio,tiempo o distancia
	 * @param ruta. Es una lista con las conexiones pretenecientes a la ruta.
	 * @return devuelve la suma correspondiente, dependiendo del parámetro c elegido.
	 */
	
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
	
	/**
	 * 
	 * @param ruta. Lista de conexiones.
	 * @return develve un string que contiene todas las ciudades en el orden en que se van a recorrer.
	 */
	public String ciudadesRuta(ArrayList<Conexion> ruta){
		String res = "";
		res+=ruta.get(0).ciudadA;
		for(Conexion i:ruta) {
			res+="-"+i.ciudadB;
		}
		return res;
		
	}
	
	/**
	 * Método pintar muestra el detalle de una ruta.
	 * @param r. Enumerador para mostrar una ruta en pantalla.
	 * @param ruta. Lista de conexiones correspondientes a la ruta para la cual se muestran todos sus detalles en pantalla.
	 */
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
	
	/**
	 * Método recorrerRutas pinta en pantalla todas las rutas posibles para que el usuario elija una.
	 * @param rutas. Lista de todas las rutas posibles.
	 */
	public void recorrerRutas(ArrayList<ArrayList<Conexion>> rutas) {
		Scanner sc = new Scanner(System.in);
		int en = 1;
		for(ArrayList<Conexion> i:rutas) {
			pintar(en,i);
			en++;
		}
		
		System.out.println("Ingrese el número de la ruta a tomar");
		int numRuta = sc.nextInt();
		numRuta--;
		
		ArrayList<Conexion> ruta = rutas.get(numRuta);
		double precio = Math.round(suma("p",ruta));
		double distancia = Math.round(suma("d",ruta));
		String tiempo = formato(suma("t",ruta));
		Ruta rutaUsuario = new Ruta(ruta,precio,distancia,tiempo);
		
	}	
	
}