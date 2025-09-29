package modelo;

import java.time.LocalDate;

public abstract class Persona {

	private String nombre;
	private String apellido;
	private long dni;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, String apellido, long dni, LocalDate fechaNacimiento) throws Exception {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setFechaNacimiento(fechaNacimiento);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws Exception {
		if(nombre.isEmpty()) throw new Exception("Error:El nombre no puede estar vacio!");
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) throws Exception {
		if(apellido.isEmpty()) throw new Exception("Error:El apellido no puede estar vacio!");
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) throws Exception {
		
		int cantidadDigitos = String.valueOf(dni).length();
		if(cantidadDigitos < 7 || cantidadDigitos > 8) throw new Exception("Error: El dni es invalido");
		
		this.dni = dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws Exception {
		if(fechaNacimiento == null) throw new Exception("Error: la fecha de nacimiento no puede estar vacia!");
		if((LocalDate.now().getYear() - fechaNacimiento.getYear()) < 18) 
			throw new Exception("Error: La persona es menor edad!");
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
}
