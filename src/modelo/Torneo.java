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

    

    public Torneo(int idTorneo, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.temporada = temporada;
        this.equiposParticipantes = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.partidos = new ArrayList<>();
    }
    public void agregarEquipo(Equipo equipo) { 
                     
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTemporada() {
        return temporada;
    }
    public void setTemporada(String temporada) {
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
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
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
                + fechaFin + ", partidos=" + partidos + "]";
    }

    
}
