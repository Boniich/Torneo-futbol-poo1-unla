package modelo.clasesAuxiliares;

import java.time.LocalDate;

import modelo.Equipo;

public class Ganador {
	
	private LocalDate fecha;
	private Equipo ganador;
	private int goles;
	public Ganador(LocalDate fecha, Equipo ganador, int goles) {
		super();
		this.fecha = fecha;
		this.ganador = ganador;
		this.goles = goles;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Equipo getGanador() {
		return ganador;
	}
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	
	@Override
	public String toString() {
		return "Ganador [fecha=" + fecha + ", ganador=" + ganador.getNombre() + ", goles=" + goles + "]\n";
	}
}
