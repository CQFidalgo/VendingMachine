package Practica1;

/**
 * Implementación de productos y su modificación
 * 
 * @author CQFidalgo
 */
public class Producto {
	
	/*
	 * Atributos de la clase
	 */
	private double precio; 
	private String nombre;
	private String UPC;

	/**
	 * Inicialización por defecto de un producto
	 */
	public Producto() {
		precio = 0.0; 
		nombre = null;
		UPC = null;
	}

	/**
	 * Inicialización de un producto con argumentos
	 * 
	 * @param precio: Precio del producto
	 * @param nombre: Nombre del producto
	 * @param UPC: Código UPC del producto
	 * 
	 * @assert.pre Precio tiene que ser positivo
	 * @assert.pre <br> UPC tiene que ser de longitud 12 y  correcto
	 */
	public Producto(double precio, String nombre, String UPC) {
		assert (precio > 0); //el precio del producto tiene que ser positivo
		assert (comprobarUPC(UPC)); //comprueba que el UPC del producto es correcto

		this.precio = precio;
		this.nombre = nombre;
		this.UPC = UPC;
	}

	/**
	 * Devuelve el precio de {@code this}
	 * 
	 * @return Precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Devuelve el nombre de {@code this}
	 * 
	 * @return Nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el código UPC de {@code this}
	 * 
	 * @return Código UPC
	 */
	public String getUPC() {
		return UPC;
	}

	/**
	 * Modifica el precio de {@code this}
	 * 
	 * @param cantidadPrecio: Precio a incrementar
	 * 
	 * @return Precio modificado
	 * 
	 * @assert.pre cantidadPrecio tiene que ser mayor que el precio en negativo para evitar que el 
	 * 			   precio modificado llegue a ser negativo
	 */
	public double setPrecio(double cantidadPrecio) {
		assert (cantidadPrecio > -precio); //evita que el precio modificado llegue a ser negativo
		
		return precio = precio + cantidadPrecio;
	}

	/**
	 * Modifica el nombre de {@code this}
	 * 
	 * @param nombre: Nuevo nombre 
	 * 
	 * @return Nombre modificado
	 */
	public String setNombre(String nombre) {
		return this.nombre = nombre;
	}

	/**
	 * Modifica el UPC de {@code this}
	 * 
	 * @param UPC: Nuevo código UPC 
	 * 
	 * @return UPC modificado
	 * 
	 * @assert.pre El UPC tiene que ser correcto
	 */
	public String setUPC(String UPC) {
		assert (comprobarUPC(UPC));

		return this.UPC = UPC;
	}

	/* Comprueba si el código UPC de un producto es correcto, operando sobre los
	11 primeros dígitos y comparando el resultado con el último dígito */
	private boolean comprobarUPC(String UPC) {
		assert (UPC.length() == 12); //la longuitud del UPC ha de ser 12

		int cifrasUPC[] = new int[12]; //vector de enteros donde se almacenarán los dígitos de UPC
		float suma = 0;
		
		//bucle que recorre UPC y almacena cada cifra en una posición del vector
		for (int i = 0; i <= cifrasUPC.length - 1; i++) 
			cifrasUPC[i] = UPC.charAt(i) - 48; //pasa el codigo ASCII a su entero correspondiente
		
		//bucle que recorre las 11 primeras posiciones de cifrasUPC y opera con ellos
		for (int j = 0; j <= cifrasUPC.length - 2; j++) {
			//suma las posiciones pares
			if ((j + 1) % 2 == 0) {
				suma = suma + cifrasUPC[j]; //incrementa a suma el valor de cada posición par 	
			} 
			//suma las posiciones impares
			else {
				suma = suma + cifrasUPC[j] * 3; //incrementa a suma el valor de cada posición multiplicada por 3
			}
		}
		
		//aproxima el resultado de suma al múltiplo de 10 más cercano igual o mayor que suma
		double sumaAproximada = Math.ceil(suma / 10) * 10;
		//calcula la diferencia entre sumaAproximada y suma
		int diferencia = (int) (sumaAproximada - suma);
		
		//comprueba que la diferencia sea igual al ultimo dígito de cifrasUPC
		if (diferencia == cifrasUPC[cifrasUPC.length - 1]) {
			return true; 
		} 
		else {
			return false;

		}
	}
}