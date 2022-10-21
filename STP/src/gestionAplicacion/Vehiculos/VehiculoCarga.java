package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;

import java.util.ArrayList;

import gestionAplicacion.Destinos.*;


public class VehiculoCarga extends Vehiculo{
	private int capacidadMaxima;
	public static ArrayList<VehiculoCarga> vehiculos = new ArrayList<VehiculoCarga>();
	//constructores
	public VehiculoCarga(Conductor conductor, ArrayList<Conexion> ruta, String placa, int modelo, int capacidadMaxima) {
		super(conductor, ruta, placa, modelo);
		this.capacidadMaxima = capacidadMaxima;
	}
	public VehiculoCarga(String marca,double precio,int modelo,String placa,int capacidadMaxima) {
		super(marca,precio,modelo,placa);
		this.capacidadMaxima = capacidadMaxima;
		vehiculos.add(this);
	}
	
	
	//getters and setters
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	
	//metodos
	public static ArrayList<VehiculoCarga> validarCapacidad(int min){
		ArrayList<VehiculoCarga> l = new ArrayList<VehiculoCarga>();
		for(VehiculoCarga i:vehiculos) {
			if(i.getCapacidadMaxima()>=min) {
				l.add(i);
			}
		}
		return l;
	}
	
	
}
