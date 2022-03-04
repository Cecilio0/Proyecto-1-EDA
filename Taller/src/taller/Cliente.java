package taller;

import java.io.Serial;
import java.util.*;
import java.io.*;

public class Cliente extends Persona implements Serializable {
    private Vehiculo[] vehiculos;
    private double deuda;
    private Date fechaRegistro;

    public Cliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, Date fechaRegistro) {
        super(nombre, cedula, fechaNacimiento, direccion, telefono, correo);
        vehiculos = new Vehiculo[0];
        this.fechaRegistro = fechaRegistro;
        this.deuda = 0;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }
  
    public double getDeuda() {
        return deuda;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setDeuda(double deuda) {
        this.deuda = deuda;
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
    	while (index < vehiculos.length && vehiculos[index]!= null && !vehiculos[index].getPlaca().equals(placa)) {
    		index++;
    	}
    	//poner un IgnoreCase
    	if (index < vehiculos.length && vehiculos[index]!= null && vehiculos[index].getPlaca().equals(placa)) {
    		Vehiculo[] vehiculosRestantes = new Vehiculo[vehiculos.length-1];
    		System.arraycopy(vehiculos, 0, vehiculosRestantes, 0, index);
    		System.arraycopy(vehiculos, index+1, vehiculosRestantes, index, vehiculos.length-index-1);
    		vehiculos = vehiculosRestantes;
    	}
    }
    
    //buscar Vehiculo
	public Vehiculo buscarVehiculo(String placa) {
		int num=vehiculos.length;
		for(int i =0; i<vehiculos.length; i++) {
			if(vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
				num=i;
				i=vehiculos.length;
			}
		}
		if(num==vehiculos.length) {
			return null;
		} else return vehiculos[num];
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
		deuda = 0;
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
					infoFactura[infoFactura.length-1] = vehiculos[i].getHistorial()[j].toString();
					vehiculos[i].getHistorial()[j].setPagada(true);
				}
			}
		}
		infoFactura = Arrays.copyOf(infoFactura, infoFactura.length+1);
		infoFactura[infoFactura.length-1] = "Total: " + total;
		return infoFactura;
	}
}