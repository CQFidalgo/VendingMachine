/**
 * @author CQFidalgo
 */

package uva.inf.poo.Entrega2;

/**
 * Implementación de productos como tipo particular de la clase Vendible
 * 
 * 
 */
public class Producto extends Vendible {

	// atributos
	private double precio;

	/**
	 * Inicialización de producto con argumentos 
	 * 
	 * @see Vendible#Vendible(String nombre, String identificador)
	 * 
	 * @param nombre:
	 *            Nombre del producto
	 * @param Upc:
	 *            Código UPC del producto
	 * @param precio:
	 *            Precio del producto
	 * 
	 * @assert.pre El precio tiene que ser mayor que 0
	 * @assert.pre <br> El UPC tiene que ser de longitud 12 y correcto
	 */
	public Producto(String nombre, String Upc, double precio) {
		super(nombre, Upc);
		assert (precio > 0);
		assert (UpcCorrecto(Upc)); 

		this.precio = precio;
	}

	/**
	 * Devuelve el precio de {@code this}
	 * 
	 * @see Vendible#getPrecio()
	 * 
	 * @return Precio del producto
	 * 
	 */
	@Override
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio de {@code this}
	 * 
	 * @param variacionPrecio:
	 *            Precio a incrementar o decrementar
	 * 
	 * @assert.pre variacionPrecio tiene que ser mayor que el precio en negativo
	 *             para evitar que el precio modificado llegue a ser negativo
	 */
	public void setPrecio(double variacionPrecio) {
		assert (variacionPrecio > -precio);

		precio = precio + variacionPrecio;
	}

	/*
	 * Comprueba si el código UPC de un producto es correcto, operando sobre los
	 * 11 primeros dígitos y comparando el resultado con el último dígito
	 */
	private boolean UpcCorrecto(String Upc) {
		assert (Upc.length() == 12); // la longitud del UPC ha de ser 12

		int cifrasUPC[] = new int[12]; // vector de enteros donde se almacenarán
										// los dígitos de UPC
		float suma = 0;

		// bucle que recorre UPC y almacena cada cifra en una posición del
		// vector
		for (int i = 0; i <= cifrasUPC.length - 1; i++)
			cifrasUPC[i] = Upc.charAt(i) - 48; // pasa el código ASCII a su
												// entero correspondiente

		// bucle que recorre las 11 primeras posiciones de cifrasUPC y opera con
		// ellos
		for (int j = 0; j <= cifrasUPC.length - 2; j++) {
			// suma las posiciones pares
			if ((j + 1) % 2 == 0) {
				suma = suma + cifrasUPC[j]; // incrementa a suma el valor de
											// cada posición par
			}
			// suma las posiciones impares
			else {
				suma = suma + cifrasUPC[j] * 3; // incrementa a suma el valor de
												// cada posición multiplicada
												// por 3
			}
		}

		// aproxima el resultado de suma al múltiplo de 10 más cercano igual o
		// mayor que suma
		double sumaAproximada = Math.ceil(suma / 10) * 10;
		// calcula la diferencia entre sumaAproximada y suma
		int diferencia = (int) (sumaAproximada - suma);

		// comprueba que la diferencia sea igual al último dígito de cifrasUPC
		if (diferencia == cifrasUPC[cifrasUPC.length - 1]) {
			return true;
		} else {
			return false;

		}
	}

	/**
	 * Comprueba si un código UPC es correcto
	 * 
	 * @param Upc:
	 *            Código que se quiere comprobar
	 * 
	 * @return {@code True} si el código es correcto, {@code False} en caso
	 *         contrario
	 */
	public boolean comprobarUpc(String Upc) {
		return UpcCorrecto(Upc);
	}

}
