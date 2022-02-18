package taller;

public class Carro extends Vehiculo{
	
	private int numPuertas;
	private String traccion;
	
	//constructor
	public Carro(String modelo, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje, int numPuertas, String traccion) {
		super(modelo, marca, color, ano, automatico, estado, cilindraje);
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
