package taller;

import java.util.Arrays;
import java.util.Date;

public class Vehiculo {
	
	protected String placa;
	protected String marca;
	protected String color;
	protected Historial[] historial;
	protected int ano;
	protected boolean automatico;
	protected boolean estado;
	protected int cilindraje;
	
	//constructor
	public Vehiculo(String placa, String marca, String color, int ano, boolean automatico, boolean estado, int cilindraje) {
		this.placa = placa;
		this.marca = marca;
		this.color = color;
		this.historial = new Historial[0];
		this.ano = ano;
		this.automatico = automatico;
		this.estado = estado;
		this.cilindraje = cilindraje;
	}
	
	//metodos get
	public String getPlaca() {
		return placa;
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
	
	public void addHistorial(Date fechaIngreso, Date fechaDevolucion, Mecanico mecanico, String accion, double precio) {
		historial = Arrays.copyOf(historial, historial.length+1);
		historial[historial.length-1] = new Historial(fechaIngreso, fechaDevolucion, mecanico, accion, precio);
	}
	
	
}
