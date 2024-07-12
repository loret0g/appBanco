public abstract class Dinero {	// Clase abstracta, las clases que heredan de ella pueden acceder a sus métodos y atributos y sobrescribirlos.
   	
	protected double dinero;
	protected String description;
	
	// Getters y Setters:
	public double getDinero() {
		return dinero;
	}
	
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}