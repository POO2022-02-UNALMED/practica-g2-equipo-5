package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import gestionAplicacion.Personas.Usuario;
import gestionAplicacion.Planeacion.Mercancia;
import gestionAplicacion.Planeacion.Facturacion;
import gestionAplicacion.Planeacion.Viaje;

public class Deserializador {
	private static File rutaTemp = new File("/STP/src/baseDatos/temp");

	public static void deserializar(Usuario usuario) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;

		for (File file : docs) {
			if (file.getAbsolutePath().contains("viaje")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					usuario.setViaje((ArrayList<Viaje>) ois.readObject());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("facturacion")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					usuario.setFacturacion((ArrayList<Facturacion>) ois.readObject());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("mercancia")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					usuario.setMercancia((ArrayList<Mercancia>) ois.readObject());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
