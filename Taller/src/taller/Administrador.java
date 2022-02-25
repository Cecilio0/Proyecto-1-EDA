package taller;

import java.util.*;

public class Administrador {
	private Cliente[] clientes;
	private Mecanico[] mecanicos;

	public Administrador() {
		clientes = new Cliente [0];
		mecanicos = new Mecanico [0];
	}

	public double calcularNomina() {//calcular nomina, es decir cuanto en salarios se debe pagar al final del mes
		double nomina = 0;
		for (int i = 0; i < mecanicos.length; i++) {
			nomina += mecanicos[i].getSalario();
		}
		return nomina;
	}
	
	public void addHistorial(Date fechaIngreso, Mecanico mecanico, String accion, double precio, String cedulaCliente, String placa) {//Añadir historial a un vehiculo
		int i = -1;
		int j = -1;
		while (++i < clientes.length && !clientes[i].getCedula().equalsIgnoreCase(cedulaCliente));
		if (i < clientes.length) {
			while (++j < clientes[i].getVehiculos().length && clientes[i].getVehiculos()[j].getPlaca().equalsIgnoreCase(placa));
			if (j < clientes[i].getVehiculos().length) {
				clientes[i].getVehiculos()[j].addHistorial(fechaIngreso, mecanico, accion, precio);
			}
		}
	}
	
		// addCliente | Carro
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String marca, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion ){
		Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
		clientes = Arrays.copyOf(clientes, clientes.length + 1);
		clientes[clientes.length - 1] = c;

		addVehiculo(cedula, placa, color, estado, kilometraje, estadoLlantas, numPuertas, traccion);
	}

	// addCliente | Moto
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos){
		Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
		clientes = Arrays.copyOf(clientes, clientes.length + 1);
		clientes[clientes.length - 1] = c;

		addVehiculo(cedula, placa, color, estado, kilometraje, estadoLlantas, tiempos);
	}

	public void addMecanico(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String id, double salario) {
		Mecanico m = new Mecanico(nombre, cedula, fechaNacimiento, direccion, telefono, correo, id, salario);
		mecanicos = Arrays.copyOf(mecanicos, mecanicos.length + 1);
		mecanicos[mecanicos.length - 1] = m;
	}

	// addVehiculo | Carro
	public void addVehiculo(String cedula, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion) {
		buscarCliente(cedula).addVehiculo(placa, color, estado, kilometraje, estadoLlantas, numPuertas, traccion);
	}

	// addVehiculo | Moto
	public void addVehiculo(String cedula, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos) {
		buscarCliente(cedula).addVehiculo(placa, color, estado, kilometraje, estadoLlantas, tiempos);
	}
	
	//eliminar Cliente
	public void eliminarCliente(String cedula){
		int index = 0;
		while(index < clientes.length && clientes[index] != null && !clientes[index].getCedula().equals(cedula)) {
			index++;
		}
		if (index < clientes.length && clientes[index] != null && clientes[index].getCedula().equals(cedula)) {
			Cliente[] clientesRestantes = new Cliente[clientes.length-1];
			System.arraycopy(clientes, 0, clientesRestantes, 0, index);
			System.arraycopy(clientesRestantes, index+1, clientesRestantes, index, clientes.length-index-1);
			clientes = clientesRestantes;
		}
	}
	
	//eliminar Mecanico
	public void eliminarMecanico(String id) {
		int index = 0;
		while(index<mecanicos.length && mecanicos[index]!= null && !mecanicos[index].getId().equals(id)) {
			index++;
		}
		if (index<mecanicos.length && mecanicos[index]!= null && mecanicos[index].getId().equals(id)) {
			Mecanico[] mecanicosRestantes = new Mecanico[mecanicos.length-1];
			System.arraycopy(mecanicos, 0, mecanicosRestantes, 0, index);
			System.arraycopy(mecanicos, index+1, mecanicosRestantes, index, mecanicos.length-index-1);
			mecanicos = mecanicosRestantes;
		}
	}
	
	//eliminar Vehiculo
	public void eliminarVehiculo(String placa, String cedula) {
		int i = -1;
		while (++i < clientes.length && !clientes[i].getCedula().equals(cedula));
		if (i < clientes.length && clientes[i].getCedula().equals(cedula)) {
			clientes[i].eliminarVehiculo(placa);
		}
	}
//	buscar Cliente
	public Cliente buscarCliente(String cedula) {
		int num=clientes.length;
		for(int i =0; i<clientes.length; i++) {
			if(clientes[i].getCedula().equals(cedula)) {
				num=i;
				i=clientes.length;
			}
		}
		if(num==clientes.length) {
			return null;//mejor tirar excepcion, pero mas tarde
		} else return clientes[num];
	}
//	buscar Mecanico
	public Mecanico buscarMecanico(String id) {
		int num=mecanicos.length;
		for(int i =0; i<mecanicos.length; i++) {
			if(mecanicos[i].getId().equals(id)) {
				num=i;
				i=mecanicos.length;
			}
		}
		if(num==mecanicos.length) {
			return null;//basicamente la misma excepcion del anterior
		} else return mecanicos[num];
	}
//	buscar Vehiculo
	public Vehiculo buscarVehiculo(String placa) {
		int num=clientes.length;
		for(int i =0; i<clientes.length; i++) {
			if(clientes[i].buscarVehiculo(placa).equals(placa)) {
				num=i;
				i=clientes.length;
			}
		}
		if(num==clientes.length) {
			return null;//de nuevo, mejor una excepcion
		} else return clientes[num].buscarVehiculo(placa);
	}
	
	//a cargo de Simon
	public Historial[] mostrarHistorial(String cedula, String placa) {//devuelve el historial de un vehiculo
		return null;
	}
	
	//a cargo de Pablo
	public boolean existeCedula (String cedula) {//devuelve si ya existe un cliente con esa cedula
		return true;
	}
	
	public boolean existeVehiculo (String placa) {//devuelve si ya existe un vehiculo con esa placa;
		return true;
	}
	
	public boolean existeMecanico (String id) {//devuelve si ya existe un mecanico con ese id
		return true;
	}
	
	//a cargo de Simon
	public String generarId() {//genera un codigo para un mecanico nuevo del formato 000 tres numeros aleatorios
		return null;
	}
	
	public double calcularIngresos() {//
		return null;
	}
	
	public double calcularUtilidad() {//
		return null;
	}
	
	//a cargo de camilo
	public void cambioAceite (String cedula, String placa, int kilometraje) {// "cambia" el aceite de un vehiculo, para su correcto funcionamiento debe cambiar el kilometrajeUltimaRevision por kilometraje, ademas debe crear un dato tipo historial
		
	}
	
	public void inflarLlantas (String cedula, String placa, boolean estadoLlantas) {// "infla" las llantas de un vehiculo, para su correcto funcionamiento debe cambiar el estadoLlantas a true, ademas debe crear un dato tipo historial
		
	}
	
	public void cambioPintura (String cedula, String placa, String color) {// "cambia" el color de un vehiculo, para su correcto funcionamiento debe cambiar el color del vehiculo al color nuevo, ademas debe crear un dato tipo historial
		
	}
	
	//a cargo de Daniel
	public boolean[] diagnostico(String cedula, String placa) {//
		return null;
	}
	
	public String[] mantenimientoGeneral (String cedula, String placa) {
		boolean [] diagnostico = diagnostico (cedula, placa);
		return null;
	}
}
