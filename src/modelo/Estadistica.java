package modelo;

public class Estadistica {
	
	private final int idEstadistica;
	private int goles;
	private int asistencias;
	private int minutosJugados;
	private Jugador jugador;
	
	public Estadistica(int idEstadistica, int goles, int asistencias, int minutosJugados, Jugador jugador) throws Exception {
		this.idEstadistica = idEstadistica;
		this.setGoles(goles);
		this.setAsistencias(asistencias);
		this.setMinutosJugados(minutosJugados);
		this.setJugador(jugador);
	}
	
	public int getIdEstadistica() {
		return idEstadistica;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) throws Exception {
		if(goles < 0) throw new Exception("Error: Los goles no pueden ser inferiores a 0!");
		this.goles=goles;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) throws Exception {
		if(asistencias < 0) throw new Exception("Error: Las asistencias no pueden ser inferiores a 0!");
		this.asistencias = asistencias;
	}
	public int getMinutosJugados() {
		return minutosJugados;
	}
	public void setMinutosJugados(int minutosJugados) throws Exception {
		if(minutosJugados < 0) throw new Exception("Error: Los minutos jugados no pueden ser inferiores a 0!");
		this.minutosJugados = minutosJugados;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) throws Exception {
		if(jugador == null) throw new Exception("Error: El jugador no puede estar vacio!");
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Estadistica [idEstadistica=" + idEstadistica 
				+ ", goles=" + goles 
				+ ", asistencias=" + asistencias 
				+ ", minutosJugados=" + minutosJugados 
				+", jugador=" + jugador
				+ "]\n";
	}
	
}
