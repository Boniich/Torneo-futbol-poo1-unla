package model;

import java.time.LocalDate;

public class Jugador extends Persona {
	private double estatura;
	private double peso;
	private String posicion;
	private int numeroCamiseta;
	//constructor
	public Jugador(int idPersona, String apellido, String nombre, String dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta) {
		super(idPersona, apellido, nombre, dni, fechaNacimiento);
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
		this.numeroCamiseta = numeroCamiseta;
	}
	//getters&setters
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	//toString
	@Override
	public String toString() {
		return "Jugador [estatura=" + estatura + ", peso=" + peso + ", posicion=" + posicion + ", numeroCamiseta="
				+ numeroCamiseta + "]";
	}

}
