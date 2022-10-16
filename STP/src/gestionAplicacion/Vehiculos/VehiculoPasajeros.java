package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;

import java.util.ArrayList;

import gestionAplicacion.Destinos.*;


public class VehiculoPasajeros extends Vehiculo {
	private int nAsientos;
	public static ArrayList<VehiculoPasajeros> vehiculos = new ArrayList<VehiculoPasajeros>();
	public VehiculoPasajeros(Conductor conductor, ArrayList<Conexion> ruta, String placa, String modelo, int nAsientos) {
		super(conductor, ruta, placa, modelo);
		this.nAsientos = nAsientos;
	}
	public VehiculoPasajeros(String marca,double precio,String modelo,String placa,int nAsientos) {
		super(marca,precio,modelo,placa);
		this.nAsientos = nAsientos;
		vehiculos.add(this);
	}
	

	public int getnAsientos() {
		return nAsientos;
	}

	public void setnAsientos(int nAsientos) {
		this.nAsientos = nAsientos;
	}
	
}
