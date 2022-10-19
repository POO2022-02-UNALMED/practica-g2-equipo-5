package gestionAplicacion.Planeacion;

public class Producto {
	private String tipo;
	private Double peso;
	
	public Producto(String tipo, Double peso) {
		super();
		this.tipo = tipo;
		this.peso = peso;
	}
	public Producto() {
	}

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
}
