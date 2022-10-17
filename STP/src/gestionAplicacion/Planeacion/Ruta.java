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
	public ArrayList<String> listCiudades(){
		ArrayList<String> l = new ArrayList<String>();
		l.add(ruta.get(0).ciudadA);
		for(Conexion i:ruta) {
			String el = i.ciudadB;
			l.add(el);
		}
		
		return l;
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
}
