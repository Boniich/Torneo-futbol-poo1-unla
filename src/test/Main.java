package test;

import java.time.LocalDate;

import modelo.Sistema;

public class Main {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		//Caso de uso: Agregar jugadores al sistema
		
		//Agregamos jugador con exito
		try {
			System.out.println("Test 1: Agregamos jugadores con exito");
			sistema.agregarJugador("Lionel", "Messi", 40321658,LocalDate.of(1987, 6, 24), 1.70, 67, 
					"Delantero", 10);
			sistema.agregarJugador("Pepito", "Montez", 36126489,LocalDate.of(2000,12,2), 1.50, 60, 
					"Centro", 5);
			System.out.println(sistema.getJugadores());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		//Intentamos agregar un jugador dos veces o con mismo dni
		try {
			System.out.println("Test 2: Intentamos agregar un jugador dos veces (mismo dni)");
			sistema.agregarJugador("Lionel", "Messi", 40321658,LocalDate.of(1987, 6, 24), 1.70, 67,
					"Delantero", 10);
			System.out.println(sistema.getJugadores());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Intentamos agregar un jugador que sea menor de edad
		try {
			System.out.println("Test 3: Intentamos agregar un jugador menor de edad");
			sistema.agregarJugador("Juancito", "hernandez", 31659781,LocalDate.of(2018, 3, 5), 1.80, 80,
					"Arquero", 1);
			System.out.println(sistema.getJugadores());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 4: Agregamos torneos");
			sistema.agregarTorneo("Torneo corto", "Invierno", LocalDate.of(2025, 5, 25),LocalDate.of(2025, 7, 2));
			sistema.agregarTorneo("Torneo corto", "Primavera", LocalDate.of(2025, 9, 21),LocalDate.of(2025, 12, 21));
			System.out.println(sistema.getTorneos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 5: Intentamos agregar un torneo con la misma fecha de inicio y fin");
			sistema.agregarTorneo("Torneo la bocha", "Invierno", LocalDate.of(2025, 7, 25),LocalDate.of(2025, 7, 25));
			System.out.println(sistema.getTorneos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 6: Intentamos agregar un torneo con una fecha de inicio posterior a la de fin");
			sistema.agregarTorneo("Torneo la bocha", "Invierno", LocalDate.of(2025, 9, 25),LocalDate.of(2025, 7, 25));
			System.out.println(sistema.getTorneos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		


	}

}
