package gestionAplicacion.Personas;
import java.io.Serializable;

public abstract class Persona implements Serializable{
    private String nombre;
    private String documento;
    private String direccion;
    private String edad;

    public Persona(String nombre, String documento, String direccion, String edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.direccion = direccion;
        this.edad = edad;
    }
    public Persona() {
    	super();
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
}
