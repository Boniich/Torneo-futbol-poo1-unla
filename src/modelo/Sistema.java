package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Entrenador> entrenadores;
	private List<Jugador> jugadores;
	private List<Equipo> equipos;
	private List<Torneo> torneos;

	public Sistema() {
		this.entrenadores = new ArrayList<Entrenador>();
		this.jugadores = new ArrayList<Jugador>();
		this.equipos = new ArrayList<Equipo>();
		this.torneos = new ArrayList<Torneo>();
	}

	// --- Casos de uso ---

	public Jugador traerJugador(long dni) {
		Jugador jugador = null;
		int index = 0;
		boolean encontrado = false;

		if (!jugadores.isEmpty()) {
			while (index < jugadores.size() && !encontrado) {
				if (jugadores.get(index).getDni() == dni) {
					encontrado = true;
					jugador = jugadores.get(index);
				}

				index++;
			}
		}

		return jugador;
	}

	public List<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}

}
