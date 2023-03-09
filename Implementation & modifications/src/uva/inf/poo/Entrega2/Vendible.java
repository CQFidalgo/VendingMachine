/**
 * @author CQFidalgo
 */

package uva.inf.poo.Entrega2;



/**
 * Abstracción de los objetos vendibles
 * 
 */
public abstract class Vendible {
	
	//atributos
	private String nombre;
	private String identificador;
	
	/**
	 * Inicialización de Vendible
	 * 
	 * @param nombre: Nombre del objeto vendible
	 * @param identificador: Código identificador
	 * 
	 * @assert.pre El nombre debe de ser no vacío
	 * @assert.pre El identificador debe de ser no vacío
	 */
	public Vendible(String nombre, String identificador){
		assert (nombre != "");
		assert (identificador != "");
		
		this.nombre = nombre;
		this.identificador = identificador;
	}
	
	/**
	 * Devuelve el nombre de {@code this}
	 * 
	 * @return Nombre del vendible
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Devuelve el identificador de {@code this}
	 * 
	 * @return El código identificador del vendible
	 */
	public String getIdentificador(){
		return identificador;
	}
	
	/**
	 * Devuelve el precio de {@code this}
	 * 
	 * @return El precio del vendible
	 */
	public abstract double getPrecio();
	

}
 