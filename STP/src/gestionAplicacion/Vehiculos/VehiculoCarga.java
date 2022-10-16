package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;

import java.util.ArrayList;

import gestionAplicacion.Destinos.*;


public class VehiculoCarga extends Vehiculo{
	private int capacidadMaxima;
	//constructores
	public VehiculoCarga(Conductor conductor, ArrayList<Conexion> ruta, String placa, String modelo, int capacidadMaxima) {
		super(conductor, ruta, placa, modelo);
		this.capacidadMaxima = capacidadMaxima;
	}
	//public VehiculoCarga(Sring placa,String modelo, )
	

	
}
