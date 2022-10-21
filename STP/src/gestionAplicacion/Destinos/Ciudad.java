package gestionAplicacion.Destinos;

public class Ciudad {
	private String nombre;
	private String departamento;
	
	public Ciudad(String nombre, String departamento) {
		this.nombre = nombre;
		this.departamento = departamento;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDepartamento() {
		return departamento;
	}

}
