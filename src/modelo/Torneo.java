package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public void agregarPartido(Partido partido) { 
                     
            partidos.add(partido);
        
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
