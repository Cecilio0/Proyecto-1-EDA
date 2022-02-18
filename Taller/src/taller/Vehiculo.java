package taller;

public class Vehiculo {
	
	protected String modelo;
	protected String marca;
	protected String color;
	protected Historial[] historial;
	protected int ano;
	protected boolean automatico;
	protected boolean estado;
	protected int cilindraje;
	
	//constructor
	public Vehiculo(String modelo, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje) {
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.historial = new Historial[0];
		this.ano = ano;
		this.automatico = automatico;
		this.estado = estado;
		this.cilindraje = cilindraje;
	}
	
	//metodos get
	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getColor() {
		return color;
	}

	public Historial[] getHistorial() {
		return historial;
	}

	public int getAno() {
		return ano;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public boolean isEstado() {
		return estado;
	}

	public int getCilindraje() {
		return cilindraje;
	}
	
	//metodos set
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
