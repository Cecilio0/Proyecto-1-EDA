package taller;

import java.util.*;
import java.io.*;

public class Administrador {
	private Cliente[] clientes;
	private Mecanico[] mecanicos;
	
	//Excepcion EYaExiste
	class EYaExiste extends Exception{
		public EYaExiste(String s) {
			super(s);
		}
	}
	//Excepcion EVectorNulo
	class EVectorNulo extends Exception{
		public EVectorNulo(String s) {
			super(s);
		}
	}
	//Excepcion ENoExiste
	class ENoExiste extends Exception{
		public ENoExiste(String s) {
			super(s);
		}
	}

	public Administrador() {
		clientes = new Cliente [0];
		mecanicos = new Mecanico [0];

		cargarFicheros();
	}

	public void cargarFicheros() {
		try {
			FileInputStream fis = new FileInputStream("Clientes.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			clientes = (Cliente[]) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			FileInputStream fis = new FileInputStream("Mecanicos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			mecanicos = (Mecanico[]) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public void guardarFicheros() {
		try {
			FileOutputStream fos = new FileOutputStream("Clientes.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientes);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try {
			FileOutputStream fos = new FileOutputStream("Mecanicos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mecanicos);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean existeCedula (String cedula) throws EYaExiste {//devuelve si ya existe un cliente con esa cedula
		int index = 0;
		while(index< clientes.length && clientes[index] != null && !clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			index++;
		}
		if(index< clientes.length && clientes[index] != null && clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			throw new EYaExiste("La cedula ingresada ya existe") ;
		} else {
			return false;
		}
	}
	
	public boolean existeVehiculo (String placa) throws EYaExiste {//devuelve si ya existe un vehiculo con esa placa;
		int index=0;
		while(index< clientes.length && clientes[index]!= null && clientes[index].buscarVehiculo(placa) != null && !clientes[index].buscarVehiculo(placa).getPlaca().equalsIgnoreCase(placa)) {
			index++;
		}
		if(index < clientes.length && clientes[index]!= null && clientes[index].buscarVehiculo(placa) != null && clientes[index].buscarVehiculo(placa).getPlaca().equalsIgnoreCase(placa)) {
			throw new EYaExiste("El vehiculo asociado a la placa ingresada ya existe");
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
	
	public void addHistorial(Date fechaIngreso, Mecanico mecanico, String accion, double precio, String cedulaCliente, String placa) throws ENoExiste{//Añadir historial a un vehiculo
		buscarVehiculo(placa).addHistorial(fechaIngreso, mecanico, accion, precio);

		guardarFicheros();
	}
	
	// addCliente | Carro
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion ) throws EYaExiste, ENoExiste{//que devuelva el error ya hay cliente con esta cedula
		if (!existeCedula(cedula)) {
			Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
			clientes = Arrays.copyOf(clientes, clientes.length + 1);
			clientes[clientes.length - 1] = c;

			addVehiculo(cedula, placa, color, estado, kilometraje, estadoLlantas, numPuertas, traccion);
			guardarFicheros();
	}

	// addCliente | Moto
	public void addCliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos) throws EYaExiste, ENoExiste{//que devuelva el error ya hay cliente con esta cedula
		if (!existeCedula(cedula)) {
			Cliente c = new Cliente(nombre, cedula, fechaNacimiento, direccion, telefono, correo, fechaRegistro);
			clientes = Arrays.copyOf(clientes, clientes.length + 1);
			clientes[clientes.length - 1] = c;

			addVehiculo(cedula, placa, color, estado, kilometraje, estadoLlantas, tiempos);
			guardarFicheros();
		}
	}

	public void addMecanico(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro, double salario) {
		Mecanico m = new Mecanico(nombre, cedula, fechaNacimiento, direccion, telefono, correo, generarId(), salario);
		mecanicos = Arrays.copyOf(mecanicos, mecanicos.length + 1);
		mecanicos[mecanicos.length - 1] = m;

		guardarFicheros();
	}

	// addVehiculo | Carro
	public void addVehiculo(String cedula, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion) throws ENoExiste, EYaExiste {//que devuelva el error ya hay vehiculo con esta placa
		if (buscarCliente(cedula) != null) {//tal vez cambiar por un try catch mas adelante
			if (!existeVehiculo(placa)) {
				buscarCliente(cedula).addVehiculo(placa, color, estado, kilometraje, estadoLlantas, numPuertas, traccion);
				guardarFicheros();
			}
		}
			
		
	}

	// addVehiculo | Moto
	public void addVehiculo(String cedula, String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos) throws ENoExiste, EYaExiste {//que devuelva el error ya hay vehiculo con esta placa
		if (buscarCliente(cedula) != null) {//tal vez cambiar por un try catch mas adelante
			if (!existeVehiculo(placa)) {
				buscarCliente(cedula).addVehiculo(placa, color, estado, kilometraje, estadoLlantas, tiempos);
				guardarFicheros();
      }
		}
	}
	
//	buscar Cliente
	public Cliente buscarCliente(String cedula) throws ENoExiste {
		int i = 0;
		while (i < clientes.length && clientes[i] != null && !clientes[i].getCedula().equalsIgnoreCase(cedula)) {
			i++;
		}
		if (i < clientes.length && clientes[i].getCedula().equalsIgnoreCase(cedula)) {
			return clientes[i];
		} else {
			throw new ENoExiste("No existe un cliente con la cedula ingresada");//crear en vez de null excepcion de no hay cliente con esa cedula
		}
	}
	
//	buscar Mecanico
	public Mecanico buscarMecanico(String id) throws ENoExiste {
		int i = 0;
		while (i < mecanicos.length && mecanicos[i] != null && !mecanicos[i].getId().equalsIgnoreCase(id)) {
			i++;
		}
		if (i < mecanicos.length && mecanicos[i].getId().equalsIgnoreCase(id)) {
			return mecanicos[i];
		} else {
			throw new ENoExiste("No existe un mecanico con el id ingresado");//crear en vez de null excepcion de no hay mecanico con ese id
		}
	}
	
//	buscar Vehiculo
	public Vehiculo buscarVehiculo(String placa) throws ENoExiste{
		int i = 0;
		while (i < clientes.length && clientes[i] != null && clientes[i].buscarVehiculo(placa) == null) {
			i++;
		}
		if (i < clientes.length && clientes[i].buscarVehiculo(placa) != null) {
			return clientes[i].buscarVehiculo(placa);
		} else {
			throw new ENoExiste("No existe un vehiculo con la placa ingresada");//crear en vez de null excepcion de no hay cliente con esa cedula
		}
	}
	
	//eliminar Cliente
	public void eliminarCliente(String cedula) throws ENoExiste{
		int index = 0;
		while(index < clientes.length && clientes[index] != null && !clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			index++;
		}
		if (index < clientes.length && clientes[index] != null && clientes[index].getCedula().equalsIgnoreCase(cedula)) {
			Cliente[] clientesRestantes = new Cliente[clientes.length-1];
			System.arraycopy(clientes, 0, clientesRestantes, 0, index);
			System.arraycopy(clientesRestantes, index+1, clientesRestantes, index, clientes.length-index-1);
			clientes = clientesRestantes;
			guardarFicheros();
		} else {
			throw new ENoExiste("No existe un cliente con la cedula ingresada para eliminar");
		}
	}
	
	//eliminar Mecanico
	public void eliminarMecanico(String id) throws ENoExiste {
		int index = 0;
		while(index<mecanicos.length && mecanicos[index]!= null && !mecanicos[index].getId().equalsIgnoreCase(id)) {
			index++;
		}
		if (index<mecanicos.length && mecanicos[index]!= null && mecanicos[index].getId().equalsIgnoreCase(id)) {
			Mecanico[] mecanicosRestantes = new Mecanico[mecanicos.length-1];
			System.arraycopy(mecanicos, 0, mecanicosRestantes, 0, index);
			System.arraycopy(mecanicos, index+1, mecanicosRestantes, index, mecanicos.length-index-1);
			mecanicos = mecanicosRestantes;
			guardarFicheros();
		} else {
			throw new ENoExiste("No existe un mecanico con el id ingresado para eliminar");
		}
	}
	//eliminar Vehiculo
	public void eliminarVehiculo(String cedula, String placa) throws ENoExiste{
		Cliente v = buscarCliente(cedula);
		int i = -1;
		while (++i < v.getVehiculos().length && !v.getVehiculos()[i].getPlaca().equalsIgnoreCase(placa));
		if (i < v.getVehiculos().length && v.getVehiculos()[i].getPlaca().equalsIgnoreCase(placa)) {
			buscarCliente(cedula).eliminarVehiculo(placa);
			guardarFicheros();

		} else {
			throw new ENoExiste("No existe un ");
		}
	}
	
	public String[] mostrarHistorial(String cedula, String placa) throws ENoExiste {//devuelve el historial de un vehiculo
		int j = buscarCliente(cedula).buscarVehiculo(placa).getHistorial().length;
		String[] info = new String[j];
		for (int i = 0; i < j; i++) {
			info[i] = buscarCliente(cedula).buscarVehiculo(placa).getHistorial()[i].mostrar();
		}
		if (info == null || info.length == 0) {
			info = Arrays.copyOf(info, info.length+1);
			info[info.length-1] = "Este vehiculo no tiene historial";
		}
		return info;
		//hacer try catch de no hay cliente con esa cedula, try catch de no hay vehiculo con esa placa y Crear excepcion de no hay historial
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
	
	public void actualizarVehiculo(String placa, int kilometraje, boolean estadoLlantas, boolean limpio) throws ENoExiste {//actualiza la informacion del vehiculo
		buscarVehiculo(placa).setKilometraje(kilometraje);
		buscarVehiculo(placa).setEstadoLlantas(estadoLlantas);
		buscarVehiculo(placa).setLimpio(limpio);
	}
	
	public void cambioAceite (String cedula, String placa, String idMecanico, int kilometraje) throws ENoExiste {// "cambia" el aceite de un vehiculo, para su correcto funcionamiento debe cambiar el kilometrajeUltimaRevision por kilometraje, ademas debe crear un dato tipo historial
		Date date = new Date();		
		String accion = "Cambio de aceite";
		Mecanico mecanico = buscarMecanico(idMecanico);//hacer try catch de no hay mecanico con ese id
		double precio = 50;//escribir esto con if de manera que si es carro sea un precio distinto al de una moto y escribir los precios en ficheros para poderlos cambiar(extra)
		buscarVehiculo(placa).setKilometraje(kilometraje);
		buscarVehiculo(placa).setKilometrajeAceite(kilometraje);
		addHistorial(date, mecanico, accion, precio, cedula, placa);

		guardarFicheros();
	}
	
	public void inflarLlantas (String cedula, String placa,String idMecanico) throws ENoExiste {// "infla" las llantas de un vehiculo, para su correcto funcionamiento debe cambiar el estadoLlantas a true, ademas debe crear un dato tipo historial
		Date date = new Date();		
		String accion = "Inflar llantas";
		Mecanico mecanico = buscarMecanico(idMecanico);//hacer try catch de no hay mecanico con ese id
		double precio= 25;//escribir esto con if de manera que si es carro sea un precio distinto al de una moto
		buscarVehiculo(placa).setEstadoLlantas(true);
		addHistorial(date, mecanico, accion, precio, cedula, placa);

		guardarFicheros();
	}
	
	public void cambioPastas (String cedula, String placa,String idMecanico, int kilometraje) throws ENoExiste {
		Date hoy = Calendar.getInstance().getTime();
		String accion = "Cambio de pastas";
		Mecanico m = buscarMecanico(idMecanico);
		double precio = 50;
		buscarVehiculo(placa).setKilometraje(kilometraje);
		buscarVehiculo(placa).setKilometrajePastas(kilometraje);
		addHistorial(hoy, m, accion, precio, cedula, placa);

		guardarFicheros();
	}
	
	public void lavadoVehiculo (String cedula, String placa, String idMecanico) throws ENoExiste {//para desarrollar este crear atributo en la clase vehiculo que sea un boolean llamado "limpio"
		Date hoy = Calendar.getInstance().getTime();
		String accion = "Lavado";
		Mecanico m = buscarMecanico(idMecanico);
		double precio = 50;
		buscarVehiculo(placa).setLimpio(true);
		addHistorial(hoy, m, accion, precio, cedula, placa);

		guardarFicheros();
	}
	
	public void servicioEspecial (String cedula, String placa, String idMecanico, String accion, double precio) throws ENoExiste {//para desarrollar un servicio no estandarisado con precio y accion variable
		Date hoy = Calendar.getInstance().getTime();
		Mecanico m = buscarMecanico(idMecanico);
		addHistorial(hoy, m, accion, precio, cedula, placa);

		guardarFicheros();
	}
	
	public void cambioPintura (String cedula, String placa, String idMecanico, String color) throws ENoExiste {// "cambia" el color de un vehiculo, para su correcto funcionamiento debe cambiar el color del vehiculo al color nuevo, ademas debe crear un dato tipo historial
		Date date = new Date();		
		String accion = "Cambio de pintura";
		Mecanico mecanico = buscarMecanico(idMecanico);//hacer try catch de no hay mecanico con ese id
		double precio= 100;//escribir esto con if de manera que si es carro sea un precio distinto al de una moto
		buscarVehiculo(placa).setColor(color);//revisar si esto si cambia el dato original en el main
		addHistorial(date, mecanico, accion, precio, cedula, placa);

		guardarFicheros();
	}
	
	public boolean[] diagnostico(String cedula, String placa) throws ENoExiste {//revisa si es necesario o se recomendaria hacer algun servicio al vehiculo en cuestion y devuelve cuales si y cuales no en un vector de booleans
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
	
	public String[] mantenimientoGeneral (String cedula, String placa, String idMecanico) throws ENoExiste {//lee el vector de boolean que devuelve diagnostico y los ejecuta
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
	
	public String[] pagoDeuda(String cedula) throws ENoExiste {//para que un cliente pague su deuda
		string [] info = buscarCliente(cedula).pagoDeuda();
    guardarFicheros();
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
}
