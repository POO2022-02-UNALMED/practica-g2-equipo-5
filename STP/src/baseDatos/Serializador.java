package baseDatos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import gestionAplicacion.Personas.Usuario;

public class Serializador {
	
	public static void serializador(Usuario usuario) {
		String ub = System.getProperty("user.dir") + "/STP/src/baseDatos/temp/" + "Guzman.txt";
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ub))){
			oos.writeObject(usuario);
		} catch(IOException e) {}
	}
}
