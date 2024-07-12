import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws GastoException {
    	Usuario usuario = leerUsuario();		// Se crea el objeto con la información que añada el usuario en la función 'LeerUsuario'.
    	Cuenta cuenta = new Cuenta(usuario);	// Se crea el objeto cuenta, con la información del usuario creado.
    	mostrarMenu(cuenta);					// Menú principal que gestiona todas las acciones de la cuenta. 
    }

/**** Mostrar las distintas opciones validas del Menu de Opciones ****/
    public static void mostrarMenu(Cuenta cuenta) throws GastoException { 
    	System.out.println();					// Espacio para que se vea con claridad la lista de acciones.
    	
    	Scanner entrada = new Scanner(System.in);
    	int seleccion;							// Declaración de la variable para almacenar la selección del usuario.
    	
    	do {									// Bucle do-while para realizar mínimo una iteración.
    		System.out.println("Realiza una nueva acción \n"
        			+ "1 Introduce un nuevo gasto \n"
        			+ "2 Introduce un nuevo ingreso \n"
        			+ "3 Mostrar gastos \n"
        			+ "4 Mostrar ingresos \n"
        			+ "5 Mostrar saldo \n"
        			+ "0 Salir");
    		
    		System.out.print("#: ");
    		seleccion = entrada.nextInt();		// Leemos la opción seleccionada por el usuario.
	    	System.out.println();
	    	
	    	switch(seleccion) {					// Estructura switch para llamar a los métodos en función de la seleccion del usuario.
	    	case 1: addGastos(cuenta);			// Añadir un nuevo gasto.
	    	break;
	    	case 2: addIngresos(cuenta);		// Añadir un nuevo ingreso.
	    	break;
	    	case 3: imprimirGastos(cuenta);		// Muestra todos los gastos añadidos.
	    	break;	    	
	    	case 4: imprimirIngresos(cuenta);	// Muestra todos los ingresos añadidos.
	    			break;
	    	case 5:	imprimirSaldo(cuenta);		// Muestra el saldo restante.
	    			break;
	    	case 0: System.out.println("Fin del programa. \nGracias por utilizar la aplicación.");
	    			break;
	    	default: System.out.println("Selecciona un número de la lista (del 0 al 5).");	// Mensaje en caso de selección errónea.
	    			 System.out.println();
	    			break;
	    	}
	    	
    	} while (seleccion != 0);				// Repetición del bucle hasta que el usuario pulse 0 (salir)
    	entrada.nextLine();						// Limpia la línea del nextInt()
    	entrada.close();
	}
    
/**** Función que lee por teclado los datos del usuario y los devuelve como un objeto de tipo Usuario. ****/
    private static Usuario leerUsuario(){		
    	System.out.println("¡Bienvenido/a! \nVamos a crear una cuenta de usuario.");

    	Usuario usuario = new Usuario();		// Creación del usuario
    	
    	Scanner entrada = new Scanner(System.in);    	
    	
    	System.out.println("Por favor, introduzca su nombre:");
    	usuario.setNombre(entrada.nextLine());	// Método SET para añadir el nombre según la entrada de texto del usuario.
    	
    	System.out.println("Introduzca su edad:");
    	usuario.setEdad(entrada.nextInt());		// Método SET para añadir la edad según la entrada de texto del usuario.
    	entrada.nextLine();						// Para limpiar el bufer de nextInt()
    	
    	System.out.println("Introduzca su DNI:");
    	
    	String dni;								// Declaración de variable String para poder pasarla como parámetro al setDNI
    	do {
    		dni = entrada.nextLine();
    	} while(!usuario.setDNI(dni));			// Método SET para comprobar que el DNI tiene un formato correcto.

    	System.out.println();
    	System.out.println(usuario.toString());	// Se muestra la información del usuario creado.

    	return usuario;    						// Se devuelve el objeto usuario.
    }

    
/**** Funcion que lee por teclado un ingreso, lo agrega a la lista de ingresos y muestra mensaje ****/
    private static void addIngresos(Cuenta cuenta){	// Opción 2

    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Añade la descripción y la cantidad del ingreso. \nDescripción: ");
    	String descripcion = sc.nextLine();				// Se almacena en la variable que se pasará como parámetro.
    	System.out.print("Cantidad: ");
    	double cantidad = sc.nextDouble();
    	sc.nextLine();									// Consumimos la línea del nextDouble() para limpiar el bufer.
    	cuenta.addIngresos(descripcion, cantidad);		// Se añade la cantidad y la descripción al método addIngresos de la clase Cuenta.	
		
    	System.out.println();							
    	System.out.println("Saldo de la cuenta: " + cambiarPunto(cuenta.getSaldo()) + "€"); // Método que cambia a notación europea para devolver el saldo.
    	System.out.println();
    }

    
/**** Muestra por pantalla el listado de ingresos ****/
    private static void imprimirIngresos(Cuenta cuenta){	// Opción 4

   		if(cuenta.getIngresos().isEmpty()) {				  // Condicional para comprobar si hay ingresos.
   			System.out.println("No hay movimientos que mostrar.");	
   			System.out.println();
   		} else {						
   			System.out.println("Lista de ingresos:");
   			for (Ingreso ingresos : cuenta.getIngresos()) {	  // Bucle for mejorado, recorre la lista ingresos(ArrayList) de la clase Cuenta.
   				System.out.println(ingresos.toString());	  // Devuelve el toString de la clase Ingreso.
   			}
   			System.out.println();
   		}
    }

/**** Funcion que lee por teclado un Gasto y lo agrega a la lista de gastos  y muestra mensaje ****/
    private static void addGastos(Cuenta cuenta) throws GastoException { // Opción 1
    	
    	Scanner sc = new Scanner(System.in);
    	try {
	    	System.out.print("Añade la descripción y la cantidad del gasto. \nDescripción: ");
	    	String descripcion = sc.nextLine();
	    	System.out.print("Cantidad: ");	    	
	    	double cantidad = sc.nextDouble();
	    	sc.nextLine();
	    	
	    	cuenta.addGastos(descripcion, cantidad);		// Añade a la lista de gastos (ArrayList) de la clase Cuenta.
	    	
	    	System.out.println();
	    	System.out.println("Saldo de la cuenta: " + cambiarPunto(cuenta.getSaldo()) + "€.");
	    	System.out.println();
	    	
	    	
    	} catch (GastoException e) {
    		System.out.println(e.getMessage());	// Muestra por consola el error personalizado de la clase GastoException.
    		System.out.println("Saldo restante: " + cambiarPunto(cuenta.getSaldo()) + "€.");
    		System.out.println();		// Si entra en el catch volverá a mostar la lista de acciones, se verá más claro con el salto de línea						
    	}		
    }

/**** Muestra por pantalla el listado de gastos ****/
    private static void imprimirGastos(Cuenta cuenta){	// Opción 3
    	if(cuenta.getGastos().isEmpty()) {							// Comprueba si la lista de gastos está vacía.
   			System.out.println("No hay movimientos que mostrar.");
   			System.out.println();
   		} else {
   			System.out.println("Lista de gastos:");
   			for (Gasto gastos : cuenta.getGastos()) {				// Recorre la lista de gastos de la clase Cuenta.
   				System.out.println(gastos);				// Muestra la información (del toString) de la clase Gasto.
   			}
   			System.out.println();
   		}
    }
 
/** Muestra por pantalla el saldo:	**/		// Opción 5
    private static void imprimirSaldo(Cuenta cuenta) {
    	System.out.println(cuenta);			// Información de la clase Cuenta.
    	System.out.println();
    }
    
/** Cambiar la notación decimal en los valores double **/
    static String cambiarPunto(double num) {			// Visibilidad de package para que pueda utilizarlo en todas las clases.
    	String coma = String.format("%.2f", num);		// El parámetro (double num) se formatea a String con dos decimales.
    	coma = coma.replace(".", ",");					// Método replace para cambiar el . por la ,
    	return coma;
    }
}
