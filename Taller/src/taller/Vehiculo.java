package taller;

import java.util.Arrays;
import java.util.Date;

public class Vehiculo {
	
	protected String placa;
	protected String color;
	protected Historial[] historial;
	protected boolean estado;
	protected int kilometraje;
	protected int kilometrajeUltimaRevision;//hacer cambio de kilometrajeUltimaRevision a kilometrajePastas y kilometrajeAceite los cuales corresponden al kilometraje de la ultima vez que se cambiaron
	protected boolean estadoLlantas;
	
	//constructor
	public Vehiculo(String placa, String color, boolean estado, int kilometraje, boolean estadoLlantas) {
		this.placa = placa;
		this.color = color;
		this.historial = new Historial[0];
		this.estado = estado;
		this.kilometraje = kilometraje;
		this.kilometrajeUltimaRevision = 0;
		this.estadoLlantas = estadoLlantas;
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

	public int getKilometrajeUltimaRevision() {
		return kilometrajeUltimaRevision;
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

	public void setKilometrajeUltimaRevision(int kilometrajeUltimaRevision) {
		this.kilometrajeUltimaRevision = kilometrajeUltimaRevision;
	}

	public void setEstadoLlantas(boolean estadoLlantas) {
		this.estadoLlantas = estadoLlantas;
	}

	public void addHistorial(Date fechaIngreso, Mecanico mecanico, String accion, double precio) {
		historial = Arrays.copyOf(historial, historial.length+1);
		historial[historial.length-1] = new Historial(fechaIngreso, mecanico, accion, precio);
	}
	
	
}
