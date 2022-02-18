package taller;

public class Moto extends Vehiculo {
	
	private int tiempos;

	//constructor
	public Moto(String modelo, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje, int tiempos) {
		super(modelo, marca, color, ano, automatico, estado, cilindraje);
		this.tiempos = tiempos;
	}

	//metodos get
	public int getTiempos() {
		return tiempos;
	}
}
