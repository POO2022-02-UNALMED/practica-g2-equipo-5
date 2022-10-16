package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;

import java.util.ArrayList;

import gestionAplicacion.Destinos.*;


public class VehiculoPasajeros extends Vehiculo {
	private int nAsientos;

	public VehiculoPasajeros(Conductor conductor, ArrayList<Conexion> ruta, String placa, String modelo, int nAsientos) {
		super(conductor, ruta, placa, modelo);
		this.nAsientos = nAsientos;
	}

	public int getnAsientos() {
		return nAsientos;
	}

	public void setnAsientos(int nAsientos) {
		this.nAsientos = nAsientos;
	}
	
}
