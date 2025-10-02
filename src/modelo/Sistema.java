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
	
	
	public boolean agregarTorneo(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
		int id = 1;
		if(!torneos.isEmpty()) id = torneos.get(torneos.size()-1).getIdTorneo()+1;
		return torneos.add(new Torneo(id,nombre,temporada,fechaInicio,fechaFin));
	}
	
	public Torneo traerTorneo(int id) {
		Torneo torneoBuscado = null;
		int index = 0;
		boolean encontrado = false;
		if (!torneos.isEmpty()) {
			while (index < torneos.size() && !encontrado) {
				if (torneos.get(index).getIdTorneo() == id) {
					encontrado = true;
					torneoBuscado = torneos.get(index);
				}

				index++;
			}
		}

		return torneoBuscado;
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
	//-------------------------Equipo---------------------------------------------------------------------
	public void agregarEquipo(  String nombre, long dniEntrenador) throws Exception {
		int id = 1;
		Entrenador entrenador= traerEntrenador(dniEntrenador);
		if(entrenador==null)throw new Exception("Error: Entrenador inexistente");
		String codigo= crearCodigo(nombre);
		if(!equipos.isEmpty()){
			id = equipos.get(equipos.size()-1).getIdEquipo()+1;
		} 
		 equipos.add(new Equipo(id,codigo,nombre,entrenador));
	}
	
	public Equipo traerEquipo(int id) {
		Equipo equipoBuscado = null;
		int index = 0;
		boolean encontrado = false;
		if (!equipos.isEmpty()) {
			while (index < equipos.size() && !encontrado) {
				if (equipos.get(index).getIdEquipo() == id) {
					encontrado = true;
					equipoBuscado = equipos.get(index);
				}

				index++;
			}
		}

		return equipoBuscado;
	}
	public Equipo traerEquipo(String codigo) {
		Equipo equipoBuscado = null;
		int index = 0;
		boolean encontrado = false;
		if (!equipos.isEmpty()) {
			while (index < equipos.size() && !encontrado) {
				if (equipos.get(index).getCodigo().equals(codigo.toUpperCase())) {
					encontrado = true;
					equipoBuscado = equipos.get(index);
				}

				index++;
			}
		}

		return equipoBuscado;
	}
	public void eliminarEquipo(String codigo) throws Exception{
		Equipo e= traerEquipo(codigo);
		if (e == null)throw new Exception("Error: equipo no encontrado");
		equipos.remove(e);
	}
	//falta editar
	public String crearCodigo(String nombre){
		String codigo=nombre.substring(0, 3).toUpperCase();
		return codigo;

	}
	public boolean isCodigoExiste( String codigo){
		int index = 0;
		boolean encontrado = false;
		if (!equipos.isEmpty()) {
			while (index < equipos.size() && !encontrado) {
				if (equipos.get(index).getCodigo().equals(codigo)) {
					encontrado = true;
				}

				index++;
			}
		}
		return encontrado;
	}

	
//---------------------------FinEquipo--------------------------------------------------------------------
}
