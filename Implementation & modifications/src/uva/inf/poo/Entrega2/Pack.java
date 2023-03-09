/**
 * @author CQFidalgo 
 */

package uva.inf.poo.Entrega2;

import java.util.ArrayList;

import uva.inf.poo.Entrega2.Producto;



/**Implementación de un pack como tipo particular de Vendible, que
 *         estará formado por varios productos
 * 
 */
public class Pack extends Vendible {

	// atributos
	private int numeroProductos;
	private ArrayList<Producto> Pack; // ArrayList que almacenará los productos
										// del pack

	/**
	 * Inicialización de un pack con argumentos
	 * 
	 * @see Vendible#Vendible(String nombre, String identificador)
	 *  
	 * @param nombre:
	 *            Nombre del pack
	 * @param identificador:
	 *            Código identificador del pack dado por la empresa
	 * @param productos:
	 *            Array de productos que forman el pack
	 * 
	 * @assert.pre El array de productos debe de tener al menos dos elementos
	 *             distintos
	 * @assert.pre <br> No debe haber elementos repetidos en el array de productos
	 */
	public Pack(String nombre, String identificador, Producto productos[]) {
		super(nombre, identificador);
		assert (productos.length >= 2);

		// Comprueba que en el array de productos no hay elementos iguales
		for (int i = 0; i < productos.length - 1; i++) { 
			for (int j = i + 1; j < productos.length; j++) {
				// Si hay algún producto repetido se genera una excepción
				// mediante aserto
				assert (productos[i].getIdentificador() != productos[j].getIdentificador());
			}
		}

		// crea y llena Pack con los productos del array "productos"
		Pack = new ArrayList<Producto>(productos.length);
		for (int i = 0; i < productos.length; i++) {
			Pack.add(productos[i]);
		}

		numeroProductos = Pack.size();
	}

	/**
	 * Comprueba si un producto pertenece a {@code this}
	 * 
	 * @param producto:
	 *            Producto a comprobar
	 * 
	 * @return {@code True} si el producto está incluido, {@code False} en caso
	 *         contrario
	 */
	public boolean saberProducto(Producto producto) {

		// comprueba que el identificador del producto sea igual al de ninguno
		// de los productos del pack
		for (int i = 0; i < numeroProductos; i++) {
			if (Pack.get(i).getIdentificador() == producto.getIdentificador())
				return true;
		}
		return false;
	}

	/**
	 * Añade un producto nuevo al pack
	 * 
	 * @param productoNuevo:
	 *            Nuevo producto que se quiere incluir
	 * 
	 * @assert.pre El producto no debe estar incluido en el pack
	 */
	public void incluirProductoPack(Producto productoNuevo) {
		assert (saberProducto(productoNuevo) == false);
		Pack.add(productoNuevo);
		numeroProductos++;

	}

	/**
	 * Elimina un producto del pack
	 * 
	 * @param producto: Producto que se desea eliminar
	 * 
	 * @assert.pre El producto debe de estar en el pack
	 * @assert.pre <br> El pack debe tener mínimo 3 productos
	 */
	public void quitarProductoPack(Producto producto) {
		assert (saberProducto(producto));
		assert (numeroProductos >= 3);

		//Busca la posición en el pack del producto a quitar a partir del UPC y lo elimina
		for (int i = 0; i < Pack.size(); i++) {
			if (Pack.get(i).getIdentificador() == producto.getIdentificador()) {
				Pack.remove(i);
			}
		}
		numeroProductos--;
	}

	/**
	 * Devuelve el número de productos que conforman {@code this}
	 * 
	 * @return Número de elementos del pack
	 */
	public int getNumeroProductos() {
		return numeroProductos;
	}

	/**
	 * Devuelve los productos que conforman {@code this}
	 * 
	 * @return Productos del pack
	 */
	public Producto[] DarProductosPack() {
		Producto productosPack[] = new Producto[Pack.size()];
		
		//Almacena elemento a elemento los productos del pack en un array de Productos
		for (int i = 0; i < numeroProductos; i++) 
			productosPack[i] = Pack.get(i);

		return productosPack;
	}

	/**
	 * Devuelve el precio de {@code this}
	 * 
	 * @see Vendible#getPrecio()
	 * 
	 * @return Precio del pack, que será el 80% de la suma del precio de los
	 *         productos que lo forman
	 * 
	 */
	@Override
	public double getPrecio() {
		double sumaProductos = 0, sumaPack;
		double descuento = 0.8;

		//Suma los precios de los productos del pack
		for (int i = 0; i < numeroProductos; i++) {
			sumaProductos = sumaProductos + Pack.get(i).getPrecio();
		}
		//Calcula el precio del pack
		sumaPack = sumaProductos * descuento;
		return sumaPack;
	}
}
