package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> personas;
	private List<Equipo> equipos;
	private List<Torneo> torneos;

	public Sistema() {
		this.personas = new ArrayList<Persona>();
		this.equipos = new ArrayList<Equipo>();
		this.torneos = new ArrayList<Torneo>();
	}

	// --- Casos de uso ---
	public List<Equipo> buscarEquiposAntesDe(LocalDate antesDe){
		List<Equipo> e= new ArrayList<Equipo>();
		if (!(antesDe == null)){
			
		for(Equipo i: equipos){
			if (antesDe.isAfter(i.getFechaCreacion())) {
				e.add(i);
			}
		}
		}
		return e;
	}
	//consultar si incluir los extremos
	public List<Jugador> buscarJugadoresEntre(LocalDate desde, LocalDate hasta){
			List<Jugador> j= new ArrayList<Jugador>();
		if (!(desde == null || hasta==null)){
			List<Jugador> jaux= this.listarJugadores();
		for(Jugador i: jaux){
			if (desde.isBefore(i.getFechaNacimiento()) && hasta.isAfter(i.getFechaNacimiento())) {
				j.add(i);
			}
		}
		}
		return j;
	}
	
	public List<Entrenador> buscarEntrenadorPorEstrategia(String estrategia){
		List<Entrenador> e= listarEntrenadores();
		List<Entrenador> encontrados= new ArrayList<Entrenador>();
		for(Entrenador i: e){
			if(i.getEstrategiaFavorita(). equals(estrategia)){
				encontrados.add(i);
			}
		}
		return encontrados;
		
	}
	public void agregarJugadorAEquipo(int dni, int idEquipo) throws Exception{
		Persona j= traerPersona(dni);
		Equipo e= traerEquipo(idEquipo);
	
		if(j==null || !(j instanceof Jugador))throw new Exception("Error:No existe jugador con el dni ingresado.");
		if(e==null)throw new Exception("Error: Equipo no encontrado.");
		if(e.getJugadores().contains(j))throw new Exception("Error: Ya existe en el equipo un jugador con ese dni.");
		verificarJugadorEnOtroEquipo((Jugador)j);
		 e.agregarJugador((Jugador)j);
	}
	public void verificarJugadorEnOtroEquipo(Jugador jugador) throws Exception {
    
    for (Equipo equipo : this.equipos) {
        if (equipo.getJugadores().contains(jugador)) {  throw new Exception("Error: El jugador con DNI " + jugador.getDni() + " ya está registrado en el equipo: " + equipo.getNombre() + ".");
        
    }
}
    
}
	public boolean agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta) throws Exception {
		
		if(traerPersona(dni) != null) throw new Exception("Error: La persona ya existe en el sistema!");
		
		int id = 1;
		if(personas.size() > 0) id  = personas.get(personas.size()-1).getId()+1;
		return personas.add(new Jugador(id ,nombre,apellido,dni,fechaNacimiento,estatura,peso,
										posicion,numeroCamiseta));
		
	}
	public boolean agregarEntrenador(String nombre, String apellido, long dni,LocalDate fechaNacimiento, String estrategiaFavorita)
			throws Exception{
		
		if(traerPersona(dni) != null) throw new Exception("Error: La persona ya existe en el sistema!");
		
		int id = 1;
		if(personas.size() > 0) id = personas.get(personas.size()-1).getId()+1;
		return personas.add(new Entrenador(id,nombre,apellido,dni,fechaNacimiento,estrategiaFavorita));
		
	}
	
	
	public Persona traerPersona(long dni) {
		Persona persona = null;
		int index = 0;
		boolean encontrado = false;

		if (!personas.isEmpty()) {
			while (index < personas.size() && !encontrado) {
				if (personas.get(index).getDni() == dni) {
					encontrado = true;
					persona = personas.get(index);
				}

				index++;
			}
		}
		 return persona;
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
	
	
	public void agregarEquipo(String nombre,String codigo,LocalDate fechaCreacion, Persona persona) throws Exception {
		
		if(persona == null) throw new Exception("Error: El entrenador no existe!");
		if(!(persona instanceof Entrenador))  throw new Exception("Error: La persona no es un entrenador!");

		//Tarea: Agregar if que contrala que un equipo no este repetido. lanzar excepcion
		if (traerEquipo(codigo)!=null)throw new Exception("Error:El equipo ya existe.");
			
		
		int id = 1;
		if(!equipos.isEmpty()) id = equipos.get(equipos.size()-1).getIdEquipo()+1;
		equipos.add(new Equipo(id,nombre,codigo,fechaCreacion,(Entrenador)persona));
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
	
	
	public List<Jugador> listarJugadores(){
		List<Jugador> jugadores = new ArrayList<Jugador>();
		
		for(Persona p: personas) {
			if(p instanceof Jugador) {
				jugadores.add((Jugador)p);
			}
		}
		return jugadores;
	}
	
	public List<Entrenador> listarEntrenadores(){
		List<Entrenador> entrenadores = new ArrayList<Entrenador>();
		
		for(Persona p: personas) {
			if(p instanceof Entrenador) {
				entrenadores.add((Entrenador)p);
			}
		}
		return entrenadores;
	}
	
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
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



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		if (personas == null) {
			if (other.personas != null)
				return false;
		} else if (!personas.equals(other.personas))
			return false;
		if (equipos == null) {
			if (other.equipos != null)
				return false;
		} else if (!equipos.equals(other.equipos))
			return false;
		if (torneos == null) {
			if (other.torneos != null)
				return false;
		} else if (!torneos.equals(other.torneos))
			return false;
		return true;
	}

}
