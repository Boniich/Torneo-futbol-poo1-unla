package test;

import java.time.LocalDate;

import modelo.Equipo;
import modelo.Sistema;

public class Main {

	public static void main(String[] args) {

		Sistema sistema = new Sistema();

		try {
			System.out.println("Test 1: Agregamos jugadores con exito");
			sistema.agregarJugador("Lionel", "Messi", 11111111, LocalDate.of(1987, 6, 24), 1.70, 67, "Delantero", 10);
			sistema.agregarJugador("Rodrigo", "De Paul", 22222222, LocalDate.of(1994, 5, 24), 1.80, 72, "Mediocampista",
					7);
			sistema.agregarJugador("Cristian", "Romero", 33333333, LocalDate.of(1998, 4, 27), 1.85, 80, "Defensor", 17);
			sistema.agregarJugador("Nicolas", "Otamendi", 44444444, LocalDate.of(1998, 4, 27), 1.83, 81, "Defensor",
					30);
			sistema.agregarJugador("Emiliano", "Martinez", 55555555, LocalDate.of(1998, 4, 27), 1.95, 88, "Portero",
					23);

			sistema.agregarJugador("Julian", "Alvarez", 66666666, LocalDate.of(2000, 1, 31), 1.70, 70, "Delantero", 19);
			sistema.agregarJugador("Alexis", "Mac Allister", 77777777, LocalDate.of(1998, 12, 24), 1.76, 73,
					"Mediocampista", 20);
			sistema.agregarJugador("Nahuel", "Molina", 88888888, LocalDate.of(1998, 4, 6), 1.75, 70, "Defensor", 26);
			sistema.agregarJugador("Marcos", "Acuña", 99999999, LocalDate.of(1991, 10, 28), 1.72, 69, "Defensor", 8);
			sistema.agregarJugador("Franco", "Armani", 10101010, LocalDate.of(1998, 4, 6), 1.89, 88, "Portero", 1);

			sistema.agregarJugador("Lautaro", "Martinez", 12121212, LocalDate.of(1997, 8, 22), 1.74, 72, "Delantero",
					9);
			sistema.agregarJugador("Nicolas", "Tagliafico", 13131313, LocalDate.of(1992, 8, 31), 1.72, 70, "Defensor",
					3);
			sistema.agregarJugador("Gonzalo", "Montiel", 14141414, LocalDate.of(1997, 1, 1), 1.76, 70, "Defensor", 4);
			sistema.agregarJugador("Enzo", "Fernandez", 15151515, LocalDate.of(2001, 1, 17), 1.78, 75, "Mediocampista",
					24);
			sistema.agregarJugador("Geronimo", "Rulli", 16161616, LocalDate.of(1992, 5, 20), 1.89, 84, "Portero", 12);

			sistema.agregarJugador("Angel", "Di Maria", 17171717, LocalDate.of(1988, 2, 14), 1.80, 70, "Delantero", 11);
			sistema.agregarJugador("Leandro", "Paredes", 18181818, LocalDate.of(1994, 6, 29), 1.82, 75, "Mediocampista",
					5);
			sistema.agregarJugador("Juan", "Foyth", 19191919, LocalDate.of(1998, 1, 15), 1.82, 79, "Defensor", 14);
			sistema.agregarJugador("Leonardo", "Balerdi", 20202020, LocalDate.of(1999, 1, 26), 1.87, 80, "Defensor", 5);
			sistema.agregarJugador("Walter", "Benitez", 21212121, LocalDate.of(1993, 1, 19), 1.91, 88, "Portero", 12);
			System.out.println(sistema.listarJugadores());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Intentamos agregar un jugador dos veces o con mismo dni
		try {
			System.out.println("Test 2: Intentamos agregar un jugador dos veces (mismo dni)");
			sistema.agregarJugador("Lionel", "Messi", 11111111, LocalDate.of(1987, 6, 24), 1.70, 67, "Delantero", 10);
			System.out.println(sistema.getPersonas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Intentamos agregar un jugador que sea menor de edad
		try {
			System.out.println("Test 3: Intentamos agregar un jugador menor de edad");
			sistema.agregarJugador("Juancito", "hernandez", 31659781, LocalDate.of(2018, 3, 5), 1.80, 80, "Arquero", 1);
			System.out.println(sistema.getPersonas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 4: Agregamos entrenadores");
			sistema.agregarEntrenador("Lionel", "Scaloni", 23232323, LocalDate.of(1978, 5, 16), "Estrategia ofensiva");
			sistema.agregarEntrenador("Marcelo", "Gallardo", 24242424, LocalDate.of(1976, 1, 18),
					"Estrategia ofensiva");
			sistema.agregarEntrenador("Diego", "Martinez", 25252525, LocalDate.of(1978, 11, 16),
					"Estrategia defensiva");
			sistema.agregarEntrenador("Ricardo", "Gareca", 26262626, LocalDate.of(1958, 2, 10), "Estrategia defensiva");
			System.out.println(sistema.listarEntrenadores());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 5: Agregamos Equipos");
			sistema.agregarEquipo("Equipo A", "EQA", LocalDate.of(2024, 10, 7), sistema.traerPersona(23232323));
			sistema.agregarEquipo("Equipo B", "EQB", LocalDate.of(2024, 10, 8), sistema.traerPersona(24242424));
			sistema.agregarEquipo("Equipo C", "EQC", LocalDate.of(2023, 10, 10), sistema.traerPersona(25252525));
			sistema.agregarEquipo("Equipo D", "EQD", LocalDate.of(2024, 10, 15), sistema.traerPersona(26262626));
			System.out.println(sistema.getEquipos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 6: Intentamos agregar un equipo con codigo incorrecto");
			sistema.agregarEquipo("Equipo A", "EQAIII", LocalDate.of(2024, 10, 7), sistema.traerPersona(23232323));
			System.out.println(sistema.getEquipos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 7: Intentamos agregar un equipo repetido (Completar)");
			// sistema.agregarEquipo("Equipo A", "EQA",LocalDate.of(2024, 10,
			// 7),sistema.traerPersona(23232323));
			// System.out.println(sistema.getEquipos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 8: Agregamos 5 jugadores para cada equipo");

			// Equipo A
			sistema.agregarJugadorAEquipo(11111111, 1);
			sistema.agregarJugadorAEquipo(22222222, 1);
			sistema.agregarJugadorAEquipo(33333333, 1);
			sistema.agregarJugadorAEquipo(44444444, 1);
			sistema.agregarJugadorAEquipo(55555555, 1);

			//Equipo B
			sistema.agregarJugadorAEquipo(66666666, 2);
			sistema.agregarJugadorAEquipo(77777777, 2);
			sistema.agregarJugadorAEquipo(88888888, 2);
			sistema.agregarJugadorAEquipo(99999999, 2);
			sistema.agregarJugadorAEquipo(10101010, 2);
			
			//Equipo C
			sistema.agregarJugadorAEquipo(12121212, 3);
			sistema.agregarJugadorAEquipo(13131313, 3);
			sistema.agregarJugadorAEquipo(14141414, 3);
			sistema.agregarJugadorAEquipo(15151515, 3);
			sistema.agregarJugadorAEquipo(16161616, 3);
			
			//Equipo D
			sistema.agregarJugadorAEquipo(17171717, 4);
			sistema.agregarJugadorAEquipo(18181818, 4);
			sistema.agregarJugadorAEquipo(19191919, 4);
			sistema.agregarJugadorAEquipo(20202020, 4);
			sistema.agregarJugadorAEquipo(21212121, 4);
			
			for(Equipo e: sistema.getEquipos()) {
				System.out.println(e);
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			System.out.println("Test 9: intento agregar jugadores repetidos:");
			sistema.agregarJugadorAEquipo(15151515, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("Test 10: intento agregar un jugador que ya esta en otro equipo:");
			sistema.agregarJugadorAEquipo(15151515, 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("Test 11: Agregamos torneos");
			sistema.agregarTorneo("Torneo 3 estrellas", "Invierno", LocalDate.of(2025, 5, 25),
					LocalDate.of(2025, 7, 2));
			System.out.println(sistema.getTorneos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 12: Intentamos agregar un torneo con la misma fecha de inicio y fin");
			sistema.agregarTorneo("Torneo la bocha", "Invierno", LocalDate.of(2025, 7, 25), LocalDate.of(2025, 7, 25));
			System.out.println(sistema.getTorneos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 13: Intentamos agregar un torneo con una fecha de inicio posterior a la de fin");
			sistema.agregarTorneo("Torneo la bocha", "Invierno", LocalDate.of(2025, 9, 25), LocalDate.of(2025, 7, 25));
			System.out.println(sistema.getTorneos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
