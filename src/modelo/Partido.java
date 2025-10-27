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
            String estadio) throws Exception {
        this.idPartido = idPartido;
        this.setFecha(fecha);
        this.setHora(hora);
        this.setEquipoLocal(equipoLocal);
        this.setEquipoVisita(equipoVisita);
        this.setEstadio(estadio);
        this.estadisticas = new ArrayList<>();
    }
    
    public Estadistica traerEstadistica(int id) {
    	Estadistica estadisticaBuscada = null;
    	int index = 0;
    	while(estadisticaBuscada == null && index < estadisticas.size()) {
    		if(estadisticas.get(index).getIdEstadistica() == id) {
    			estadisticaBuscada = estadisticas.get(index);
    		}
    		index++;
    	}
    	return estadisticaBuscada;
    }
    
    public Estadistica traerEstadistica(Persona persona) {
    	Estadistica estadisticaBuscada = null;
    	int index = 0;
    	while(estadisticaBuscada == null && index < estadisticas.size()) {
    		if(persona instanceof Jugador && estadisticas.get(index).getJugador().equals(persona)) {
    			estadisticaBuscada = estadisticas.get(index);
    		}
    		index++;
    	}
    	return estadisticaBuscada;
    }
    
 
    public void agregarEstadistica (int goles, int asistencias, int minutosJugados,Persona persona) throws Exception{
        
    	if(persona == null) throw new Exception("Error: La persona no puede ser null!");
    	if(!(persona instanceof Jugador)) throw new Exception("Error: La persona no es un jugador!");
    	if(traerEstadistica(persona) != null) throw new Exception("Error: El jugador ya tiene una estadistica!");
    	
    	int id = 1;
    	if(!estadisticas.isEmpty()) id = estadisticas.get(estadisticas.size()-1).getIdEstadistica()+1;
        estadisticas.add(new Estadistica(id, goles, asistencias, minutosJugados,(Jugador)persona));
    }
    
    public List<Estadistica> traerEstadisticas(int idInicio, int idFin){
    	List<Estadistica> estadisticasPorEquipo = new ArrayList<Estadistica>();
    	
    	for(int i = idInicio; i < idFin;i++) {
    		estadisticasPorEquipo.add(estadisticas.get(i));
    	}
    	
    	return estadisticasPorEquipo;
    }
    
    public List<Estadistica> traerEstadisticas(Equipo equipo){
    	List<Estadistica> estadisticasPorEquipo = new ArrayList<Estadistica>();
    	
    	for(Estadistica e : estadisticas) {
    		if(e.getJugador().getEquipo().equals(equipo)) estadisticasPorEquipo.add(e);
    	}
    	
    	return estadisticasPorEquipo;
    }
    
    
    public int calcularGolesPorEquipoEnPartido(int idInicio, int idFin) {
    	int goles = 0;
    	List<Estadistica> estadisticasEquipo = traerEstadisticas(idInicio, idFin);
    	
    	for(Estadistica e: estadisticasEquipo) {
    		goles += e.getGoles();
    	}
    	return goles;
    }
    
    public int calcularGolesPorEquipoEnPartido(Equipo equipo) {
    	int goles = 0;
    	List<Estadistica> estadisticasEquipo = traerEstadisticas(equipo);
    	
    	for(Estadistica e: estadisticasEquipo) {
    		goles += e.getGoles();
    	}
    	return goles;
    }
    
    public Equipo determinarResultado() {
    	Equipo equipo = null;
    	int golesLocal = 0;
    	int golesVisita = 0;
    	golesLocal = calcularGolesPorEquipoEnPartido(0, 5);
    	golesVisita = calcularGolesPorEquipoEnPartido(5, 10);

    	if(golesLocal > golesVisita) {
    		equipo = this.equipoLocal;
    	}else if(golesVisita > golesLocal) {
    		equipo = this.equipoVisita;
    	}
    	
    	return equipo;
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
    public void setFecha(LocalDate fecha) throws Exception {
    	if(fecha == null) throw new Exception("Error: La fecha no puede estar nula!");
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) throws Exception {
    	if(hora == null) throw new Exception("Error: La hora no puede estar nula!");
        this.hora = hora;
    }
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(Equipo equipoLocal) throws Exception {
    	if(equipoLocal == null) throw new Exception("Error: El equipo local no puede ser nulo!");
        this.equipoLocal = equipoLocal;
    }
    public Equipo getEquipoVisita() {
        return equipoVisita;
    }
    public void setEquipoVisita(Equipo equipoVisita) throws Exception {
    	if(equipoVisita == null) throw new Exception("Error: El equipo visitante no puede ser nulo!");
    	if(equipoVisita.equals(equipoLocal)) throw new Exception("Error: El equipo local y visitante son el mismo!");
        this.equipoVisita = equipoVisita;
    }
    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) throws Exception {
    	if(estadio ==null || estadio.isEmpty()) throw new Exception("Error: El estadio no puede estar null o vacio!");
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
                + equipoLocal.getNombre() + ", equipoVisita=" + equipoVisita.getNombre() + ", estadio=" + estadio + "]\n";
    }

 
}
