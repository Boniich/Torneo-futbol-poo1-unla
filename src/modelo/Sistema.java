package modelo;

import java.time.LocalDate;
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
	
	public boolean agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta) throws Exception {
		
		if(traerJugador(dni) != null) throw new Exception("Error: El jugador ya existe!");
		
		int ultimoId = 1;
		if(jugadores.size() > 0) ultimoId = jugadores.get(jugadores.size()-1).getIdJugador()+1;
		return jugadores.add(new Jugador(ultimoId,nombre,apellido,dni,fechaNacimiento,estatura,peso,
										posicion,numeroCamiseta));
		
	}
	public boolean agregarEntrenador(String nombre, String apellido, long dni,LocalDate fechaNacimiento, String estrategiaFavorita)
			throws Exception{
		
		if(traerEntrenador(dni) != null) throw new Exception("Error: El entrenador ya existe!");
		
		if (estrategiaFavorita == null || estrategiaFavorita.trim().isEmpty()) {
			throw new Exception("Error: El entrenador no tiene estrategia !");
        }
		
		int ultimoId = 1;
		if(entrenadores.size() > 0) ultimoId = entrenadores.get(entrenadores.size()-1).getIdEntrenador()+1;
		return entrenadores.add(new Entrenador(ultimoId,nombre,apellido,dni,fechaNacimiento,estrategiaFavorita));
		
	}
	
	public Entrenador traerEntrenador(long dni) {
		Entrenador entrenador = null;
		int index = 0;
		boolean encontrado = false;

		if (!entrenadores.isEmpty()) {
			while (index < entrenadores.size() && !encontrado) {
				if (entrenadores.get(index).getDni() == dni) {
					encontrado = true;
					entrenador = entrenadores.get(index);
				}

				index++;
			}
		}
		 return entrenador;
	}

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
