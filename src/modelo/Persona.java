package modelo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Persona {

	protected int id;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNacimiento;
	
	public Persona(int id,String nombre, String apellido, long dni, LocalDate fechaNacimiento) throws Exception {
		this.id = id;
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setFechaNacimiento(fechaNacimiento);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "[id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		if (dni != other.dni)
			return false;
		return true;
	}

}
