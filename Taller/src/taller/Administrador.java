package taller;

import java.util.*;

public class Administrador {
	private Cliente[] clientes;
	private Mecanico[] mecanicos;

	public Administrador() {

	}

	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, Vehiculo[] vehiculos, String correo, Date fechaRegistro) {
		Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, vehiculos, correo, fechaRegistro);
		clientes[clientes.length] = c;
	}

	
}
