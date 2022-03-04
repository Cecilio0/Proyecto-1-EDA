package taller;

import java.util.Arrays;
import java.util.Date;
import java.io.*;

public class Vehiculo implements Serializable{
	
	protected String placa;
	protected String color;
	protected Historial[] historial;
	protected boolean estado;
	protected int kilometraje;
	protected int kilometrajeAceite;
	protected int kilometrajePastas;
	protected boolean estadoLlantas;
	protected boolean limpio;
	
	//constructor
	public Vehiculo(String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas) {
		this.placa = placa;
		this.color = color;
		this.historial = new Historial[0];
		this.estado = estado;
		this.kilometraje = kilometraje;
		this.kilometrajeAceite = 0;
		this.kilometrajePastas = 0;
		this.estadoLlantas = estadoLlantas;
		this.limpio = false;
	}
	
	//metodos get
	public String getPlaca() {
		return placa;
	}

	public String getColor() {
		return color;
	}

	public Historial[] getHistorial() {
		return historial;
	}

	public boolean isEstado() {
		return estado;
	}
	
	public int getKilometraje() {
		return kilometraje;
	}
	
	public int getKilometrajeAceite() {
		return kilometrajeAceite;
	}

	public int getKilometrajePastas() {
		return kilometrajePastas;
	}

	public boolean isEstadoLlantas() {
		return estadoLlantas;
	}

	//metodos set
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public void setKilometrajeAceite(int kilometrajeAceite) {
		this.kilometrajeAceite = kilometrajeAceite;
	}
	
	public void setKilometrajePastas(int kilometrajePastas) {
		this.kilometrajePastas = kilometrajePastas;
	}

	public void setEstadoLlantas(boolean estadoLlantas) {
		this.estadoLlantas = estadoLlantas;
	}

	public void addHistorial(Date fechaIngreso, Mecanico mecanico, String accion, double precio) {
		historial = Arrays.copyOf(historial, historial.length+1);
		historial[historial.length-1] = new Historial(fechaIngreso, mecanico, accion, precio);
	}

	public boolean isLimpio() {
		return limpio;
	}

	public void setLimpio(boolean limpio) {
		this.limpio = limpio;
	}
}
