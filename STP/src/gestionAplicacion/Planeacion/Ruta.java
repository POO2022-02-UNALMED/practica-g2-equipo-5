package gestionAplicacion.Planeacion;
import gestionAplicacion.Destinos.*;
import java.util.ArrayList;

public class Ruta {
	private ArrayList<Conexion> ruta = new ArrayList<Conexion>();
	private double precio;
	private double distancia;
	private int tiempo;
	
	//getters and setters
	public ArrayList<Conexion> getRuta() {
		return ruta;
	}
	public void setRuta(ArrayList<Conexion> ruta) {
		this.ruta = ruta;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	//metodos 
	public ArrayList<Ciudad> listCiudades(){
		ArrayList<Ciudad> l = new ArrayList<Ciudad>();
		l.add(ruta.get(0).getCiudadA());
		for(Conexion i:ruta) {
			Ciudad el = i.getCiudadB();
			l.add(el);
		}
		
		return l;
	}
	
}
