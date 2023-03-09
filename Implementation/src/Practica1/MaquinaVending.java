package Practica1;

import fabricante.externo.tarjetas.*;
import java.util.Arrays;
import Practica1.Producto;

/**
 * Implementación de una Máquina Vending y su modificación
 * 
 * @author CQFidalgo
 */
public class MaquinaVending {
	
	// atributos de la clase
	private int numeroCeldas; //número de espacios disponibles en la máquina
	private Producto productos[]; //vector donde se almacena en cada posición 
								  //el producto correspondiente a cada celda
	private int cantidades[]; //vector con las cantidades de cada producto de cada celda
	private int cantidadMaximaCelda; //máxima cantidad de producto que se puede almacenar en cada celda 

	/**
	 * Inicialización por defecto de una máquina
	 */
	public MaquinaVending() {
		numeroCeldas = 0;
		productos = new Producto[numeroCeldas];
		cantidades = new int[numeroCeldas];
		cantidadMaximaCelda = 0;
	}

	/**
	 * Inicialización de una máquina con argumentos
	 * 
	 * @param numeroCeldas: Número de espacios disponibles en la máquina
	 * @param productos: Vector con los productos que se quieren almacenar en la máquina
	 * @param cantidades: Vector con las cantidades de cada producto que se quiere almacenar
	 * @param cantidadMaximaCelda: Máxima cantidad de producto que se puede almacenar en cada celda
	 * 
	 * @assert.pre Número de celdas tiene que ser positivo
	 * @assert.pre <br> La longitud del vector de productos debe ser menor o igual al número
	 *             de celdas
	 * @assert.pre <br> La longitud del vector de productos debe ser igual a la longitud del 
	 * 			   vector de cantidades
	 * @assert.pre <br> La cantidad máxima de cada celda ha de ser positiva
	 * @assert.pre <br> Todos los elementos del vector cantidades han de ser mayores o iguales que 0 y 
	 * 			   menores o iguales que la cantidad máxima de cada celda
	 */
	public MaquinaVending(int numeroCeldas, Producto[] productos, int[] cantidades, int cantidadMaximaCelda) {
		assert (numeroCeldas > 0); 
		assert (productos.length <= numeroCeldas);
		//las longitudes deben de ser iguales porque cada producto tiene asociado una cantidad
		assert (productos.length == cantidades.length); 
		assert (cantidadMaximaCelda > 0);
		//la mínima cantidad del vector de cantidades tiene que ser no negativo y 
		//la máxima cantidad tiene que ser menor o igual que la cantidad máxima de cada celda
		assert (minimaMaximaCantidad(cantidades)[0] >= 0 && minimaMaximaCantidad(cantidades)[1] <= cantidadMaximaCelda);

		this.numeroCeldas = numeroCeldas;
		this.productos = productos;
		this.cantidades = cantidades;
		this.cantidadMaximaCelda = cantidadMaximaCelda;
	}

	/* Devuelve un vector con el menor y el mayor elemento del vector de cantidades */
	private int[] minimaMaximaCantidad(int[] cantidades) {
		int[] minimoMaximo = new int[2]; //vector donde se almacenarán la menor y la mayor cantidad respectivamente
		int[] cantidadAuxiliar = new int[cantidades.length]; //copia del vector cantidades
		
		//realiza la copia del vector cantidades
		for (int i = 0; i <= cantidades.length - 1; i++) 
			cantidadAuxiliar[i] = cantidades[i];
		
		Arrays.sort(cantidadAuxiliar); //ordena la copia del vector
		
		minimoMaximo[0] = cantidadAuxiliar[0]; //almacena la cantidad más baja 
		minimoMaximo[1] = cantidadAuxiliar[cantidadAuxiliar.length - 1]; //almacena la cantidad más alta
		
		return minimoMaximo;
	}

	/**
	 * Devuelve el precio del producto de la celda indicada
	 * 
	 * @param identificadorCelda: Número de la celda 
	 * 
	 * @return Precio del producto que está en la celda
	 * 
	 * @assert.pre El identificador de la celda ha de ser mayor que 0 y menor que el número de celdas de {@code this} 
	 */
	public double darPrecioCelda(int identificadorCelda) {
		assert (identificadorCelda > 0 && identificadorCelda <= numeroCeldas);
		
		return productos[identificadorCelda - 1].getPrecio();
	}

	/**
	 * Devuelve la cantidad del producto de la celda indicada
	 * 
	 * @param identificadorCelda: Número de la celda
	 * 
	 * @return Cantidad de producto que está en la celda
	 * 
	 * @assert.pre El identificador de la celda ha de ser mayor que 0 y menor que el número de celdas de {@code this}
	 */
	public int darCantidadCelda(int identificadorCelda) {
		assert (identificadorCelda > 0 && identificadorCelda <= numeroCeldas);
		
		return cantidades[identificadorCelda - 1];
	}

	/**
	 * Devuelve el nombre del producto que está en la celda indicada
	 * 
	 * @param identificadorCelda: Número de la celda
	 * 
	 * @return Nombre del producto que está en la celda 
	 * 
	 * @assert.pre El identificador de la celda ha de ser mayor que 0 y menor que el número de celdas de {@code this}
	 */
	public String darNombreProductos(int identificadorCelda) {
		assert (identificadorCelda > 0 && identificadorCelda <= numeroCeldas);
		
		return productos[identificadorCelda - 1].getNombre();
	}

	/**
	 * Devuelve el número de celdas de {@code this}
	 * 
	 * @return Número de celdas
	 */
	public int getNumeroCeldas() {
		return numeroCeldas;
	}

	/**
	 * Devuelve el vector de productos {@code this}
	 * 
	 * @return Productos
	 */
	public Producto[] getProductos() {
		return productos;
	}

	/**
	 * Devuelve el vector de cantidades de {@code this}
	 * 
	 * @return Cantidades de los productos
	 */
	public int[] getCantidades() {
		return cantidades;
	}
	
	/**
	 * Devuelve la cantidad máxima de cada celda
	 * 
	 * @return Cantidad máxima de cada celda
	 */
	public int getCantidadMaximaCelda() {
		return cantidadMaximaCelda;
	}

	/**
	 * Descuenta el precio del producto de la celda dada al saldo actual de la tarjeta y decrementa 
	 * en una unidad la cantidad de producto existente en la celda
	 * 
	 * @see TarjetaMonedero
	 * 
	 * @param identificadorCelda: Número de la celda
	 * @param tarjeta: Tarjeta con la que se realiza la venta
	 * @param credencial: Código aportado por el código cliente 
	 * 
	 * @return Tarjeta con el saldo modificado tras la venta
	 * 
	 * @assert.pre El identificador de la celda ha de ser mayor que 0 y menor que el número de celdas de {@code this}
	 * @assert.pre <br> La cantidad de la celda indicada tiene que ser positiva
	 */
	public TarjetaMonedero venderProducto(int identificadorCelda, TarjetaMonedero tarjeta, String credencial) {
		assert (identificadorCelda > 0 && identificadorCelda <= numeroCeldas);
		assert (cantidades[identificadorCelda - 1] > 0);
		
		//descuenta del saldo actual de la tarjeta el precio del producto aportándole una credencial correcta 
		tarjeta.descontarDelSaldo(credencial, darPrecioCelda(identificadorCelda));
		cantidades[identificadorCelda - 1]--;
		
		return tarjeta;
	}

	/**
	 * Modifica la cantidad del producto de una celda de {@code this} 
	 * 
	 * @param identificadorCelda: Número de la celda
	 * @param variacionCantidad: Cantidad que se quiere incrementar o disminuir
	 * 
	 * @return Vector de las cantidades de los productos modificados
	 * 
	 * @assert.pre El identificador de la celda ha de ser mayor que 0 y menor que el número de celdas de {@code this}
	 * @assert.pre <br> El resultado de la variación no puede ser negativo ni superar la cantidad máxima de cada celda
	 * @assert.pre <br> La variación no puede ser nula
	 */
	public int[] modificarCantidadCelda(int identificadorCelda, int variacionCantidad) {
		assert (identificadorCelda > 0 && identificadorCelda <= numeroCeldas);
		assert (variacionCantidad >= -cantidades[identificadorCelda - 1] && cantidades[identificadorCelda - 1] + variacionCantidad <= cantidadMaximaCelda);
		assert (variacionCantidad != 0);
		
		cantidades[identificadorCelda - 1] = cantidades[identificadorCelda - 1] + variacionCantidad;
		
		return cantidades;
	}

	/**
	 * Cambia el producto de una celda por otro producto con una cantidad dada
	 * 
	 * @param identificadorCelda: Número de celda
	 * @param nuevoProducto: Producto por el que se quiere cambiar
	 * @param nuevaCantidad: Cantidad del nuevo producto
	 * 
	 * @return {@code this} modificado con el nuevo producto y cantidad
	 * 
	 * @assert.pre El identificador de la celda ha de ser mayor que 0 y menor que el número de celdas de {@code this}
	 * @assert.pre <br> La cantidad del producto nuevo tiene que ser mayor o igual que 0 y menor o igual que la cantidad máxima de la celda
	 */
	public MaquinaVending modificarProductosCantidades(int identificadorCelda, Producto nuevoProducto, int nuevaCantidad) {
		assert (identificadorCelda > 0 && identificadorCelda <= numeroCeldas);
		assert (nuevaCantidad >= 0 && nuevaCantidad <= cantidadMaximaCelda);
		
		productos[identificadorCelda - 1] = nuevoProducto;
		cantidades[identificadorCelda - 1] = nuevaCantidad;
		
		return this;
	}
	
	/**
	 * Modifica el número de celdas de {@code this} inicializando los vectores de productos y cantidades vacios con longitud igual al número de celdas
	 * 
	 * @param numeroCeldas: Nuevo número de celdas que tendrá la máquina
	 * 
	 * @return nuevo número de celdas
	 * 
	 * @assert.pre El número de celdas ha de ser positivo
	 */
	public int setNumeroCeldas(int numeroCeldas) {
		assert (numeroCeldas > 0);
		
		productos = new Producto[numeroCeldas]; //Se inicializa el vector de productos
		cantidades = new int[numeroCeldas]; //Se inicializa el vector de cantidades

		return this.numeroCeldas = numeroCeldas;
	}
	
	/**
	 * Modifica el vector de productos de {@code this} 
	 * 
	 * @param productos: Nuevos productos que tendrá la maquina
	 * 
	 * @return Vector de productos modificado
	 * 
	 * @assert.pre La longitud del nuevo vector de productos ha de ser menor o igual que el número de celdas de {@code this}
	 */
	public Producto[] setProductos(Producto[] productos) {
		assert (productos.length <= numeroCeldas);
		
		//Asigna a cada posicion del vector productos el nuevo producto
		for (int i = 0; i <= productos.length - 1; i++)
			this.productos[i] = productos[i];
		
		return this.productos;
	}

	/**
	 * Modifica el vector de cantidades de {@code this} 
	 * 
	 * @param cantidades: Nuevas cantidades que tendrán los productos de la máquina
	 * 
	 * @return Vector de cantidades modificado
	 * 
	 * @assert.pre La longitud del nuevo vector de cantidades ha de ser menor o igual que el número de celdas de {@code this}
	 * @assert.pre <br> Todos los elementos del vector cantidades han de ser mayores o iguales que 0 y 
	 * 			   menores o iguales que la cantidad máxima de cada celda
	 */
	public int[] setCantidades(int[] cantidades) {
		assert (cantidades.length <= numeroCeldas);
		assert (minimaMaximaCantidad(cantidades)[0] >= 0 && minimaMaximaCantidad(cantidades)[1] <= cantidadMaximaCelda);

		//Asigna a cada posición del vector cantidades la nueva cantidad de cada producto
		for (int i = 0; i <= cantidades.length - 1; i++)
			this.cantidades[i] = cantidades[i];
		
		return this.cantidades;
	}

	/**
	 * Modifica la cantidad máxima de cada celda de {@code this} 
	 * 
	 * @param cantidadMaximaCelda: Nueva cantidad en cada celda
	 * 
	 * @return Nueva cantidad máxima de cada celda
	 * 
	 * @assert.pre La nueva cantidad máxima ha de ser positiva
	 */ 
	public int setCantidadMaximaCelda(int cantidadMaximaCelda) {
		assert (cantidadMaximaCelda > 0);
		
		return this.cantidadMaximaCelda = cantidadMaximaCelda;
	}

}