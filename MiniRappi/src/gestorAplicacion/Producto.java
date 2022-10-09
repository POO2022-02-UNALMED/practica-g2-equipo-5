import java.util.ArrayList;

public class Producto {
	
	/* Atributos */
	private String nombre;
	private ArrayList<String> ingredientes = new ArrayList<String>();
	private int cantidad;
	private Facturacion precio;
	private Float costo;
	
	/* Getter and Setter */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Facturacion getPrecio() {
		return precio;
	}
	public void setPrecio(Facturacion precio) {
		this.precio = precio;
	}
	public Float getCosto() {
		return costo;
	}
	public void setCosto(Float costo) {
		this.costo = costo;
	}
	
	
}
