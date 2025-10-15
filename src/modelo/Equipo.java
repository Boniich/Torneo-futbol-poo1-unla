package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {

	private final int idEquipo;
	private String codigo;
	private String nombre;
	private LocalDate fechaCreacion;
	private List<Jugador> jugadores;
	private Entrenador entrenador;
	
	public Equipo(int idEquipo, String nombre,String codigo,LocalDate fechaCreacion, Entrenador entrenador) throws Exception {
		
		this.idEquipo = idEquipo;
		setCodigo(codigo);
		setNombre(nombre);
		setFechaCreacion(fechaCreacion);
		this.entrenador = entrenador;
		this.jugadores = new ArrayList<>();
	}
	
	
	public double calcularAlturaPromedio() {
		double alturaPromedio = 0;
		if(!jugadores.isEmpty()) {
			for(Jugador j: jugadores) {
				alturaPromedio += j.getEstatura();
			}
			alturaPromedio/=jugadores.size();
		}
		
		return alturaPromedio;
	}
	
	public void agregarJugador(Persona persona) throws Exception {
		if(!(persona instanceof Jugador)) throw new Exception("Error: La persona no es un jugador!");
		Jugador jugador = (Jugador)persona;
		if(traerJugador(jugador) != null) throw new Exception("Error: El jugador ya esta en el equipo!");
		if(jugador.getEquipo() != null) throw new Exception("Error: El jugador ya tiene equipo!");
		jugador.setEquipo(this);
        jugadores.add(jugador);
	}
	
	
	public Jugador traerJugador(Jugador jugador) {
		Jugador jugadorBuscado = null;
		int index = 0;
		boolean encontrado = false;
		while(index < jugadores.size() && !encontrado) {
			if(jugadores.get(index).equals(jugador)) {
				jugadorBuscado = jugadores.get(index);
				encontrado = true;
			}
			index++;
		}
		return jugadorBuscado;
	}
	
/*
	public void eliminarJugador(long dni)throws Exception{
		Jugador jugador= this.traerJugador(dni);
		if(jugador ==null) throw new Exception("Error: No existe el jugador!");
			jugadores.remove(jugador);
	}
	*/
	
	private boolean esCodigoValido(String codigo){
		
		boolean codigoValido = true;
		
		if(codigo.length() != 3) {
			codigoValido = false;
		}else {
			int i = 0;
			
			while(i < codigo.length() && codigoValido) {
				codigoValido = Character.isLetter(codigo.charAt(i));
				i++;
			}
		}
		return codigoValido;
	}

	public int getIdEquipo(){
		return idEquipo;
	}
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) throws Exception{
		if(!esCodigoValido(codigo)) throw new Exception("Error: El codigo es incorrecto!");
		
		this.codigo=codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre)throws Exception {
		//trim elimina los espacios vacios, despues verificamos si esta vacio
		//la idea es descartar los strings de solo espacios
		if(nombre==null || nombre.trim().isEmpty())throw new Exception("Error: El nombre esta vacio.");
		this.nombre=nombre;
	}
	

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) throws Exception {
		if(fechaCreacion==null)throw new Exception("Error: la fecha no puede ser null");
		this.fechaCreacion = fechaCreacion;
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
				+ ", jugadores= \n"+ jugadores
				+ ", entrenador= " + entrenador
				+ "]";
	}


	public boolean equals(Equipo equipo) {
		return 	this.nombre.equalsIgnoreCase(equipo.getNombre()) &&
				this.codigo.equalsIgnoreCase(equipo.getCodigo()) && 
				this.idEquipo == equipo.idEquipo;
	}
	
}
