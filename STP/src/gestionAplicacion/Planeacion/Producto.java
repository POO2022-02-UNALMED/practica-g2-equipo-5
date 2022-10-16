package gestionAplicacion.Planeacion;
import gestionAplicacion.Destinos.*;

public class Producto {
	private String tipo;
	private Double peso;
	private Ciudad cOrigen;
	private Ciudad cDestino;
	
	public Producto(String tipo, Double peso, Ciudad cOrigen, Ciudad cDestino) {
		super();
		this.tipo = tipo;
		this.peso = peso;
		this.cOrigen = cOrigen;
		this.cDestino = cDestino;
	}
	public Producto();

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Ciudad getcOrigen() {
		return cOrigen;
	}

	public void setcOrigen(Ciudad cOrigen) {
		this.cOrigen = cOrigen;
	}

	public Ciudad getcDestino() {
		return cDestino;
	}

	public void setcDestino(Ciudad cDestino) {
		this.cDestino = cDestino;
	}
	
	
	
}
