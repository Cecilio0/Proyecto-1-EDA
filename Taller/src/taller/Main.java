package taller;

import java.io.*;
import java.util.*;


public class Main {
	//considerar poner todo lo de los ficheros en su propia clase
	private static File[] ficheros;

	public static File buscarFichero(String nombreFichero) throws FileNotFoundException {
		int i = -1;
		while (++i < ficheros.length && ficheros[i] != null && !ficheros[i].getName().equalsIgnoreCase(nombreFichero));
		
		if (i != ficheros.length+1) {
			return ficheros[i-1];
		}
		throw new FileNotFoundException();
	}
	
	public static void cargarFicheros(String nombreFichero) throws IOException {//crea o carga los ficheros
		for (int i = 0; i < ficheros.length; i++) {
			if (!ficheros[i].exists()) {
				ficheros[i].createNewFile();
			}
		}
		//cargar toda la informacion al programa (Clientes, Mecanicos, precios)
	}
	
	public static void addInformacionFichero(String nombreFichero) throws FileNotFoundException {
		try {
			buscarFichero(nombreFichero);
		} catch (FileNotFoundException e) {
			throw e;
		}
	}
	
	public static void borrarDatoFichero(String nombreFichero, String dato) throws IOException {//borra una linea de un fichero pero para hacerlo se debe hacer un dato sin repetir eg: cedula
		File archivoO = buscarFichero(nombreFichero);
		File archivoT = new File("archivoT.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(archivoO));
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivoT));
		String aux;
		
		while ((aux = reader.readLine()) != null) {
			if (aux.contains(dato)) {
				continue;
			}
			writer.write(aux + "\n");
		}
		reader.close();
		writer.close();
		archivoO.delete();
		archivoT.renameTo(archivoO);
			
		
	}
	
	public static void actualizarDatoFichero(String nombreFichero, String dato, String nuevoDato) throws IOException{		File archivoO = buscarFichero(nombreFichero);
		File archivoO1 = buscarFichero(nombreFichero);
		File archivoT = new File("archivoT.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(archivoO1));
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivoT));
		String aux;
		
		while ((aux = reader.readLine()) != null) {
			if (aux.contains(dato)) {
				continue;
			}
			writer.write(aux + "\n");
		}
		reader.close();
		writer.close();
		archivoO1.delete();
		archivoT.renameTo(archivoO1);
		
		
	}
	
	
	public static void main(String[] args) {
		//hacer ficheros aqui para llamarlos cada vez que se inicie el codigo
		
		Scanner sc = new Scanner (System.in);
		Administrador admin = new Administrador(); //crear dos clientes y uno con carro y uno con moto
		Date fecha = new Date();
		admin.addCliente("Daniel", "1001367558", fecha, "Calle 23a sur #5-135", "3116257519", "drones9182@gmail.com", fecha, "HPK279", "negro", true, 32000, true, 4, "Delantera");
		admin.addCliente("Natalia", "1001001000", fecha, "algun lugar", "311", "Natalia@gmail.com", fecha, "jqq788", "rojo", true, 10000, false, 2);
		admin.addMecanico("joe", "1", fecha, "aqui", "310", "Joe@gmail.com", fecha, 100);
		System.out.println(admin.mostrarMecanicos()[0]);
		String codigo = sc.next();
		admin.cambioPintura("1001001000", "JQQ788", codigo, "verde");
		System.out.println(admin.buscarVehiculo("JQQ788").getColor());
		for (int i = 0; i < admin.mostrarHistorial("1001001000", "jQq788").length; i++) {
			String aux = admin.mostrarHistorial("1001001000", "jQq788")[i];
			System.out.println(aux);
		}
		sc.close();
	}

}
