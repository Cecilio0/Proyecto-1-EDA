package taller;

import java.util.Date;

public class Historial {
	

		private Date fechaIngreso;
		private Date fechaDevolucion;
		private Mecanico mecanico;
		private String accion;
		private double precio;

		public Historial(Date fechaIngreso, Mecanico mecanico, String accion, double precio) {
			this.fechaIngreso = fechaIngreso;
			this.fechaDevolucion = new Date();
			this.mecanico = mecanico;
			this.accion = accion;
			this.precio = precio;
		}

		public Date getFechaIngreso() {
			return fechaIngreso;
		}

		public Date getFechaDevolucion() {
			return fechaDevolucion;
		}
		public Mecanico getMecanico() {
			return mecanico;
		}

		public String getAccion() {
			return accion;
		}

		public void setAccion(String accion) {
			this.accion = accion;
		}

		public double getPrecio() {
			return precio;
		}

		@Override
		public String toString() {
			return "Historial []";
		}

}
