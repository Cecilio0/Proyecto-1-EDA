package taller;

import java.util.Date;

public class Historial {
    private Date fechaIngreso;
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

    @Override
    public String toString() {
        return "Historial []";
    }

    public int getMes() {
        return fechaDevolucion.getMonth();
    }
}
