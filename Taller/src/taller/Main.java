package taller;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Administrador admin = new Administrador(); //crear dos clientes y uno con carro y uno con moto
		Date fecha = new Date();
		admin.addCliente("Daniel", "1001367558", fecha, "Calle 23a sur #5-135", "3116257519", "drones9182@gmail.com", fecha, "HPK279", "negro", true, 32000, true, 4, "Delantera");
		admin.addCliente("Natalia", "1001001000", fecha, "algun lugar", "311", "Natalia@gmail.com", fecha, "jqq788", "rojo", true, 10000, false, 2);
		admin.addMecanico("joe", "1", fecha, "aqui", "310", "Joe@gmail.com", fecha, 100);
		System.out.println(admin.mostrarMecanicos());
		admin.inflarLlantas("1001001000", "JQQ788", "");;
	}

}
