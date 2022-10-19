package gestionAplicacion.Personas;
import gestionAplicacion.Planeacion.Mercancia;
import gestionAplicacion.Planeacion.Facturacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Persona {
	private ArrayList<Viaje> viaje;
	private ArrayList<Mercancia> mercancia;
	private ArrayList<Facturacion> facturacion;
	
//Usuario hereda de persona
public Usuario(String nombre, String documento, String direccion, String edad) {
	super();
	this.nombre=nombre;
	this.documento=documento;
	this.direccion=direccion;
	this.edad=edad;
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

//Methods
public void agregarMercancia(Mercancia mercancia){
	this.mercancia.add(mercancia);
	mercancia.setUsuario(this);
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
