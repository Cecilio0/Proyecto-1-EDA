package taller;

import java.util.*;

public class Administrador {
	private Cliente[] clientes;
	private Mecanico[] mecanicos;

	public Administrador() {mecanicos = new Mecanico[0];clientes = new Cliente[0];}

	// addCliente | Carro
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje, int numPuertas, String traccion ){
		Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
		clientes = Arrays.copyOf(clientes, clientes.length + 1);
		clientes[clientes.length - 1] = c;

		addVehiculo(cedula, placa, marca, color, ano, automatico, estado, cilindraje, numPuertas, traccion);
	}

	// addCliente | Moto
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje, int tiempos){
		Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
		clientes = Arrays.copyOf(clientes, clientes.length + 1);
		clientes[clientes.length - 1] = c;

		addVehiculo(cedula, placa, marca, color, ano, automatico, estado, cilindraje, tiempos);
	}

	public void addMecanico(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String id, double salario) {
		Mecanico m = new Mecanico(nombre, cedula, fechaNacimiento, direccion, telefono, correo, id, salario);
		mecanicos = Arrays.copyOf(mecanicos, mecanicos.length + 1);
		mecanicos[mecanicos.length - 1] = m;
	}

	// addVehiculo | Carro
	public void addVehiculo(String CC, String placa, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje, int numPuertas, String traccion) {
		Carro c = new Carro(placa, marca, color, ano, automatico, estado, cilindraje, numPuertas, traccion);

		Vehiculo[] aux = buscarCliente(CC).getVehiculos();
		aux = Arrays.copyOf(aux, aux.length + 1);
		aux[aux.length - 1] = c;
		buscarCliente(CC).setVehiculos(aux);
	}

	// addVehiculo | Moto
	public void addVehiculo(String CC, String placa, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje, int tiempos) {
		Moto v = new Moto(placa, marca, color, ano, automatico, estado, cilindraje, tiempos);

		Vehiculo[] aux = buscarCliente(CC).getVehiculos();
		aux = Arrays.copyOf(aux, aux.length + 1);
		aux[aux.length - 1] = v;
		buscarCliente(CC).setVehiculos(aux);
	}
}
