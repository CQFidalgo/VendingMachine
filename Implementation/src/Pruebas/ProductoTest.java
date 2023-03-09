package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import Practica1.Producto;

/**
 * Métodos de prueba de la clase Producto
 * 
 * @author CQFidalgo
 */

public class ProductoTest {

	@Test
	public void testInicializarProductoSinArgumentos() {
		Producto p = new Producto();

		assertEquals(p.getPrecio(), 0, 0.01);
		assertNull(p.getNombre());
		assertNull(p.getUPC());
	}

	@Test
	public void testInicializarProductoConArgumentosCorrectos() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");

		assertEquals(p.getPrecio(), 4.0, 0.01);
		assertEquals(p.getNombre(), "KitKat Blanco");
		assertEquals(p.getUPC(), "875555012767");
	}

	@Test(expected = AssertionError.class)
	public void testInicializarProductoConPrecioCero() {
		@SuppressWarnings("unused")
		Producto p = new Producto(0.0, "KitKat Blanco", "875555012767");
	}

	@Test(expected = AssertionError.class)
	public void testInicializarProductoConPrecioNegativo() {
		@SuppressWarnings("unused")
		Producto p = new Producto(-0.01, "KitKat Blanco", "875555012767");
	}

	@Test(expected = AssertionError.class)
	public void testInicializarProductoConUPC12incorrecto() {
		@SuppressWarnings("unused")
		Producto p = new Producto(2.0, "KitKat Blanco", "875555012765");
	}

	@Test(expected = AssertionError.class)
	public void testInicializarProductoConUPC11() {
		@SuppressWarnings("unused")
		Producto p = new Producto(2.0, "KitKat Blanco", "87555501276");
	}

	@Test(expected = AssertionError.class)
	public void testInicializarProductoConUPC13() {
		@SuppressWarnings("unused")
		Producto p = new Producto(2.0, "KitKat Blanco", "8755550127678");
	}

	@Test
	public void testGetPrecio() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");

		assertEquals(p.getPrecio(), 4.0, 0.1);
	}

	@Test
	public void testGetNombre() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");

		assertEquals(p.getNombre(), "KitKat Blanco");
	}

	@Test
	public void testGetUPC() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");

		assertEquals(p.getUPC(), "875555012767");
	}

	@Test
	public void testSetPrecioConCantidadCorrecta() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");

		assertEquals(p.setPrecio(-3.9), 0.1, 0.1);

	}

	@Test(expected = AssertionError.class)
	public void testSetPrecioConCantidadIncorrectaExacta() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");
		p.setPrecio(-4.0);
	}

	@Test(expected = AssertionError.class)
	public void testSetPrecioConCantidadIncorrectaMayor() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");
		p.setPrecio(-4.1);
	}

	@Test
	public void testSetNombre() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");

		assertEquals(p.setNombre("KitKat Negro"), "KitKat Negro");
	}

	@Test
	public void testSetUPCCorrecto() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");

		assertEquals(p.setUPC("823880024474"), "823880024474");
	}

	@Test(expected = AssertionError.class)
	public void testSetUPCIncorrecto13() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");
		p.setUPC("3800020423951");
	}

	@Test(expected = AssertionError.class)
	public void testSetUPCIncorrecto11() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");
		p.setUPC("87555501276");
	}

	@Test(expected = AssertionError.class)
	public void testSetUPCIncorrecto12() {
		Producto p = new Producto(4.0, "KitKat Blanco", "875555012767");
		p.setUPC("875555012768");
	}

}