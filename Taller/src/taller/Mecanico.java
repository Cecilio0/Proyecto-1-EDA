package taller;

public class Mecanico extends Persona {
    private String id;
    private double salBasico;
    private int diasTrabajados;

    public Mecanico(String nombre, String cedula, int edad, String direccion, String telefono, String correo, String id, double salBasico) {
        super(nombre, cedula, edad, direccion, telefono, correo);
        this.id = id;
        this.salBasico = salBasico;
        this.diasTrabajados = 0;
    }

    public String getId() {
        return id;
    }

    public double getSalBasico() {
        return salBasico;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }
}