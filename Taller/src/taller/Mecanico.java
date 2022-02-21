package taller;

public class Mecanico extends Persona{
    private String id;
    private double salBasico;
    private int diasTrabajados;

    public Mecanico(String nombre, String cedula, int edad, String direccion, String telefono, String correo, String id, double salBasico, int diasTrabajados){
        super(nombre, cedula, edad, direccion, telefono, correo);
        this.id = id;
        this.salBasico = salBasico;
        this.diasTrabajados = diasTrabajados;
    }
}