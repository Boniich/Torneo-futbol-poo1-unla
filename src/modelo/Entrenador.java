package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona{
	private int idEntrenadorr;
	private String estrategiaFavorita;
	//constructor
	public Entrenador(int idEntrenador, String apellido, String nombre, long dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) {
		super(nombre, apellido, dni, fechaNacimiento);
		this.idEntrenadorr = idEntrenador;
		this.estrategiaFavorita = estrategiaFavorita;
	}
	
	public int getIdEntrenador() {
		return idEntrenadorr;
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
		return "Entrenador [idEntrenador=" + idEntrenadorr + ", estrategiaFavorita=" + estrategiaFavorita + "]";
	}
}
