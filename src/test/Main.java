package test;

import java.time.LocalDate;

import modelo.Sistema;

public class Main {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		try {
			System.out.println("Test 1: Agregamos jugadores con exito");
			sistema.agregarJugador("Lionel", "Messi", 11111111,LocalDate.of(1987, 6, 24), 1.70, 67, "Delantero", 10);
			sistema.agregarJugador("Rodrigo", "De Paul", 22222222,LocalDate.of(1994, 5, 24),  1.80, 72, "Mediocampista", 7);
			sistema.agregarJugador("Cristian", "Romero", 33333333, LocalDate.of(1998, 4, 27), 1.85, 80, "Defensor", 17);
			sistema.agregarJugador("Nicolas", "Otamendi", 44444444, LocalDate.of(1998, 4, 27), 1.83, 81, "Defensor", 30);
			sistema.agregarJugador("Emiliano", "Martinez", 55555555, LocalDate.of(1998, 4, 27), 1.95, 88, "Portero", 23);

			sistema.agregarJugador("Julian", "Alvarez", 66666666, LocalDate.of(2000, 1, 31), 1.70, 70, "Delantero", 19);
			sistema.agregarJugador("Alexis", "Mac Allister", 77777777, LocalDate.of(1998, 12, 24), 1.76, 73, "Mediocampista", 20);
			sistema.agregarJugador("Nahuel", "Molina", 88888888, LocalDate.of(1998, 4, 6), 1.75, 70, "Defensor", 26);
			sistema.agregarJugador("Marcos", "Acuña", 99999999, LocalDate.of(1991, 10, 28), 1.72, 69, "Defensor", 8);
			sistema.agregarJugador("Franco", "Armani", 10101010, LocalDate.of(1998, 4, 6), 1.89, 88, "Portero", 1);

			sistema.agregarJugador("Lautaro", "Martinez", 12121212, LocalDate.of(1997, 8, 22), 1.74, 72, "Delantero", 9);
			sistema.agregarJugador("Nicolas", "Tagliafico", 13131313, LocalDate.of(1992, 8, 31), 1.72, 70, "Defensor", 3);
			sistema.agregarJugador("Gonzalo", "Montiel", 14141414, LocalDate.of(1997, 1, 1), 1.76, 70, "Defensor", 4);
			sistema.agregarJugador("Enzo", "Fernandez", 15151515, LocalDate.of(2001, 1, 17), 1.78, 75, "Mediocampista", 24);
			sistema.agregarJugador("Geronimo", "Rulli", 16161616, LocalDate.of(1992, 5, 20), 1.89, 84, "Portero", 12);

			sistema.agregarJugador("Angel", "Di Maria", 17171717, LocalDate.of(1988, 2, 14), 1.80, 70, "Delantero", 11);
			sistema.agregarJugador("Leandro", "Paredes", 18181818, LocalDate.of(1994, 6, 29), 1.82, 75, "Mediocampista", 5);
			sistema.agregarJugador("Juan", "Foyth", 19191919, LocalDate.of(1998, 1, 15), 1.82, 79, "Defensor", 14);
			sistema.agregarJugador("Leonardo", "Balerdi", 20202020, LocalDate.of(1999, 1, 26), 1.87, 80, "Defensor", 5);
			sistema.agregarJugador("Walter", "Benitez", 21212121, LocalDate.of(1993, 1, 19), 1.91, 88, "Portero", 12);
			System.out.println(sistema.getJugadores());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
/*
		//Intentamos agregar un jugador dos veces o con mismo dni
		try {
			System.out.println("Test 2: Intentamos agregar un jugador dos veces (mismo dni)");
			sistema.agregarJugador("Lionel", "Messi", 11111111,LocalDate.of(1987, 6, 24), 1.70, 67,
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
		
*/

	}

}
