package taller;

import java.io.Serial;
import java.util.Date;
import java.io.*;

public class Historial implements Serializable {
    private Date fechaIngreso;//revisar si es mejor borrar este dato para no tener que ingresar un dato de tipo Date
    private Date fechaDevolucion;
    private Mecanico mecanico;
    private String accion;
    private double precio;
    private boolean pagada;

    public Historial(Date fechaIngreso, Mecanico mecanico, String accion, double precio) {
        this.fechaIngreso = fechaIngreso;
        this.fechaDevolucion = new Date();
        this.mecanico = mecanico;
        this.accion = accion;
        this.precio = precio;
        this.pagada = false;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public String getAccion() {
        return accion;
    }
    
    public boolean isPagada() {
    	return pagada;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void setPagada(boolean pagada) {
    	this.pagada = pagada;
    }

    public String mostrar() {
        return "Servicio: " + accion + "   Precio: " + precio + "   Fecha: " + fechaDevolucion.toString();
    }

    public int getMes() {
        return fechaDevolucion.getMonth();
    }
}
