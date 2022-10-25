package baseDatos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import gestionAplicacion.Personas.*;

public class Deserializador {
	public static Usuario deserializador(String ruta) {
		try {
			FileInputStream file = new FileInputStream(ruta);
	        ObjectInputStream in = new ObjectInputStream(file);
	        Usuario usuario = (Usuario)in.readObject();
	        ArrayList<Usuario> user = new ArrayList<Usuario>(); 
	        user.add(usuario);
	        Usuario.setUser(user);
	        in.close();
	        file.close();
	        return usuario;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return new Usuario("error");
		}
        
	}
}
