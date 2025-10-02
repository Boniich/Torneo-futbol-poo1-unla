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
		setCodigo(codigo);
		this.nombre = nombre;
		this.entrenador = entrenador;
		this.jugadores = new ArrayList<>();
	}
	
	
	public void agregarJugador(Jugador jugador) throws Exception {
		if(traerJugador(jugador.getDni()) != null) throw new Exception("Error: El jugador ya existe!");
        	jugadores.add(jugador);
	}
	
	
	public Jugador traerJugador(long dni) {
		Jugador jugadorBuscado = null;
		int index = 0;
		boolean encontrado = false;
		while(index < jugadores.size() && !encontrado) {
			if(jugadores.get(index).getDni() == dni) {
				jugadorBuscado = jugadores.get(index);
				encontrado = true;
			}
			index++;
		}
		return jugadorBuscado;
	}
	public void eliminarJugador(long dni)throws Exception{
		Jugador jugador= this.traerJugador(dni);
		if(jugador ==null) throw new Exception("Error: No existe el jugador!");
			jugadores.remove(jugador);
	}
// ^[a-zA-ZñÑ]{3}$ valida exactamente 3 caracteres que sean solo letras.
// Esto se recomienda para cumplir con: "tres letras del nombre"
// return codigo.matches("^[a-zA-ZñÑ]{3}$");
	public boolean isCodigo(String codigo){
		//boolean n = false;
		//if((codigo.length()==3 && nombre.contains(codigo)){
		//	n=true;
		//}
		
		//return n;

		return codigo.matches("^[a-zA-ZñÑ]{3}$");
	}


	public int getIdEquipo(){
		return idEquipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo){
		if(!isCodigo(codigo))throw new IllegalArgumentException("Error: Codigo no valido.");
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
				+ ", jugadores= "+ jugadores
				+ ", entrenador= " + entrenador
				+ "]";
	}
	
}
