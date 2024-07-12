public class Usuario {   	
	private String nombre;
	private int edad;
	private String DNI;
	
	// Constructor vacío que se instancia en el Main. El usuario se crea a través de los setters y getters (con los datos introducidos por consola).
	public Usuario() {}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public boolean setDNI(String DNI) {						// Método que devuelve un boolean al comprobar el formato del DNI.
		String expresionRegular = "^(\\d{8}-?[a-z])$";		// Expresión regular que mejor se adapta a las especificaciones.
		
		if(DNI.matches(expresionRegular)) {					// Método para comprobar si una cadena coincide con una expresión regular
			this.DNI = DNI;									// Si es correcto se asigna a la variable DNI. 
			System.out.println("Usuario '" + nombre + "' creado correctamente.");
			return true;
		} else {
			System.out.println("DNI incorrecto. \nPor favor, introduzca su DNI en el siguiente formato 78844112m / 78844112-m");
			return false;
		}
	}
	
	// Sobreescribo el método toString para que aparezca de forma más comprensible al usuario.
	@Override
	public String toString() {								
		return "Nombre: " + nombre + ". Edad: " + edad + ". Dni: " + DNI;
	}
}
