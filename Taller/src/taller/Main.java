package taller;

import java.util.*;


public class Main {

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
