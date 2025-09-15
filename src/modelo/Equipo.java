package modelo;

import java.util.List;
import java.util.ArrayList;

public class Equipo {

	private final int idEquipo;
	private String codigo;
	private String nombre;
	private List<Jugador> jugadores;
	private Entrenador entrenador;
	
	public Equipo(int idEquipo, String codigo, String nombre, Entrenador entrenador) {
		
		this.idEquipo = idEquipo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.entrenador = entrenador;
		this.jugadores = new ArrayList<>();
	}
	
	public int getIdEquipo(){
		return idEquipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public List<Jugador> getJugadores(){
		return jugadores;
	}
	public void agregarJugador(Jugador jugador) { //falta la funcion mayor de edad de jugador, despues se agrega
        //if (jugador.) {             
            jugadores.add(jugador);
        //} else {
          //  throw new IllegalArgumentException("El jugador debe ser mayor de edad");
        //}
    }
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador=entrenador;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo 
				+ ", codigo=" + codigo 
				+ ", nombre=" + nombre 
				//+ ", jugadores= "+ jugadores
				//+ ", entrenador= " + entrenador
				+ "]";
	}
	
}
