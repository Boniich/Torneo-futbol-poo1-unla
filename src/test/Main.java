package test;

import java.time.LocalDate;

import modelo.Sistema;

public class Main {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		//Caso de uso: Agregar jugadores al sistema
		
		//Agregamos jugador con exito
		try {
			LocalDate fechaNacimiento = LocalDate.of(1987, 6, 24);
			boolean agregado = sistema.agregarJugador("Lionel", "Messi", 11111,fechaNacimiento, 1.70, 67, "Delantero", 10);
			System.out.println("El jugador fue agreado? "+agregado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Agregamos otro jugador con exito
		try {
			LocalDate fechaNacimiento = LocalDate.of(2000,12,2);
			boolean agregado = sistema.agregarJugador("Pepito", "Montez", 3612648,fechaNacimiento, 1.50, 60, "Centro", 5);
			System.out.println("El jugador fue agreado? "+agregado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		//Intentamos agregar un jugador dos veces o con mismo dni
		try {
			LocalDate fechaNacimiento = LocalDate.of(1987, 6, 24);
			boolean agregado = sistema.agregarJugador("Lionel", "Messi", 11111,fechaNacimiento, 1.70, 67, "Delantero", 10);
			System.out.println("El jugador fue agreado? "+agregado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Intentamos agregar un jugador que sea menor de edad
		try {
			LocalDate fechaNacimiento = LocalDate.of(2018, 3, 5);
			boolean agregado = sistema.agregarJugador("Juancito", "hernandez", 66666,fechaNacimiento, 1.80, 80, "Arquero", 1);
			System.out.println("El jugador fue agreado? "+agregado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		

	}

}
