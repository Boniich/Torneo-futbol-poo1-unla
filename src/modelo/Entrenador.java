package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona{
	private String estrategiaFavorita;
	//constructor
	public Entrenador(int id, String apellido, String nombre, long dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) throws Exception {
		super(id,nombre, apellido, dni, fechaNacimiento);
		this.setEstrategiaFavorita(estrategiaFavorita);
	}
	
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
		return "Entrenador ["+super.toString()+ " estrategiaFavorita=" + estrategiaFavorita + "]\n";
	}


}
