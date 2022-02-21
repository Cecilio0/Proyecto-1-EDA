package taller;

public class Cliente extends Persona {
    private Vehiculos[] vehiculos;
    private double deuda;
    private Date fechaRegistro;

    public Cliente(String nombre, String cedula, int edad, String direccion, String telefono, Vehiculos[] vehiculos, String correo, double deuda, Date fechaRegistro) {
        super(nombre, cedula, edad, direccion, telefono, correo);
        this.vehiculos = vehiculos;
        this.deuda = deuda;
        this.fechaRegistro = fechaRegistro;
    }
}