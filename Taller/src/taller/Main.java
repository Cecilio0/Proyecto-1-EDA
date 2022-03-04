package taller;

import java.io.*;
import java.util.*;

import taller.Administrador.ENoExiste;
import taller.Administrador.EYaExiste;


public class Main {
	
	public static void main(String[] args) {
		//hacer ficheros aqui para llamarlos cada vez que se inicie el codigo
		byte condicion = 0;
		Scanner sc = new Scanner (System.in);
		Administrador admin = new Administrador();
		while (condicion != 127) {
			condicion = sc.nextByte();
			
			switch(condicion) {
			case 1://addCliente
				break;
			case 2://eliminarCliente
				break;
			case 3://pagoDeuda
				break;
			case 4://addVehiculo
				break;
			case 5://eliminarVehiculo
				break;
			case 6://mostrarHistorial
				break;
			case 7://addMecanico
				break;
			case 8://eliminarMecanico
				break;
			case 9://mostrarMecanicos
				break;
			case 10://actualizarVehiculo
				break;
			case 11://cambioAceite
				break;
			case 12://inflarLlantas
				break;
			case 13://cambioPastas
				break;
			case 14://lavadoVehiculo
				break;
			case 15://servicioEspecial
				break;
			case 16://cambioPintura
				break;
			case 17://diagnostico
				break;
			case 18://mantenimientoGeneral
				break;
			case 19://calcularNomina
				break;
			case 20://calcularIngresos
				break;
			case 21://calcularUtilidad
				break;
			case 127:
				break;
			default:
				System.out.println("Por favor ingrese una opcion valida");
			}
		}
    sc.close();
  }
}
