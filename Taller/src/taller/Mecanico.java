package taller;

import java.util.*;

public class Mecanico extends Persona {
    private String id;
    private double salario;

    public Mecanico(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, String id, double salario) {
        super(nombre, cedula, fechaNacimiento, direccion, telefono, correo);
        this.id = id;
        this.salario=salario;
    }

    public String getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}