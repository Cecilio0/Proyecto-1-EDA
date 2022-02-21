package taller;

import java.util.*;

public class Administrador {
	private Cliente[] clientes;
	private Mecanico[] mecanicos;

	public Administrador() {
    
		clientes = new Cliente [0];
		mecanicos = new Mecanico [0];
	}


	
	public double calcularNomina() {
		double nomina = 0;
		for (int i = 0; i < mecanicos.length; i++) {
			nomina += mecanicos[i].getSalario();
		}
		return nomina;
	}
	
	public void addHistorial() {
		
	}
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, Vehiculo[] vehiculos, String correo, Date fechaRegistro) {
		Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, vehiculos, correo, fechaRegistro);
		clientes[clientes.length] = c;
	}
	
	
	


	
}
