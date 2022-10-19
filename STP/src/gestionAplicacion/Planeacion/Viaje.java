package gestionAplicacion.Planeacion;

import java.util.ArrayList;
import java.util.Scanner;

import gestionAplicacion.Destinos.Ciudad;
import gestionAplicacion.Personas.Conductor;
import gestionAplicacion.Personas.Usuario;
import gestionAplicacion.Vehiculos.VehiculoPasajeros;

public class Viaje {
	private Ciudad cDestino;
	private Ciudad cOrigen;
	private Ruta ruta;
	private int nPasajeros = 0;
	private ArrayList<Usuario> pasajeros;
	private ArrayList<Conductor> conductor;
	private VehiculoPasajeros vehiculo;
	private String fecha;

//Getters and setters
	public Ciudad getcDestino() {
		return cDestino;
	}

	public void setcDestino(Ciudad cDestino) {
		this.cDestino = cDestino;
	}

	public Ciudad getcOrigen() {
		return cOrigen;
	}

	public void setcOrigen(Ciudad cOrigen) {
		this.cOrigen = cOrigen;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public int getnPasajeros() {
		return nPasajeros;
	}

	public void setnPasajeros(int nPasajeros) {
		this.nPasajeros = nPasajeros;
	}

	public ArrayList<Usuario> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Usuario> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public ArrayList<Conductor> getConductor() {
		return conductor;
	}

	public void setConductor(ArrayList<Conductor> conductor) {
		this.conductor = conductor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public VehiculoPasajeros getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoPasajeros vehiculo) {
		this.vehiculo = vehiculo;
	}

//methods
	public Viaje crearViaje() {
		Viaje viaje = new Viaje();
		//falta lo de la ruta 
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese numero de pasajeros");
		nPasajeros = scan.nextInt();

		for (int i = 0; i < nPasajeros; i++) {
			String nombre;
			String documento;
			String direccion;
			String edad;
			System.out.println("Ingrese nombre de acompañante");
			nombre = scan.next();
			System.out.println("Ingrese documento de la persona");
			documento = scan.next();
			System.out.println("Ingrese direccion de la persona");
			direccion = scan.next();
			System.out.println("Ingrese edad de la persona");
			edad = scan.next();
			Usuario pasajero = new Usuario(nombre, documento, direccion, edad, null, null, null);
			pasajeros.add(pasajero);

		}
		
		Integer numConductores;
		if (viaje.ruta.getDistancia() >= 250) {
			numConductores = 2;
		} else {
			numConductores = 1;
		}
		
		System.out.println("Ahora, se mostrarán los vehiculos que pueden transportar esta cantidad de pasajeros");

		ArrayList<VehiculoPasajeros> vehiculosPosibles = VehiculoPasajeros.validarCapacidad(numConductores, nPasajeros);
		int indVehiculo = 0;
		for (VehiculoPasajeros vehiculo : vehiculosPosibles) {
			System.out.println(indVehiculo + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo());
			indVehiculo++;
		}
		System.out.print("De la lista anterior, seleccione un vehiculo: ");
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

			System.out.print("Ingrese el número del primer conductor que seleccionó: ");
			int indConductor1 = scan.nextInt();
			Conductor condSeleccionado1 = conductores.get(indConductor1);
			condSeleccionado1.agregarVehiculo(vSel);
			viaje.conductor.add(condSeleccionado1);
			
			System.out.print("Ingrese el número del segundo conductor que seleccionó: ");
			int indConductor2 = scan.nextInt();
			Conductor condSeleccionado2 = conductores.get(indConductor2);
			condSeleccionado2.agregarVehiculo(vSel);
			viaje.conductor.add(condSeleccionado2);
		} else {
			System.out.println("Seleccione los conductores que desea de la siguiente lista: ");
			ArrayList<Conductor> conductores = Conductor.getConductores();
			int indC = 0;
			for (Conductor cond : conductores) {
				System.out.println(indC + ". " + cond.getNombre() + ", " + cond.getEdad() + "años. "
						+ cond.getExperiencia() + " años de experiencia");
				indC++;
			}
			
			System.out.println("Escoja conductor");
			int indConductor = scan.nextInt();
			Conductor condSeleccionado = conductores.get(indConductor);
			condSeleccionado.agregarVehiculo(vSel);
			viaje.conductor.add(condSeleccionado);
			
			System.out.print("Por último, digite la fecha que desea realiza el envio (dd/mm/aaaa): ");
			String fecha = scan.nextLine();
			viaje.setFecha(fecha);
			
			System.out.println("\nFelicidades, ha completado La creacion de su Viaje, que lo disfrute");
		}

		return viaje;
	}

}
