package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona{
	private int idEntrenador;
	private String estrategiaFavorita;
	//constructor
	public Entrenador(int idEntrenador, String apellido, String nombre, long dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) {
		super(nombre, apellido, dni, fechaNacimiento);
		this.idEntrenador = idEntrenador;
		this.estrategiaFavorita = estrategiaFavorita;
	}
	
	public int getIdEntrenador() {
		return idEntrenador;
	}
	//getters&setters
	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}
	public void setEstrategiaFavorita(String estrategiaFavorita) {
		this.estrategiaFavorita = estrategiaFavorita;
	}

	@Override
	public String toString() {
		return "Entrenador [idEntrenador=" + idEntrenador + ", estrategiaFavorita=" + estrategiaFavorita + "]";
	}
}
