package taller;

import java.util.*;
import java.io.*;

public class Mecanico extends Persona implements Serializable {
    private String id;
    private double salario;
    private Date fechaIngreso, fechaSalida;

    public Mecanico(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, String id, double salario) {
        super(nombre, cedula, fechaNacimiento, direccion, telefono, correo);
        this.id = id;
        this.salario=salario;
        fechaIngreso = Calendar.getInstance().getTime();
        fechaSalida = null;
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}