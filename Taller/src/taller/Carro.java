package taller;

public class Carro extends Vehiculo{
	
	private int numPuertas;
	private String traccion;
	
	//constructor
	public Carro(String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas, int numPuertas, String traccion) {
		super(placa, color, estado, kilometraje, estadoLlantas);
		this.numPuertas = numPuertas;
		this.traccion = traccion;
	}

	//metodos get
	public int getNumPuertas() {
		return numPuertas;
	}

	public String getTraccion() {
		return traccion;
	}
	
	

}
