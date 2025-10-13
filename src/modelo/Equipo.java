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
	
	
	//Debemos cambiar la referencia de Jugador jugador por Persona persona
	//Debemos validar que el objeto pasado es de tipo Jugador
	//Debemos validar que ese jugador no este en la lista
	public void agregarJugador(Jugador jugador) throws Exception {
		if(traerJugador(jugador.getDni()) != null) throw new Exception("Error: El jugador ya existe!");
		//if(traerJugador(jugador) throw new Exception("Error: El jugador ya existe!");

        	jugadores.add(jugador);
	}
	
	/*
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
	}*/
	
	
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (idEquipo != other.idEquipo)
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (jugadores == null) {
			if (other.jugadores != null)
				return false;
		} else if (!jugadores.equals(other.jugadores))
			return false;
		if (entrenador == null) {
			if (other.entrenador != null)
				return false;
		} else if (!entrenador.equals(other.entrenador))
			return false;
		return true;
	}
	
}
