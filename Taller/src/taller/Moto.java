package taller;

public class Moto extends Vehiculo {
	
	private int tiempos;

	//constructor
	public Moto(String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int tiempos) {
		super(placa, color, estado, kilometraje, estadoLlantas);
		this.tiempos = tiempos;
	}

	//metodos get
	public int getTiempos() {
		return tiempos;
	}
}
