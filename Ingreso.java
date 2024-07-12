
/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Ingreso extends Dinero{		// Hereda de dinero sus atributos y podemos acceder a sus métodos.
   	public Ingreso(double ingreso, String description) {
   		this.dinero = ingreso;
   		this.description = description;
   	}
   	
   	// Sobreescribo el método toString para que aparezca de forma más comprensible al usuario.
   @Override
   public String toString() {
   		return "Ingreso: " + Main.cambiarPunto(getDinero()) + ". Descripción: " + getDescription();
   	}		// Se utiliza el método cambiarPunto creado en el Main (con acceso para el mismo paquete) para modificar a notación europea.
}
