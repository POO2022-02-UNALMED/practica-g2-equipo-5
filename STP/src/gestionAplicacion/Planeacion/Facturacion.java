package gestionAplicacion.Planeacion.*;
import gestionAplicacion.Personas.*;
import java.util.ArrayList;

public class Facturacion{
    private ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private double distancia;
    private double peso;
    private double precio;
    private double tiempo;

    public Facturacion(ArrayList<Usuario> usuario, ArrayList<Producto> productos, double distancia, double peso, double precio, double tiempo) {
        this.usuario = usuario;
        this.productos = productos;
        this.distancia = distancia;
        this.peso = peso;
        this.precio = precio;
        this.tiempo = tiempo;
    }

    public Facturacion generarFacturacion(Viaje viaje){
        
        Facturacion x = null;
        int valorTotal = 0;
        
        if (this.usuario.length==1){
            valorTotal = viaje.getRuta().getPrecio() +(mercancia.productos.length*100) ;
            x = "El la factura del señor(a): " +this.usuario+ "es: \nCon viaje desde "+viaje.cOrigen+ "dirigido hacia " +
                    viaje.cDestino +" tiene un valor de: "+  valorTotal;
        }else{
            valorTotal = (viaje.getRuta().getPrecio()* this.usuario.length) +(mercancia.productos.length*100) ;
            x = "La factura de los señores (as): " +this.usuario+ "es: \nCon viaje desde "+viaje.cOrigen+ "dirigido hacia " +
                    viaje.cDestino+ " tiene un valor de: "+ valorTotal;
        }
        return x;
    }
    
    

    
    
    //GET Y SET
    
    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
