package baseDatos;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestionAplicacion.Personas.Usuario;

public class Serializador {
	private static File rutaTemp = new File("/STP/src/baseDatos/temp");

	public static void serializar(Usuario usuario) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		for (File file : docs) {
			try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		for (File file : docs) {

			if (file.getAbsolutePath().contains("viaje")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(usuario.getViaje());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("mercancia")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(usuario.getMercancia());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("facturacion")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(usuario.getFacturacion());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}