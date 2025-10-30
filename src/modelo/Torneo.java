package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.clasesAuxiliares.Asistencia;
import modelo.clasesAuxiliares.Ganador;
import modelo.clasesAuxiliares.Goleador;
import modelo.clasesAuxiliares.Posicion;

public class Torneo {
    private int idTorneo;
    private String nombre;
    private String temporada;
    private List<Equipo> equiposParticipantes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Partido> partidos;

    

    public Torneo(int idTorneo, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        this.idTorneo = idTorneo;
        this.setNombre(nombre);
        this.setTemporada(temporada);
        this.equiposParticipantes = new ArrayList<>();
        this.setFechaInicio(fechaInicio);
        this.setFechaFin(fechaFin);
        this.partidos = new ArrayList<>();
    }
    
    public Equipo traerEquipo(Equipo equipo) {
    	Equipo equipoBuscado = null;
    	int index = 0;
    	while(equipoBuscado == null && index < equiposParticipantes.size()) {
    		if(equiposParticipantes.get(index).equals(equipo)) {
    			equipoBuscado = equiposParticipantes.get(index);
    		}
    		index++;
    	}
    	return equipoBuscado;
    }
    
    public void agregarEquipo(Equipo equipo) throws Exception {	
    	if(equipo == null) throw new Exception("Error: Equipo es null!");
    	if(traerEquipo(equipo) != null) throw new Exception("Error: El equipo ya existe en el torneo!");             
        equiposParticipantes.add(equipo);
    }
    
    
    public Partido traerPartido(LocalDate fecha, LocalTime hora, String estadio) {
    	Partido partido = null;
    	int index = 0;
    	while(partido == null && index < partidos.size()) {
    		if(partidos.get(index).getFecha().equals(fecha) &&
    		   partidos.get(index).getHora().equals(hora) && 
    		   partidos.get(index).getEstadio().equalsIgnoreCase(estadio)){
    			partido = partidos.get(index);
    		}
    		index++;
    	}
    	return partido;
    }
    
    public Partido traerPartido(int id) {
    	Partido partido = null;
    	int index = 0;
    	while(partido == null && index < partidos.size()) {
    		if(partidos.get(index).getIdPartido() == id){
    			partido = partidos.get(index);
    		}
    		index++;
    	}
    	return partido;
    }
    
    public List<Partido> traerPartidos(Equipo equipo) {
    	List<Partido> partidosEquipo = new ArrayList<Partido>();
    	for(Partido p : partidos) {
    		if(p.getEquipoLocal().equals(equipo) || p.getEquipoVisita().equals(equipo)) {
    			partidosEquipo.add(p);
    		}
    	}
    	return partidosEquipo;
    }
    
    public int calcularPuntosPorEquipo(Equipo equipo) {
    	List<Partido> partidosEquipo = this.traerPartidos(equipo);
    	int puntos = 0;
    	
    	for(Partido p: partidosEquipo) {
    		if(p.determinarResultado() == null) {
    			puntos+=1;
    		}else if(p.determinarResultado().equals(equipo)) {
    			puntos+=3;
    		}
    	}
    	return puntos;
    }
    

    public void agregarPartido(LocalDate fecha, LocalTime hora, Equipo equipoLocal, 
    		Equipo equipoVisitante, String estadio) throws Exception { 
    		
    		if(traerPartido(fecha, hora, estadio) != null) 
    			throw new Exception("Error: Ya existe un partido con la misma fecha, hora y estadio!");
    		
    		int id = 1;
    		if(!partidos.isEmpty()) id= partidos.get(partidos.size()-1).getIdPartido()+1;
            partidos.add(new Partido(id,fecha,hora,equipoLocal,equipoVisitante,estadio));
    }
    
    public Equipo traerEquipoConMayorAltura() throws Exception {
    	if(equiposParticipantes.isEmpty()) throw new Exception("Error: No hay equipos en el torneo."
    			+ " No se puede obtener el equipo con mayor altura");
    	
    	Equipo equipo = equiposParticipantes.get(0);
    	for(int i = 1; i < equiposParticipantes.size();i++) {
    		if(equiposParticipantes.get(i).calcularAlturaPromedio() > equipo.calcularAlturaPromedio()) {
    			equipo = equiposParticipantes.get(i);
    		}
    	}
    	return equipo;
    }


	// Método de eliminación
	public void eliminarPartido(int idPartido) throws Exception {
		Partido partido = traerPartido(idPartido);
		if (partido == null) {
			throw new Exception("Error: Partido no encontrado.");
		}
		partidos.remove(partido);
	}
		
		public List<Posicion> generarTablaPosiciones(){
			List<Posicion> posiciones = new ArrayList<Posicion>();
			
			for(Equipo e: equiposParticipantes) {
				posiciones.add(new Posicion(e,calcularPuntosPorEquipo(e)));
			}
			
			posiciones.sort((p1,p2)->Integer.compare(p2.getPuntaje(),p1.getPuntaje()));
			
			return posiciones;
		}
    
    
    public int calcularGolesJugador(Persona persona) {
    	int total = 0;
    	Jugador jugador = (Jugador) persona;
    	List<Partido> partidosJugador = this.traerPartidos(jugador.getEquipo());
   	
    	for(Partido p: partidosJugador) {
    		total += p.traerEstadistica(persona).getGoles();
    	}
    	
    	
    	return total;
    	
    }
    
    public int calcularAsistenciasJugador(Persona persona) {
    	int total = 0;
    	Jugador jugador = (Jugador) persona;
    	List<Partido> partidosJugador = this.traerPartidos(jugador.getEquipo());
   	
    	for(Partido p: partidosJugador) {
    		total += p.traerEstadistica(persona).getAsistencias();
    	}
    	
    	
    	return total;
    	
    }
    
    public List<Goleador> generarTablaGoleadores(){
    	List<Goleador> goleadores = new ArrayList<Goleador>();
    	
    	for(Equipo e: equiposParticipantes) {
    		
    		for(Jugador j: e.getJugadores()) {
    			
    			int goles = calcularGolesJugador(j);
    			if(goles > 0) goleadores.add(new Goleador(j,goles));
    		}
    		
    		
    	}
    	
    	goleadores.sort((p1,p2)->Integer.compare(p2.getGoles(),p1.getGoles()));
    	
    	return goleadores;
    	
    }
    
    public List<Asistencia> generarTablaAsistidores(){
    	List<Asistencia> asistidores = new ArrayList<Asistencia>();
    	
    	for(Equipo e: equiposParticipantes) {
    		
    		for(Jugador j: e.getJugadores()) {
    			
    			int asistencia = calcularAsistenciasJugador(j);
    			if(asistencia > 0) asistidores.add(new Asistencia(j,asistencia));
    		}
    		
    		
    	}
    	
    	asistidores.sort((p1,p2)->Integer.compare(p2.getAsistencias(),p1.getAsistencias()));
    	
    	return asistidores;
    	
    }
    
    public List<Ganador> traerGanadoresPorFecha(LocalDate inicioFecha, LocalDate finFecha){
    	List<Ganador> ganadores = new ArrayList<Ganador>();
    	
    	for(Partido p: partidos) {
    		if(p.getFecha().equals(inicioFecha) || p.getFecha().equals(finFecha) ||
    				(p.getFecha().isAfter(inicioFecha) && p.getFecha().isBefore(finFecha))) {
    			Equipo equipo = p.determinarResultado();
        		if(equipo != null) {
        			int goles = p.calcularGolesPorEquipoEnPartido(equipo);
        			ganadores.add(new Ganador(p.getFecha(), equipo, goles));
        		}
    		}

    	}
    	
    	return ganadores;
    }
    
 
    public int getIdTorneo() {
        return idTorneo;
    }
    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) throws Exception {
    	if(nombre == null || nombre.isEmpty()) throw new Exception("Error: El nombre no puede estar vacio!");
        this.nombre = nombre;
    }
    public String getTemporada() {
        return temporada;
    }
    public void setTemporada(String temporada) throws Exception {
    	if(temporada == null || temporada.isEmpty()) throw new Exception("Error: La temporada no puede estar vacio!");
        this.temporada = temporada;
    }
    public List<Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }
    public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) throws Exception {
    	if(fechaInicio == null) throw new Exception("Error: La fecha no puede ser nula");
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) throws Exception {
    	if(fechaFin == null) throw new Exception("Error: La fecha de fin ser nula");
    	if(fechaInicio.equals(fechaFin)) throw new Exception("Error: Las fechas de inicio y fin no pueden ser iguales!");
    	if(fechaInicio.isAfter(fechaFin)) throw new Exception("Error: La fecha de inicio no puede ser posterior a la de fin!");
    	this.fechaFin = fechaFin;
        
    }
    public List<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
    
    @Override
    public String toString() {
        return "Torneo [idTorneo=" + idTorneo + ", nombre=" + nombre + ", temporada=" + temporada
                + ", equiposParticipantes=" + equiposParticipantes + ", fechaInicio=" + fechaInicio + ", fechaFin="
                + fechaFin + ", partidos=" + partidos + "]\n";
    }

    
}
