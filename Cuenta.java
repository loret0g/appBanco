import java.util.ArrayList;

public class Cuenta {

   	private double saldo;
   	
   	private Usuario usuario;
   	
   	private ArrayList<Gasto> gastos;
   	
   	private ArrayList<Ingreso> ingresos;
   	
   	// Constructor:
   	public Cuenta(Usuario usuario) {				
	
   		this.usuario = usuario;						// Necesario el 'this' para referirnos al atributo de la clase = atributo del parámetro.
   		
   		this.saldo = 0;								// En los siguientes atributos no sería necesario el this, ya que no hay más parámetros
   													// pero queda más claro al indicar que se inicializan los atributos de clase.
   		this.gastos = new ArrayList<>();		
   		
   		this.ingresos = new ArrayList<>();

   	}	
   	
   	// Getters y Setters:
   	public double getSaldo() {
   		return saldo;
   	}
   	
   	public void setSaldo(double saldo) {
   		this.saldo = saldo;   		
   	}
   	
   	public Usuario getUsuario() {
   		return usuario;
   	}
   	
   	public void setUsuario(Usuario usuario) {
   		this.usuario = usuario;
   	}
   	
   	public double addIngresos(String description, double cantidad) {
   		ingresos.add(new Ingreso(cantidad, description));	// Parámetros que recibe la clase Ingreso (al revés).
   		saldo += cantidad;									// Se suma a la variable 'saldo' la cantidad ingresada por el usuario.
   		
   		return saldo;
   	}
   	
   	public double addGastos(String description, double cantidad) throws GastoException {
   		if(saldo - cantidad < 0) {							// Si la resta entre el saldo y la cantidad del gasto es menor que 0...
   			throw new GastoException();						// salta la exceptión, ya que no tiene dinero suficiente.
   		} else {
   			gastos.add(new Gasto(cantidad, description));	// Se crea un objeto de tipo Gasto donde añadir la lista de gastos
   			saldo -= cantidad;								// Se resta la cantidad del gasto al saldo total.
   		}
   		return saldo;
   	}
   	
   	public ArrayList<Ingreso> getIngresos(){
   		return ingresos;				// Devuelve la lista de ingresos.
   	}
   	
   	public ArrayList<Gasto> getGastos(){
   		return gastos;					// Devuelve la lista de gastos.
   	}
   	
   	@Override
   	public String toString() {	
   		return getUsuario() + " \nSaldo: " + Main.cambiarPunto(getSaldo()) + "€.";
   	}
   	
}