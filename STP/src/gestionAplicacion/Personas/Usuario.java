package gestionAplicacion.Personas;


import gestionAplicacion.Planeacion.*;
import gestionAplicacion.Vehiculos.VehiculoCarga;
import gestionAplicacion.Vehiculos.VehiculoPasajeros;

import gestionAplicacion.Destinos.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Usuario extends Persona{
	
	private ArrayList<Viaje> viaje = new ArrayList<Viaje>();
	private ArrayList<Mercancia> mercancia = new ArrayList<Mercancia>();
	private ArrayList<Facturacion> facturacion = new ArrayList<Facturacion>();
	private Ruta ruta;
	private static ArrayList<Usuario> user = new ArrayList<Usuario>();
	private String errorS = null;

//Usuario hereda de persona

	public Usuario(String nombre, String documento, String edad, ArrayList<Viaje> viaje, ArrayList<Mercancia> mercancia,
			ArrayList<Facturacion> facturacion, Ruta ruta) {
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
	
	public Usuario(String e) {
		this.errorS = e;
	}
	public String presentacion() {
		return this.nombre + ". CC " + this.documento + ". " + this.edad + " años de edad";
	}
	
//Getters and setters
	public String getErrorS() {
		return this.errorS;
	}
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

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
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
		viaje.setuPrincipal(this);

	}

	public void agregarMercancia(Mercancia mercancia) {
		this.mercancia.add(mercancia);
		mercancia.setUsuario(this);

	}

	public void agregarFacturacion(Facturacion facturacion) {
		this.facturacion.add(facturacion);
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
		
		Conexion rutaGenerada = merc.getRuta().getRuta().get(0);
		double precio = rutaGenerada.precio;
		precio += merc.getVehiculo().getPrecio();
		precio += merc.getConductor().getPrecio();
		System.out.println("\nCiudad de origen: " + rutaGenerada.ciudadA);
		System.out.println("Ciudad de destino: " + rutaGenerada.ciudadB);
		System.out.println("Distancia: " + rutaGenerada.distancia + " km");
		System.out.println("Precio: " + precio + "COP");
		
		double precBon;
		if(merc.getIsBonificacion() == false) {
			System.out.println("\nEn este envío cuentas con una bonificación del 30%");
			double des = (precio * 30)/100;
			precBon = precio - des;
		}
		else {
			System.out.println("\nEn este envío cuentas con una bonificación del 45%");
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
		Conexion rutaGenerada = merc.getRuta().getRuta().get(0);
		double precio = rutaGenerada.precio;
		precio += merc.getVehiculo().getPrecio();
		precio += merc.getConductor().getPrecio();
		System.out.println("\nCiudad de origen: " + rutaGenerada.ciudadA);
		System.out.println("Ciudad de destino: " + rutaGenerada.ciudadB);
		System.out.println("Distancia: " + rutaGenerada.distancia + " km");
		System.out.println("Precio: " + precio + "COP");
		
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
	
	public void viajBon(Viaje viaje) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + this.getNombre());
		System.out.println("Documento: " + this.getDocumento());
		System.out.println("Lista de acompañantes: ");
		for(Usuario prod : viaje.getPasajeros()) {
			System.out.println("- " + prod.getNombre() + ", " + prod.getEdad() + " años.");
		}
		Conexion rutaGenerada = viaje.getRuta().getRuta().get(0);
		double precio = rutaGenerada.precio;
		precio += viaje.getVehiculo().getPrecio();
		double precioConductores = 0;
		for (Conductor cond : viaje.getConductor()) {
			precioConductores += cond.getPrecio();
		}
		precio += precioConductores;
		
		System.out.println("\nCiudad de origen: " + rutaGenerada.ciudadA);
		System.out.println("Ciudad de destino: " + rutaGenerada.ciudadB);
		System.out.println("Distancia: " + rutaGenerada.distancia + " km");
		System.out.println("Precio: " + precio + "COP");
		
		double precBon;
		System.out.println("Precio: " + viaje.getRuta().getPrecio() + "COP");
		if(viaje.getIsBonificacion() == false) {
			System.out.println("\nEn este viaje cuentas con una bonificación del 30%");
			double des = (precio * 30)/100;
			precBon = precio - des;
		}
		else {
			System.out.println("\nEn este viaje cuentas con una bonificación del 45%");
			double des = (precio * 45)/100;
			precBon = precio - des;
		}
		System.out.println("-------------------------------------------");
		System.out.println("Gracias por confiar en nostros. STP.");
		System.out.println("-------------------------------------------");
	}
	
	public void viaj(Viaje viaje) {
		System.out.println("-------------------------------------------");
		System.out.println("SISTEMA DE TRANSPORTE PERSONALIZADO");
		System.out.println("-------------------------------------------");
		System.out.println("Nombre :" + this.getNombre());
		System.out.println("Documento: " + this.getDocumento());
		System.out.println("Lista de acompañantes: ");
		for(Usuario prod : viaje.getPasajeros()) {
			System.out.println("- " + prod.getNombre() + ", " + prod.getEdad() + " años.");
		}
		Conexion rutaGenerada = viaje.getRuta().getRuta().get(0);
		double precio = rutaGenerada.precio;
		precio += viaje.getVehiculo().getPrecio();
		double precioConductores = 0;
		for (Conductor cond : viaje.getConductor()) {
			precioConductores += cond.getPrecio();
		}
		precio += precioConductores;
		System.out.println("\nCiudad de origen: " + rutaGenerada.ciudadA);
		System.out.println("Ciudad de destino: " + rutaGenerada.ciudadB);
		System.out.println("Distancia: " + rutaGenerada.distancia + " km");
		System.out.println("Precio: " + precio + "COP");
		
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
	public ArrayList<ArrayList<Conexion>> validarRutas(ArrayList<ArrayList<Conexion>> rutas){
		rutas.sort((l1,l2) -> l1.size()-l2.size());
		ArrayList<ArrayList<Conexion>> l2 = 
				(rutas.get(0).size() > 1)
				?new ArrayList<ArrayList<Conexion>>(rutas.subList(0, 3))
				:new ArrayList<ArrayList<Conexion>>(rutas.subList(0, 1));
		return l2;
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
		res = validarRutas(res);
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
		
		System.out.print("-> Ingrese el número de la ruta a tomar: ");
		int numRuta = sc.nextInt();
		numRuta--;
		
		ArrayList<Conexion> ruta = rutas.get(numRuta);
		double precio = Math.round(suma("p",ruta));
		double distancia = Math.round(suma("d",ruta));
		String tiempo = formato(suma("t",ruta));
		Ruta rutaUsuario = new Ruta(ruta,precio,distancia,tiempo);
		this.ruta = rutaUsuario;
		
	}	
	
}