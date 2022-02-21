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
	
	public void addHistorial(Date fechaIngreso, Date fechaDevolucion, Mecanico mecanico, String accion, double precio, String cedulaCliente, String placa) {
		int i = -1;
		int j = -1;
		while (++i < clientes.length && !clientes[i].getCedula().equalsIgnoreCase(cedulaCliente));
		if (i < clientes.length) {
			while (++j < clientes[i].getVehiculos().length && clientes[i].getVehiculos()[j].getPlaca().equalsIgnoreCase(placa));
			if (j < clientes[i].getVehiculos().length) {
				clientes[i].getVehiculos()[j].addHistorial(fechaIngreso, fechaDevolucion, mecanico, accion, precio);
			}
		}
	}
	
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, Vehiculo[] vehiculos, String correo, Date fechaRegistro) {
		Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, vehiculos, correo, fechaRegistro);
		clientes[clientes.length] = c;
	}
	
	
	


	
}
