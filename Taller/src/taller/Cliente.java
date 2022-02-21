package taller;

import java.util.*;

public class Cliente extends Persona {
    private Vehiculo[] vehiculos;
    private double deuda;
    private Date fechaRegistro;

    public Cliente(String nombre, String cedula, int edad, String direccion, String telefono, Vehiculo[] vehiculos, String correo, double deuda, Date fechaRegistro) {
        super(nombre, cedula, edad, direccion, telefono, correo);
        this.vehiculos = vehiculos;
        this.deuda = deuda;
        this.fechaRegistro = fechaRegistro;
    }
}