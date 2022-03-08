package taller;

import java.io.Serial;
import java.util.*;
import java.io.*;


public class Cliente extends Persona implements Serializable {
    private Vehiculo[] vehiculos;
    private Date fechaRegistro;

    public Cliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro) {
        super(nombre, cedula, fechaNacimiento, direccion, telefono, correo);
        vehiculos = new Vehiculo[0];
        this.fechaRegistro = fechaRegistro;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }
  
    public double getDeuda() {
        return calcularDeuda();
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    // addVehiculo || carro
    public void addVehiculo(String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion) {
    	vehiculos  = Arrays.copyOf(vehiculos, vehiculos.length+1);
    	vehiculos[vehiculos.length-1] = new Carro(placa, color, estado, kilometraje, estadoLlantas, numPuertas, traccion);
    }
    
    // addVehiculo || moto
    public void addVehiculo(String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos) {
    	vehiculos  = Arrays.copyOf(vehiculos, vehiculos.length+1);
    	vehiculos[vehiculos.length-1] = new Moto(placa, color, estado, kilometraje, estadoLlantas, tiempos);
    }
    
    public void eliminarVehiculo(String placa) {
    	int index = 0;
    	while (index < vehiculos.length && vehiculos[index]!= null && !vehiculos[index].getPlaca().equalsIgnoreCase(placa)) {
    		index++;
    	}
    	//poner un IgnoreCase
    	if (index < vehiculos.length && vehiculos[index]!= null && vehiculos[index].getPlaca().equalsIgnoreCase(placa)) {
    		Vehiculo[] vehiculosRestantes = new Vehiculo[vehiculos.length-1];
    		System.arraycopy(vehiculos, 0, vehiculosRestantes, 0, index);
    		System.arraycopy(vehiculos, index+1, vehiculosRestantes, index, vehiculos.length-index-1);
    		vehiculos = vehiculosRestantes;
    	}
    }
    
    //buscar Vehiculo
	public Vehiculo buscarVehiculo(String placa) {
		int i = 0;
		while (i < vehiculos.length && vehiculos[i] != null && !vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
			i++;
		}
		if (i < vehiculos.length && vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
			return vehiculos[i];
		} else {
			return null;
		}
	}
	
	public double calcularDeuda() {
		double deudaTotal = 0; 
		for (int i = 0; i < vehiculos.length; i++) {
			for (int j = 0; j < vehiculos[i].getHistorial().length; j++) {
				if (!vehiculos[i].getHistorial()[j].isPagada()) {
					deudaTotal += vehiculos[i].getHistorial()[j].getPrecio();
				}
			}
		}
		return deudaTotal;
	}
	
	public String[] pagoDeuda() {//paga toda la deuda del cliente y convierte todos los historiales no pagos a pagos
		for (int i = 0; i < vehiculos.length; i++) {
			vehiculos[i].setEstado(true);//permite retirar el vehiculo del taller
		}
		return factura();
	}
	
	public String[] factura() {
		double total = 0;
		String [] infoFactura = new String [0];
		for(int i = 0; i< vehiculos.length; i++) {
			for(int j = 0; j< vehiculos[i].getHistorial().length; j++) {
				if(!vehiculos[i].getHistorial()[j].isPagada()) {
					total+= vehiculos[i].getHistorial()[j].getPrecio();
					infoFactura = Arrays.copyOf(infoFactura, infoFactura.length+1);
					infoFactura[infoFactura.length-1] = vehiculos[i].getHistorial()[j].mostrar();
					vehiculos[i].getHistorial()[j].setPagada(true);
				}
			}
		}
		infoFactura = Arrays.copyOf(infoFactura, infoFactura.length+1);
		infoFactura[infoFactura.length-1] = "Total: " + total;
		return infoFactura;
	}
}