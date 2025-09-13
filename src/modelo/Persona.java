package modelo;

import java.time.LocalDate;

public abstract class Persona {

	private int idPersona;
	private String nombre;
	private String apellido;
	private long dni;
	private LocalDate fechaNacimiento;
	
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getApellido() {
		return apellido;
	}
	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}
	protected long getDni() {
		return dni;
	}
	protected void setDni(long dni) {
		this.dni = dni;
	}
	protected LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	protected void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	protected int getIdPersona() {
		return idPersona;
	}
	
	
}
