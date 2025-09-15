package model;

import java.time.LocalDate;

public class Entrenador extends Persona{
	private String estrategiaFavorita;
	//constructor
	public Entrenador(int idPersona, String apellido, String nombre, String dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) {
		super(idPersona, apellido, nombre, dni, fechaNacimiento);
		this.estrategiaFavorita = estrategiaFavorita;
	}
	//getters&setters
	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}
	public void setEstrategiaFavorita(String estrategiaFavorita) {
		this.estrategiaFavorita = estrategiaFavorita;
	}
	//toString
	@Override
	public String toString() {
		return "Entrenador [estrategiaFavorita=" + estrategiaFavorita + "]";
	}
	

}
