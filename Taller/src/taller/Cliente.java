package taller;

import java.util.*;

public class Cliente extends Persona {
    private Vehiculo[] vehiculos;
    private double deuda;
    private Date fechaRegistro;

    public Cliente(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, Vehiculo[] vehiculos, String correo, Date fechaRegistro) {
        super(nombre, cedula, fechaNacimiento, direccion, telefono, correo);
        this.vehiculos = vehiculos;
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

}