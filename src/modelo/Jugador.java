package modelo;

import java.time.LocalDate;

public class Jugador extends Persona {
	private int idJugador;
	private double estatura;
	private double peso;
	private String posicion;
	private int numeroCamiseta;
	//constructor
	public Jugador(int idJugador, String apellido, String nombre, long dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta) throws Exception {
		super(nombre,apellido,dni, fechaNacimiento);
		this.idJugador = idJugador;
		this.setEstatura(estatura);
		this.setPeso(peso);
		this.setPosicion(posicion);
		this.setNumeroCamiseta(numeroCamiseta);
	}
	

	public int getIdJugador() {
		return idJugador;
	}

	//getters&setters
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) throws Exception {
		if(estatura < 0) throw new Exception("Error: La estatura no puede ser 0!");
		this.estatura = estatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) throws Exception {
		if(peso < 0) throw new Exception("Error: El peso no puede ser 0!");
		this.peso = peso;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) throws Exception {
		if(posicion.isEmpty()) throw new Exception("Error: La posicion no puede estar vacia!");
		this.posicion = posicion;
	}
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) throws Exception {
		if(numeroCamiseta < 0) throw new Exception("Error: El numero de la posicion no puede ser negativo!");
		this.numeroCamiseta = numeroCamiseta;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + ", numeroCamiseta=" + numeroCamiseta + "]";
	}



}
