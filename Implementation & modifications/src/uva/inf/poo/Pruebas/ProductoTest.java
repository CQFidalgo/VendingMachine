package uva.inf.poo.Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import uva.inf.poo.Entrega2.Producto;

public class ProductoTest {

	
	
	@Test
	public void testProductoConArgumentosValidos() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		assertEquals(p.getNombre(),"KitKat");
		assertEquals(p.getIdentificador(),"875555012767");
		assertEquals(p.getPrecio(),3.5,0.001);
		
	}
	
	@Test(expected = AssertionError.class)
	public void testProductoConNombreNull() {
		@SuppressWarnings("unused")
		Producto p =new Producto("","875555012767",3.5);		
	}
	
	@Test(expected = AssertionError.class)
	public void testProductoConIdentificadorDe11() {
		@SuppressWarnings("unused")
		Producto p =new Producto("KitKat","87555501276",3.5);		
	}
	
	@Test(expected = AssertionError.class)
	public void testProductoConIdentificadorDe13() {
		@SuppressWarnings("unused")
		Producto p =new Producto("KitKat","8755550127673",3.5);		
	}
	
	@Test(expected = AssertionError.class)
	public void testProductoConIdentificadorDe12Incorrecto() {
		@SuppressWarnings("unused")
		Producto p =new Producto("KitKat","875555012761",3.5);		
	}
	
	@Test(expected = AssertionError.class)
	public void testProductoConPrecioNulo() {
		@SuppressWarnings("unused")
		Producto p =new Producto("KitKat","875555012767",0.0);		
	}
	
	
	@Test(expected = AssertionError.class)
	public void testProductoConPrecioNegativo() {
		@SuppressWarnings("unused")
		Producto p =new Producto("KitKat","875555012767",-3.5);		
	}
	
	
	
	@Test
	public void testGetPrecio() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		assertEquals(p.getPrecio(),3.5,0.001);

	}


	@Test
	public void testSetPrecioCorrecto() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		p.setPrecio(-3.4);
		assertEquals(p.getPrecio(),0.1,0.001);

	}
	
	@Test(expected = AssertionError.class)
	public void testSetPrecioConCantidadIncorrectaExacta() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		p.setPrecio(-3.5);

	}
	
	@Test(expected = AssertionError.class)
	public void testSetPrecioConCantidadIncorrectMayor() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		p.setPrecio(-3.6);

	}

	@Test
	public void testComprobarUpcDe12Correcto() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		assertTrue(p.comprobarUpc("875555012767"));
	}
	
	@Test
	public void testComprobarUpcDe12Incorrecto() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		assertFalse(p.comprobarUpc("875555012763"));
	}
	
	@Test(expected = AssertionError.class)
	public void testComprobarUpcDe11Incorrecto() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		p.comprobarUpc("87555501276");
	}
	
	@Test(expected = AssertionError.class)
	public void testComprobarUpcDe13Incorrecto() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		
		p.comprobarUpc("8755550127672");
	}

	@Test
	public void testGetNombre() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		assertEquals(p.getNombre(),"KitKat");

	}

	@Test
	public void testGetIdentificador() {
		Producto p =new Producto("KitKat","875555012767",3.5);
		assertEquals(p.getIdentificador(),"875555012767");
	}

}
