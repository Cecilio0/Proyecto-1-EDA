package taller;

import java.util.*;
import java.io.*;

public class Mecanico extends Persona implements Serializable {
    private String id;
    private double salario;
    private Date fechaSalida;

    public Mecanico(String nombre, String cedula, Date fechaNacimiento, String direccion, String telefono, String correo, String id, double salario) {
        super(nombre, cedula, fechaNacimiento, direccion, telefono, correo);
        this.id = id;
        this.salario=salario;
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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}