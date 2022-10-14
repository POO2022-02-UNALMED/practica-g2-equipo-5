package gestionAplicacion.Vehiculos;
import gestionAplicacion.Personas.*;
import gestionAplicacion.Destinos.*;


public class VehiculoCarga extends Vehiculo{
	private int capacidadMaxima;

	public VehiculoCarga(Conductor conductor, Conexion[] ruta, String placa, String modelo, int capacidadMaxima) {
		super(conductor, ruta, placa, modelo);
		this.capacidadMaxima = capacidadMaxima;
	}
	

	
}
