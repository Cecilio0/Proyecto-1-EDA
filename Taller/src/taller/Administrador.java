package taller;

import java.util.*;

public class Administrador {
	private Cliente[] clientes;
	private Mecanico[] mecanicos;

	public Administrador() {
		clientes = new Cliente [0];
		mecanicos = new Mecanico [0];
	}
	
	public boolean existeCedula (String cedula) {//devuelve si ya existe un cliente con esa cedula
		int index = 0;
		while(index< clientes.length && clientes[index] != null && !clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			index++;
		}
		if(index< clientes.length && clientes[index] != null && clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existeVehiculo (String placa) {//devuelve si ya existe un vehiculo con esa placa;
		int index=0;
		while(index< clientes.length && clientes[index]!= null && clientes[index].buscarVehiculo(placa) != null && !clientes[index].buscarVehiculo(placa).getPlaca().equalsIgnoreCase(placa)) {
			index++;
		}
		if(index < clientes.length && clientes[index]!= null && clientes[index].buscarVehiculo(placa) != null && clientes[index].buscarVehiculo(placa).getPlaca().equalsIgnoreCase(placa)) {
			return true;
		} else {
			return false;
		}
		
	}

	public boolean existeId(String id) {
		boolean a = false;
		for (Mecanico mecanico : mecanicos) {
			if (mecanico.getId().equalsIgnoreCase(id)) {
				a = true;
				break;
			}
		}
		return a;
	}
	
	public String generarId() {//genera un codigo para un mecanico nuevo del formato 000 tres numeros aleatorios
		StringBuilder id = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			id.append((int) (Math.random() * 10));
		}
		while (existeId(id.toString())) {
			id.delete(0, id.length());
			for (int i = 0; i < 3; i++) {
				id.append((int) (Math.random() * 10));
			}
		}
		return id.toString();
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
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion ){//que devuelva el error ya hay cliente con esta cedula
		if (!existeCedula(cedula)) {
			Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
			clientes = Arrays.copyOf(clientes, clientes.length + 1);
			clientes[clientes.length - 1] = c;

			addVehiculo(cedula, placa, color, estado, kilometraje, estadoLlantas, numPuertas, traccion);
		} else {
			//crear excepcion de ya hay cliente con esa cedula
		}	
	}

	// addCliente | Moto
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos){//que devuelva el error ya hay cliente con esta cedula
		if (!existeCedula(cedula)) {
			Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
			clientes = Arrays.copyOf(clientes, clientes.length + 1);
			clientes[clientes.length - 1] = c;

			addVehiculo(cedula, placa, color, estado, kilometraje, estadoLlantas, tiempos);
		} else {
			//crear excepcion de ya hay cliente con esa cedula
		}
	}

	public void addMecanico(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, double salario) {
		Mecanico m = new Mecanico(nombre, cedula, fechaNacimiento, direccion, telefono, correo, generarId(), salario);
		mecanicos = Arrays.copyOf(mecanicos, mecanicos.length + 1);
		mecanicos[mecanicos.length - 1] = m;
	}

	// addVehiculo | Carro
	public void addVehiculo(String cedula, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion) {//que devuelva el error ya hay vehiculo con esta placa
		if (buscarCliente(cedula) != null) {//tal vez cambiar por un try catch mas adelante
			if (!existeVehiculo(placa)) {
				buscarCliente(cedula).addVehiculo(placa, color, estado, kilometraje, estadoLlantas, numPuertas, traccion);
			} else {
				//crear excepcion de ya hay vehiculo con esa placa
			}
		} else {
			// en vez de if else try catch de no hay cliente con esa cedula
		}
			
		
	}

	// addVehiculo | Moto
	public void addVehiculo(String cedula, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos) {//que devuelva el error ya hay vehiculo con esta placa
		if (buscarCliente(cedula) != null) {//tal vez cambiar por un try catch mas adelante
			if (!existeVehiculo(placa)) {
				buscarCliente(cedula).addVehiculo(placa, color, estado, kilometraje, estadoLlantas, tiempos);
			} else {
				//crear excepcion de ya hay vehiculo con esa placa
			}
		} else {
			// en vez de if else try catch de no hay cliente con esa cedula
		}
		
	}
	
//	buscar Cliente
	public Cliente buscarCliente(String cedula) {
		int num=clientes.length;
		for(int i =0; i<clientes.length; i++) {
			if(clientes[i].getCedula().equalsIgnoreCase(cedula)) {
				num=i;
				i=clientes.length;
			}
		}
		if(num==clientes.length) {
			return null;//crear en vez de null excepcion de no hay cliente con esa cedula
		} else return clientes[num];
	}
	
//	buscar Mecanico
	public Mecanico buscarMecanico(String id) {
		int num=mecanicos.length;
		for(int i =0; i<mecanicos.length; i++) {
			if(mecanicos[i].getId().equalsIgnoreCase(id)) {
				num=i;
				i=mecanicos.length;
			}
		}
		if(num==mecanicos.length) {
			return null;//crear en vez de null excepcion de no hay mecanico con ese id
		} else return mecanicos[num];
	}
	
//	buscar Vehiculo
	public Vehiculo buscarVehiculo(String placa) {
		int num=clientes.length;
		for(int i =0; i<clientes.length; i++) {
			if(clientes[i].buscarVehiculo(placa) != null && clientes[i].buscarVehiculo(placa).getPlaca().equalsIgnoreCase(placa)) {
				num=i;
				i=clientes.length;
			}
		}
		if(num==clientes.length) {
			return null;//crear en vez de null excepcion de no hay vehiculo con esa placa
		} else return clientes[num].buscarVehiculo(placa);
	}
	
	//eliminar Cliente
	public void eliminarCliente(String cedula){
		int index = 0;
		while(index < clientes.length && clientes[index] != null && !clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			index++;
		}
		if (index < clientes.length && clientes[index] != null && clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			Cliente[] clientesRestantes = new Cliente[clientes.length-1];
			System.arraycopy(clientes, 0, clientesRestantes, 0, index);
			System.arraycopy(clientesRestantes, index+1, clientesRestantes, index, clientes.length-index-1);
			clientes = clientesRestantes;
		} else {
			// en vez de if else try catch de no hay cliente con esa cedula
		}
	}
	
	//eliminar Mecanico
	public void eliminarMecanico(String id) {
		int index = 0;
		while(index<mecanicos.length && mecanicos[index]!= null && !mecanicos[index].getId().equalsIgnoreCase(id)) {
			index++;
		}
		if (index<mecanicos.length && mecanicos[index]!= null && mecanicos[index].getId().equalsIgnoreCase(id)) {
			Mecanico[] mecanicosRestantes = new Mecanico[mecanicos.length-1];
			System.arraycopy(mecanicos, 0, mecanicosRestantes, 0, index);
			System.arraycopy(mecanicos, index+1, mecanicosRestantes, index, mecanicos.length-index-1);
			mecanicos = mecanicosRestantes;
		} else {
			// en vez de if else try catch de no hay mecanico con ese id
		}
	}
	
	//eliminar Vehiculo
	public void eliminarVehiculo(String placa, String cedula) {
		int i = -1;
		while (++i < clientes.length && !clientes[i].getCedula().equalsIgnoreCase(cedula));
		if (i < clientes.length && clientes[i].getCedula().equalsIgnoreCase(cedula)) {
			clientes[i].eliminarVehiculo(placa);
		} else {
			// en vez de if else try catch de no hay vehiculo con esa placa
		}
	}
	
	public Historial[] mostrarHistorial(String cedula, String placa) {//devuelve el historial de un vehiculo
		return buscarCliente(cedula).buscarVehiculo(placa).getHistorial();//hacer try catch de no hay cliente con esa cedula, try catch de no hay vehiculo con esa placa y Crear excepcion de no hay historial
	}

	public String[] mostrarMecanicos() {//devuelve un string que cada posicion muestre un mecanico con nombre y id y es necesario considerar la creacion de excepciones cuando no haya mecanicos
		if (mecanicos == null || mecanicos.length == 0) {
			//crear excepcion de no hay mecanicos
		}
		String[] info = new String [0];
		for (int i = 0; i < mecanicos.length; i++) {
			info = Arrays.copyOf(info, info.length+1);
			info[info.length-1] = "Nombre: " + mecanicos[i].getNombre() + "\tCedula: " + mecanicos[i].getCedula() + "\tId: " + mecanicos[i].getId();
		}
		return info;
	}

	public double calcularNomina(Date fecha) {//Excepcion de vector nulo
		double nomina = 0;
		for (Mecanico mecanico : mecanicos) {
			if (mecanico.getFechaSalida() == null || mecanico.getFechaSalida().before(fecha)) {
				nomina += mecanico.getSalario();
			}
		}
		return nomina;
	}
	
	public double calcularIngresos(Date fecha) {//calcula ingresos antes de gastos del taller
		double sumIngresos = 0;
		for (Cliente cliente : clientes) {
			for (int j = 0; j < cliente.getVehiculos().length; j++) {
				for (int k = 0; k < cliente.getVehiculos()[j].getHistorial().length; k++) {
					if (cliente.getVehiculos()[j].getHistorial()[k].getMes() == fecha.getMonth()) {
						sumIngresos += cliente.getVehiculos()[j].getHistorial()[k].getPrecio();
					}
				}
			}
		}
		return sumIngresos;
	}

	public double calcularUtilidad(Date fecha) {//calcula la utilidad del taller
		return calcularIngresos(fecha) - calcularNomina(fecha);
	}
	
	public void cambioAceite (String cedula, String placa, String idMecanico, int kilometraje) {// "cambia" el aceite de un vehiculo, para su correcto funcionamiento debe cambiar el kilometrajeUltimaRevision por kilometraje, ademas debe crear un dato tipo historial
		Date date = new Date();		
		String accion = "Cambio de aceite";
		Mecanico mecanico = buscarMecanico(idMecanico);//hacer try catch de no hay mecanico con ese id
		double precio = 50;//escribir esto con if de manera que si es carro sea un precio distinto al de una moto y escribir los precios en ficheros para poderlos cambiar(extra)
		buscarVehiculo(placa).setKilometraje(kilometraje);
		buscarVehiculo(placa).setKilometrajeAceite(kilometraje);
		addHistorial(date, mecanico, accion, precio, cedula, placa);
	}
	
	public void inflarLlantas (String cedula, String placa,String idMecanico) {// "infla" las llantas de un vehiculo, para su correcto funcionamiento debe cambiar el estadoLlantas a true, ademas debe crear un dato tipo historial
		Date date = new Date();		
		String accion = "Inflar llantas";
		Mecanico mecanico = buscarMecanico(idMecanico);//hacer try catch de no hay mecanico con ese id
		double precio= 25;//escribir esto con if de manera que si es carro sea un precio distinto al de una moto
		buscarVehiculo(placa).setEstadoLlantas(true);
		addHistorial(date, mecanico, accion, precio, cedula, placa);
	}
	
	public void cambioPastas (String cedula, String placa,String idMecanico, int kilometraje) {
		Date hoy = Calendar.getInstance().getTime();
		String accion = "Cambio de pastas";
		Mecanico m = buscarMecanico(idMecanico);
		double precio = 50;
		buscarVehiculo(placa).setKilometraje(kilometraje);
		buscarVehiculo(placa).setKilometrajePastas(kilometraje);
		addHistorial(hoy, m, accion, precio, cedula, placa);
	}
	
	public void lavadoVehiculo (String cedula, String placa, String idMecanico) {//para desarrollar este crear atributo en la clase vehiculo que sea un boolean llamado "limpio"
		Date hoy = Calendar.getInstance().getTime();
		String accion = "Lavado";
		Mecanico m = buscarMecanico(idMecanico);
		double precio = 50;
		buscarVehiculo(placa).setLimpio(true);
		addHistorial(hoy, m, accion, precio, cedula, placa);
	}
	
	public void servicioEspecial (String cedula, String placa, String idMecanico, String accion, double precio) {//para desarrollar un servicio no estandarisado con precio y accion variable
		Date hoy = Calendar.getInstance().getTime();
		Mecanico m = buscarMecanico(idMecanico);
		addHistorial(hoy, m, accion, precio, cedula, placa);
	}
	
	public void cambioPintura (String cedula, String placa, String idMecanico, String color) {// "cambia" el color de un vehiculo, para su correcto funcionamiento debe cambiar el color del vehiculo al color nuevo, ademas debe crear un dato tipo historial
		Date date = new Date();		
		String accion = "Cambio de pintura";
		Mecanico mecanico = buscarMecanico(idMecanico);//hacer try catch de no hay mecanico con ese id
		double precio= 100;//escribir esto con if de manera que si es carro sea un precio distinto al de una moto
		buscarVehiculo(placa).setColor(color);//revisar si esto si cambia el dato original en el main
		addHistorial(date, mecanico, accion, precio, cedula, placa);
	}
	
	public void actualizarVehiculo(String placa, int kilometraje, boolean estadoLlantas, boolean limpio){//actualiza la informacion del vehiculo
		buscarVehiculo(placa).setKilometraje(kilometraje);
		buscarVehiculo(placa).setEstadoLlantas(estadoLlantas);
		buscarVehiculo(placa).setLimpio(limpio);
	}
	
	public boolean[] diagnostico(String cedula, String placa) {//revisa si es necesario o se recomendaria hacer algun servicio al vehiculo en cuestion y devuelve cuales si y cuales no en un vector de booleans
		boolean [] diagnostico = new boolean[4];
		Arrays.fill(diagnostico, false);
		Vehiculo v = buscarVehiculo(placa);
		if (v.getKilometraje() - v.getKilometrajeAceite() > 10000) {
			diagnostico [0] = true;
		}
		if (!v.isEstadoLlantas()) {
			diagnostico [1] = true;
		}
		if (v.getKilometraje() - v.getKilometrajePastas() > 10000) {
			diagnostico[2] = true;
		}
		if (!v.isLimpio()) {
			diagnostico[3] = true;
		}
		
		return diagnostico;
	}
	
	public String[] mantenimientoGeneral (String cedula, String placa, String idMecanico) {//lee el vector de boolean que devuelve diagnostico y los ejecuta
		String [] cambios = new String [4];
		boolean [] diagnostico = diagnostico (cedula, placa);
		Vehiculo v = buscarVehiculo(placa);//hacer try catch de no hya vehiculo con esa placa
		if (diagnostico[0]) {
			cambioAceite(cedula, placa, idMecanico, v.getKilometraje());
			cambios[0] = "Se le cambio el aceite al vehiculo ";
		}
		if (diagnostico[1]) {
			inflarLlantas(cedula, placa, idMecanico);
			cambios[1] = "Se le inflaron las llantas al vehiculo ";
		}
		if (diagnostico[2]) {
			cambioPastas(cedula, placa, idMecanico, v.getKilometraje());
			cambios[2] = "Se le cambiaron las pastas de frenos al vehiculo";
		}
		if (diagnostico[3]) {
			lavadoVehiculo(cedula, placa, idMecanico);
			cambios[3] = "Se lavo el vehiculo";
		}
		return cambios;//leer el vector cambios con un ciclo for y que adentro lleve un if que revise que el vector en cada posicion NO sea null
	}//considerar la creacion de un metodo que este orientado a la actualizacion de los datos del vehiculo que se llame actualizarVehiculo (String cedula, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion)
	
	public String[] pagoDeuda(String cedula) {//para que un cliente pague su deuda
		return buscarCliente(cedula).pagoDeuda();
	}
	
}
