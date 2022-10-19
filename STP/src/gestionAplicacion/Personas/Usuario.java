package gestionAplicacion.Personas;

import gestionAplicacion.Planeacion.*;
import gestionAplicacion.Vehiculos.VehiculoCarga;

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

	
/**************************************************
 **************FUNCIONALIDAD FATURACION************
 **************************************************/
	
public Facturacion generarFacturaViaje() {
	
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

		// FORMA 2 DE BONIFICAR: CANTIDAD VIAJES Y MERCANCIA SALEN DE LOS DATOS TRAIDOS
		// DE LA SERIALIZACION, por implementar
		int cantidadViajes = this.getViaje().size();
		int cantidadMercancia = this.getMercancia().size();
		// Facturacion factura;

		System.out.println("Usted ha seleccionado la opción Bonificaciones. "
				+ "\nPor favor seleccione si desea aplicar su bonificacion a: " + "\n\n1. Viaje" + "\n2. Mercancia");
		int opcionBonificacion = input.nextInt();

		System.out.println("Ha seleccionado la opcion: " + opcionBonificacion);
		// OPCION VIAJE
		if (opcionBonificacion == 1) {
			////// FORMA 2 DE BONIFICAR: Si se repite 3 o mas veces un viaje en el valor
			////// serializado
			// FORMA 1: si tiene mas de 5 viajes, se le regala el 30% para repetir el viaje
			if (cantidadViajes >= 5) {
				Viaje viaje = new Viaje();
				////////// viaje.crearViaje();???????

				System.out.println("El usuario cuenta con la siguiente bonificacion:"
						+ "\nEl usuario puede repetir su ultimo viaje, en direccion: " + viaje.getcOrigen() + "-"
						+ viaje.getcDestino() + "\npara el cual se le otorgara un descueto del 30%."
						+ "\nSi desea comprar el viaje con el descuendo aplicado, por favor escriba (1); de lo contrario, escriba (2)");
				int tomaBonificacion = input.nextInt();
				if (tomaBonificacion == 1) {

					// Facturacion facturacion2 = new Facturacion(null, null, 0, 0, 0, 0);
					// facturacion2.generarFacturacion(viaje);
				} else if (tomaBonificacion == 2) {
					System.out.println("Gracias por confiar en STP. Vuelva pronto!");
					break;
				}

				// OPCION MERCANCIA
			} else if (opcionBonificacion == 2) {
				if (cantidadMercancia >= 5) {

					Mercancia mercancia = new Mercancia();

					System.out.println("El usuario cuenta con la siguiente bonificacion:"
							+ "\nEl usuario puede enviar 2 productos de manera gratuita.  "// enviarMercancia con
																							// productos -2
							+ "\nSi desea enviar los productos con el descuendo aplicado, por favor escriba (1); de lo contrario, escriba (2)");
					int tomaBonificacion = input.nextInt();
					if (tomaBonificacion == 1) {
						mercancia.enviarMercancia(); // -2 productos

					} else if (tomaBonificacion == 2) {
						System.out.println("Gracias por confiar en STP. Vuelva pronto!");
						break;
					}
				}

				// con la clave nombre de usuario, buscar en el hashMap
				// imprimir las opciones recorriendo el las ciudades en el hashmap

				// return factura;
			}
		}
	}
}