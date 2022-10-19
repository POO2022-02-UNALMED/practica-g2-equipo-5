package gestionAplicacion.Personas;
import gestionAplicacion.Planeacion.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Persona {
	private ArrayList<Viaje> viaje;
	private ArrayList<Mercancia> mercancia;
	private ArrayList<Facturacion> facturacion;
	private ArrayList<Ruta> ruta;
	private static ArrayList<Usuario> user;
	
//Usuario hereda de persona
	
	
	public Usuario(String nombre, String documento, String edad, ArrayList<Viaje> viaje,
			ArrayList<Mercancia> mercancia, ArrayList<Facturacion> facturacion, ArrayList<Ruta>ruta) {
		super(nombre, documento, null, edad);
		this.viaje = viaje;
		this.mercancia = mercancia;
		this.facturacion = facturacion;
		this.ruta = ruta;
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

public void agregarViaje (Viaje viaje ) {
	this.viaje.add(viaje);
	
}
public void agregarMercancia(Mercancia mercancia){
	this.mercancia.add(mercancia);
	
}


public void agregarFacturacion(Facturacion facturacion) {
	this.facturacion.add(facturacion);
}





/********************************************************
 * **********funcionalidad Bonificacion*****************
 * *****************************************************/


/*Serializacion:
(class Usuario implements Serializable)

--Usuario.viaje
--Usuario.mercancia
--Usuario.facturacion
try{
	ObjectOutputStream guardaViajes = new ObjectOutputStream(new FileOutputStream("C:/Users/Desktop/proyectoPoo/viajePersona.txt"));
	guardaViajes.writeObject(Instancia_usuario. //Objeto que se serializa//);
	guardaViajes.close();
	
	ObjectInputStream recuperaViajes=new ObjectInputstream(New FileInputStream("C:/Users/Desktop/proyectoPoo/viajePersona.txt"))
	ArrayList<Viaje> viajesRecuperados = (ArrayList<Viaje>) recuperaViajes.readObject();
	viajesRecuperados.close();

	
	}catch(Exception e){
		if (viajesRecuperados.length<5){
		sout ("No hay bonificacion")
	}
	}
	int x = viajesRecuperados.length;
	int numeroBonificaciones=0;
	for (int i ==1; x<i, i++){
	if (x>=5){
		numeroBonificaciones+=1;
		x-=5;
	}
	}
	
	ArrayList<String> ciudadesBonificacion =  
	viajesRecuperados
	
*/

public Facturacion Bonificacion() {
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Usted ha seleccionado la opción Bonificaciones.\nA continuacion, por favor ingrese el nombre del usuario: ");
	int nombreUsuario = input.nextInt();
	//con la clave nombre de usuario, buscar en el hashMap
	//imprimir las opciones recorriendo el las ciudades en el hashmap
	
	int cantidadViajes = this.getViaje().length;
	int cantidadMercancia = this.getMercancia().length;

	if (cantidadViajes>=5) {
		System.out.println("");
		//inputDeUsuario = 
	}else if(cantidadMercancia>=5){
		System.out.println("");
	}
}








}
