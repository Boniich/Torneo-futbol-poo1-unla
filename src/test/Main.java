package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import modelo.Equipo;
import modelo.Estadistica;
import modelo.Jugador;
import modelo.Sistema;
import modelo.Torneo;
import modelo.enums.TipoEquipo;

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

		try {
			System.out.println("Test 2: Intentamos agregar un jugador dos veces (mismo dni)");
			sistema.agregarJugador("Lionel", "Messi", 11111111, LocalDate.of(1987, 6, 24), 1.70, 67, "Delantero", 10);
			System.out.println(sistema.getPersonas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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

			sistema.traerEquipo("EQA").agregarJugador(sistema.traerPersona(11111111));
			sistema.traerEquipo("EQA").agregarJugador(sistema.traerPersona(22222222));
			sistema.traerEquipo("EQA").agregarJugador(sistema.traerPersona(33333333));
			sistema.traerEquipo("EQA").agregarJugador(sistema.traerPersona(44444444));
			sistema.traerEquipo("EQA").agregarJugador(sistema.traerPersona(55555555));
			
			sistema.traerEquipo("EQB").agregarJugador(sistema.traerPersona(66666666));
			sistema.traerEquipo("EQB").agregarJugador(sistema.traerPersona(77777777));
			sistema.traerEquipo("EQB").agregarJugador(sistema.traerPersona(88888888));
			sistema.traerEquipo("EQB").agregarJugador(sistema.traerPersona(99999999));
			sistema.traerEquipo("EQB").agregarJugador(sistema.traerPersona(10101010));
			
			sistema.traerEquipo("EQC").agregarJugador(sistema.traerPersona(12121212));
			sistema.traerEquipo("EQC").agregarJugador(sistema.traerPersona(13131313));
			sistema.traerEquipo("EQC").agregarJugador(sistema.traerPersona(14141414));
			sistema.traerEquipo("EQC").agregarJugador(sistema.traerPersona(15151515));
			sistema.traerEquipo("EQC").agregarJugador(sistema.traerPersona(16161616));
			
			
			sistema.traerEquipo("EQD").agregarJugador(sistema.traerPersona(17171717));
			sistema.traerEquipo("EQD").agregarJugador(sistema.traerPersona(18181818));
			sistema.traerEquipo("EQD").agregarJugador(sistema.traerPersona(19191919));
			sistema.traerEquipo("EQD").agregarJugador(sistema.traerPersona(20202020));
			sistema.traerEquipo("EQD").agregarJugador(sistema.traerPersona(21212121));

			for (Equipo e : sistema.getEquipos()) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 9: intento agregar jugadores repetidos:");
			sistema.traerEquipo("EQA").agregarJugador(sistema.traerPersona(11111111));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		try {
			System.out.println("Test 10: intento agregar un jugador que ya esta en otro equipo:");
			sistema.traerEquipo("EQC").agregarJugador(sistema.traerPersona(66666666));
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

		System.out.println("Test 14: Calculamos la altura promedio de todos los equipos");
		System.out.println("Equipo A " + String.format("%.2f", sistema.traerEquipo(1).calcularAlturaPromedio()));
		System.out.println("Equipo B " + String.format("%.2f", sistema.traerEquipo(2).calcularAlturaPromedio()));
		System.out.println("Equipo C " + String.format("%.2f", sistema.traerEquipo(3).calcularAlturaPromedio()));
		System.out.println("Equipo D " + String.format("%.2f", sistema.traerEquipo(4).calcularAlturaPromedio()));

		try {
			System.out.println("Test 15: Agregamos los equipos al torneo");
			sistema.traerTorneo(1).agregarEquipo(sistema.traerEquipo(1));
			sistema.traerTorneo(1).agregarEquipo(sistema.traerEquipo(2));
			sistema.traerTorneo(1).agregarEquipo(sistema.traerEquipo(3));
			sistema.traerTorneo(1).agregarEquipo(sistema.traerEquipo(4));
			System.out.println(sistema.traerTorneo(1).getEquiposParticipantes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 16: Intentamos agregar un equipo repetido");
			sistema.traerTorneo(1).agregarEquipo(sistema.traerEquipo(1));
			System.out.println(sistema.traerTorneo(1).getEquiposParticipantes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 17: Calculamos el equipo con mayor altura del torneo");
			sistema.traerTorneo(1).traerEquipoConMayorAltura();
			System.out.println(sistema.traerTorneo(1).traerEquipoConMayorAltura());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Test 18: Agregamos partidos al torneo 1");
			sistema.traerTorneo(1).agregarPartido(LocalDate.of(2025, 6, 5), LocalTime.of(10, 0),
					sistema.traerEquipo("EQA"), sistema.traerEquipo("EQB"), "Estadio 1");

			sistema.traerTorneo(1).agregarPartido(LocalDate.of(2025, 6, 7), LocalTime.of(18, 0),
					sistema.traerEquipo("EQC"), sistema.traerEquipo("EQD"), "Estadio 2");

			sistema.traerTorneo(1).agregarPartido(LocalDate.of(2025, 6, 12), LocalTime.of(10, 0),
					sistema.traerEquipo("EQA"), sistema.traerEquipo("EQC"), "Estadio 1");

			sistema.traerTorneo(1).agregarPartido(LocalDate.of(2025, 6, 14), LocalTime.of(18, 0),
					sistema.traerEquipo("EQB"), sistema.traerEquipo("EQD"), "Estadio 2");

			sistema.traerTorneo(1).agregarPartido(LocalDate.of(2025, 6, 19), LocalTime.of(10, 0),
					sistema.traerEquipo("EQA"), sistema.traerEquipo("EQD"), "Estadio 1");

			sistema.traerTorneo(1).agregarPartido(LocalDate.of(2025, 6, 21), LocalTime.of(18, 0),
					sistema.traerEquipo("EQB"), sistema.traerEquipo("EQC"), "Estadio 2");
			System.out.println(sistema.traerTorneo(1).getPartidos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 19: Agregamos estadisticas para torneo 1");

			int ultimoId = sistema.traerTorneo(1).getPartidos().get(sistema.traerTorneo(1).getPartidos().size()-1).getIdPartido();
			for (int idPartido = 1; idPartido <= ultimoId; idPartido++) {
				generarEstadisticaPorJugador(sistema, 1, idPartido, TipoEquipo.LOCAL);
				generarEstadisticaPorJugador(sistema, 1, idPartido, TipoEquipo.VISITA);

			}

			for (int idPartido = 1; idPartido <= ultimoId; idPartido++) {
				System.out.println(sistema.traerTorneo(1).traerPartido(idPartido).getEstadisticas());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 20: Intentamos agregar una estadistica para un jugador dos veces");
			sistema.traerTorneo(1).traerPartido(1).agregarEstadistica(1, 0, 30,
					sistema.traerTorneo(1).traerPartido(1).getEquipoLocal().getJugadores()
					.get(0));


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Test 21: Traemos los partidos por equipo");
		Torneo t = sistema.traerTorneo(1);
		System.out.println(t.traerPartidos(t.traerEquipo(sistema.traerEquipo("EQA"))));
		System.out.println(t.traerPartidos(t.traerEquipo(sistema.traerEquipo("EQB"))));
		System.out.println(t.traerPartidos(t.traerEquipo(sistema.traerEquipo("EQC"))));
		System.out.println(t.traerPartidos(t.traerEquipo(sistema.traerEquipo("EQD"))));
		
		
		System.out.println("Test 22: Calcular puntos por equipos");
		System.out.println("Puntos del equipo A: "+t.calcularPuntosPorEquipo(t.traerEquipo(sistema.traerEquipo("EQA"))));
		System.out.println("Puntos del equipo B: "+t.calcularPuntosPorEquipo(t.traerEquipo(sistema.traerEquipo("EQB"))));
		System.out.println("Puntos del equipo C: "+t.calcularPuntosPorEquipo(t.traerEquipo(sistema.traerEquipo("EQC"))));
		System.out.println("Puntos del equipo D: "+t.calcularPuntosPorEquipo(t.traerEquipo(sistema.traerEquipo("EQD"))));


		System.out.println("Test 23: Generar tabla de posiciones");
		System.out.println(sistema.traerTorneo(1).generarTablaPosiciones());
	
		
	}
	
	
	// - un goleador por partido, un asistidor
	// 1- cantidad de goles del goleador local
	// 2- cantidad de goles del goleador visitante
	// 3- Al momento de generar el jugador debo elegir el goleado y asistente
	// 4- El resto de jugadores deben quedan con 0 goles y 0 asistencias
	
	public static void generarEstadisticaPorJugador(Sistema sistema,int idTorneo, int idPartido, TipoEquipo tipoEquipo) throws Exception {
		
		Random random = new Random();
		int golesGoleador= random.nextInt(3);
		int goles = 0;
		int asistencias = 0;
		int indexGoleador = 0;
		int indexAsistente = 1;
		

		for (int cantidadJugadores = 0; cantidadJugadores < 5; cantidadJugadores++) {

			if (golesGoleador > 0 && indexGoleador == cantidadJugadores) {
				goles = golesGoleador;
			}else if(golesGoleador > 0 && indexAsistente == cantidadJugadores) {
				asistencias = golesGoleador;
			}
			
			Jugador jugador = null;
			if(tipoEquipo == TipoEquipo.LOCAL) {
				jugador = sistema.traerTorneo(idTorneo).traerPartido(idPartido).getEquipoLocal().getJugadores()
				.get(cantidadJugadores);
			}else {
				jugador = sistema.traerTorneo(idTorneo).traerPartido(idPartido).getEquipoVisita().getJugadores()
						.get(cantidadJugadores);
			}
			
			sistema.traerTorneo(idTorneo).traerPartido(idPartido).agregarEstadistica(goles, asistencias, 30,jugador);

			goles = 0;
			asistencias = 0;
		}
	}

}
