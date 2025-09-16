package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Partido {
    private int idPartido;
    private LocalDate fecha;
    private LocalTime hora;
    private Equipo equipoLocal;
    private Equipo equipoVisita;
    private String estadio;
    private List<Estadistica> estadisticas;

    public Partido(int idPartido, LocalDate fecha, LocalTime hora, Equipo equipoLocal, Equipo equipoVisita,
            String estadio, Estadistica estadistica) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.hora = hora;
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
        this.estadio = estadio;
        this.estadisticas = new ArrayList<>();
    }

    public void agregarEstadistica ( Estadistica estadistica){
        
        estadisticas.add(estadistica);
    }

    public int getIdPartido() {
        return idPartido;
    }
    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public Equipo getEquipoVisita() {
        return equipoVisita;
    }
    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }
    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public List<Estadistica> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<Estadistica> estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "Partido [idPartido=" + idPartido + ", fecha=" + fecha + ", hora=" + hora + ", equipoLocal="
                + equipoLocal + ", equipoVisita=" + equipoVisita + ", estadio=" + estadio + ", estadisticas="
                + estadisticas + "]";
    }



    
}
