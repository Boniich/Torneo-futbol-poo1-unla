package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona{
	private int idEntrenador;
	private String estrategiaFavorita;
	//constructor
	public Entrenador(int idEntrenador, String apellido, String nombre, long dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) throws Exception {
		super(nombre, apellido, dni, fechaNacimiento);
		this.idEntrenador = idEntrenador;
		this.setEstrategiaFavorita(estrategiaFavorita);
	}
	
	public int getIdEntrenador() {
		return idEntrenador;
	}
	//getters&setters
	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}
	public void setEstrategiaFavorita(String estrategiaFavorita)throws Exception {
		if (estrategiaFavorita == null || estrategiaFavorita.trim().isEmpty()) {
			throw new Exception("Error: El entrenador no tiene estrategia !");
        }
		this.estrategiaFavorita = estrategiaFavorita;
	}

	@Override
	public String toString() {
		return "Entrenador [idEntrenador=" + idEntrenador + ", estrategiaFavorita=" + estrategiaFavorita + "]";
	}
}
