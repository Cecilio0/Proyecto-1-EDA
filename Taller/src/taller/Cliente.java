package taller;

import java.util.*;

public class Cliente extends Persona {
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

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void eliminarVehiculo(String placa) {
    	int index = 0;
    	while (index < vehiculos.length && vehiculos[index]!= null && !vehiculos[index].getPlaca().equals(placa)) {
    		index++;
    	}
    	if (index < vehiculos.length && vehiculos[index]!= null && vehiculos[index].getPlaca().equals(placa)) {
    		Vehiculo[] vehiculosRestantes = new Vehiculo[vehiculos.length-1];
    		System.arraycopy(vehiculos, 0, vehiculosRestantes, 0, index);
    		System.arraycopy(vehiculos, index+1, vehiculosRestantes, index, vehiculos.length-index-1);
    		vehiculos = vehiculosRestantes;
    	}
    }
//	buscar Vehiculo
	public Vehiculo buscarVehiculo(String placa) {
		int num=vehiculos.length;
		for(int i =0; i<vehiculos.length; i++) {
			if(placa==vehiculos[i].getPlaca()) {
				num=i;
				i=vehiculos.length;
			}
		}
		if(num==vehiculos.length) {
			return null;
		} else return vehiculos[num];
	}
}