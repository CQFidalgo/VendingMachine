package Pruebas;

import static org.junit.Assert.*;
import org.junit.Test;
import Practica1.Producto;
import Practica1.MaquinaVending;
import fabricante.externo.tarjetas.*;

/**
 * Métodos de prueba de la clase MaquinaVending
 * 
 * @author CQFidalgo
 */

public class MaquinaVendingTest {

	@Test
	public void testMaquinaVendingInicializarSinArgumentos() {
		MaquinaVending maquina = new MaquinaVending();
		
		assertEquals(maquina.getNumeroCeldas(),0);
		assertEquals(maquina.getProductos().length,0);
		assertEquals(maquina.getCantidades().length,0);
		assertEquals(maquina.getCantidadMaximaCelda(),0);
	}

	@Test
	public void testMaquinaVendingInicializarConArgumentosCorrectos() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,0};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		
		assertEquals(maquina.getNumeroCeldas(),2);
		assertArrayEquals(maquina.getProductos(),productos);
		assertArrayEquals(maquina.getCantidades(),cantidades);
		assertEquals(maquina.getCantidadMaximaCelda(),10);	
	}
	
	@Test (expected = AssertionError.class)
	public void testMaquinaVendingInicializarConNumeroCeldasNegativo() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,8};
		
		@SuppressWarnings("unused")
		MaquinaVending maquina = new MaquinaVending(-1,productos, cantidades, 10);
	}
	
	@Test (expected = AssertionError.class)
	public void testMaquinaVendingInicializarConMasProductosQueCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3};
		
		@SuppressWarnings("unused")
		MaquinaVending maquina = new MaquinaVending(1,productos, cantidades, 10);
	}
	
	@Test (expected = AssertionError.class)
	public void testMaquinaVendingInicializarConMenosNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,8};
		
		@SuppressWarnings("unused")
		MaquinaVending maquina = new MaquinaVending(1,productos, cantidades, 10);
	}
	
	@Test (expected = AssertionError.class)
	public void testMaquinaVendingInicializarConDistintasLongitudesProductosCantidades() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,8,9};
		
		@SuppressWarnings("unused")
		MaquinaVending maquina = new MaquinaVending(6,productos, cantidades, 10);
	}
	
	@Test (expected = AssertionError.class)
	public void testMaquinaVendingInicializarConCantidadMaxima0() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,8};
		
		@SuppressWarnings("unused")
		MaquinaVending maquina = new MaquinaVending(6,productos, cantidades, 0);
	}
	
	@Test (expected = AssertionError.class)
	public void testMaquinaVendingInicializarConCantidadNegativa() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={5,-1};
		
		@SuppressWarnings("unused")
		MaquinaVending maquina = new MaquinaVending(6,productos, cantidades, 10);
	}
	
	@Test (expected = AssertionError.class)
	public void testMaquinaVendingInicializarConCantidadMayorQueCantidadMaxima() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={11,1};
		
		@SuppressWarnings("unused")
		MaquinaVending maquina = new MaquinaVending(6,productos, cantidades, 10);
	}
	

	@Test 
	public void testDarPrecioCeldaCorrecto() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		
		assertEquals(maquina.darPrecioCelda(2), 4.5, 0.1);
	}
	
	@Test(expected = AssertionError.class)
	public void testDarPrecioCeldaMenorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		maquina.darPrecioCelda(0);
	}

	@Test(expected = AssertionError.class)
	public void testDarPrecioCeldaMayorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		maquina.darPrecioCelda(3);
	}

	@Test
	public void testDarCantidadCeldaCorrecta() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		
		assertEquals(maquina.darCantidadCelda(2), 2);
	}

	@Test(expected = AssertionError.class)
	public void testDarCantidadCeldaMenorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		maquina.darCantidadCelda(0);
	}

	@Test(expected = AssertionError.class)
	public void testDaCantidadCeldaMayorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		maquina.darCantidadCelda(3);
	}

	@Test
	public void testDarNombreProductosCeldaCorrecta() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		
		assertEquals(maquina.darNombreProductos(2),"KitKat Negro");	
	}
		
	@Test(expected = AssertionError.class)
	public void testDarNombreProductosCeldaMenorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		maquina.darNombreProductos(0);
	}

	@Test(expected = AssertionError.class)
	public void testDarNombreProductosCeldaMayorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = { p1, p2 };
		int[] cantidades = { 3, 2 };

		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		maquina.darNombreProductos(3);
	}

	@Test
	public void testGetNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		
		assertEquals(maquina.getNumeroCeldas(),2);
	}

	@Test
	public void testGetProductos() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		
		assertArrayEquals(maquina.getProductos(),productos);
	}

	@Test
	public void testGetCantidades() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		
		assertArrayEquals(maquina.getCantidades(),cantidades);
	}

	@Test
	public void testGetCantidadMaximaCelda() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		
		assertEquals(maquina.getCantidadMaximaCelda(),10);
	}
	

	@Test
	public void testVenderProductoCorrrecto() {
		TarjetaMonedero tarjeta = new TarjetaMonedero ("A156Bv09_1zXo894", 10);
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.venderProducto(1, tarjeta, "6Z1y00Nm31aA-571");
		
		assertEquals(tarjeta.getSaldoActual(), 6, 0.001);
		assertEquals(maquina.darCantidadCelda(1), 2);
	}
	
	@Test (expected = AssertionError.class)
	public void testVenderProductoCantidadCero() {
		TarjetaMonedero tarjeta = new TarjetaMonedero ("A156Bv09_1zXo894", 10);
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,0};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.venderProducto(2, tarjeta, "6Z1y00Nm31aA-571");
	}
	
	@Test (expected = AssertionError.class)
	public void testVenderProductoNumeroCeldaCero() {
		TarjetaMonedero tarjeta = new TarjetaMonedero ("A156Bv09_1zXo894", 10);
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,0};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.venderProducto(0, tarjeta, "6Z1y00Nm31aA-571");
	}
	
	@Test (expected = AssertionError.class)
	public void testVenderProductoCeldaMayorQueNumeroCeldas() {
		TarjetaMonedero tarjeta = new TarjetaMonedero ("A156Bv09_1zXo894", 10);
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,0};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.venderProducto(3, tarjeta, "6Z1y00Nm31aA-571");
	}

	@Test
	public void testModificarCantidadCeldaConArgumentosCorrectos() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		
		assertEquals(maquina.modificarCantidadCelda(2, 1)[1],3);
	}

	@Test (expected = AssertionError.class)
	public void testModificarCantidadCeldaMenorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarCantidadCelda(0, 1);
	}
	
	@Test (expected = AssertionError.class)
	public void testModificarCantidadCeldaMayorQueNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarCantidadCelda(3, 1);
	}
	
	@Test (expected = AssertionError.class)
	public void testModificarCantidadCeldaVariacionCero() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarCantidadCelda(2, 0);
	}
	
	@Test (expected = AssertionError.class)
	public void testModificarCantidadCeldaVariacionExcesivaNegativa() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarCantidadCelda(2, -3);
	}
	
	@Test (expected = AssertionError.class)
	public void testModificarCantidadCeldaVariacionExcesivaPositiva() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarCantidadCelda(2,9);
	}
	@Test
	public void testModificarProductosCantidadesArgumentosCorrectos() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		Producto p3 = new Producto(3.0, "Agua", "823880024474");
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarProductosCantidades(2, p3, 4);
		assertEquals(maquina.getProductos()[1], p3);
		assertEquals(maquina.darCantidadCelda(2), 4);
	}

	@Test (expected = AssertionError.class)
	public void testModificarProductosCantidadesCeldaMenorNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1, p2};
		Producto p3 = new Producto(3.0, "Agua", "823880024474");
		int [] cantidades ={3, 2};
		
		MaquinaVending maquina = new MaquinaVending(2, productos, cantidades, 10);
		maquina.modificarProductosCantidades(0, p3, 3);
	}
	
	@Test (expected = AssertionError.class)
	public void testModificarProductosCantidadesCeldaMayorNumeroCeldas() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		Producto p3 = new Producto(3.0, "Agua", "823880024474");
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarProductosCantidades(3, p3,4);
	}
	
	@Test (expected = AssertionError.class)
	public void testModificarProductosCantidadesConCantidadNegativa() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		Producto p3 = new Producto(3.0, "Agua", "823880024474");
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarProductosCantidades(3, p3,-1);
	}
	
	@Test (expected = AssertionError.class)
	public void testModificarProductosCantidadesConCantidadMayorQueCantidadMaxima() {
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		Producto p3 = new Producto(3.0, "Agua", "823880024474");
		int [] cantidades ={3,2};
		
		MaquinaVending maquina = new MaquinaVending(2,productos, cantidades, 10);
		maquina.modificarProductosCantidades(3, p3,11);
	}
	
	
	@Test
	public void testSetNumeroCeldasMayorQueCero() {
		MaquinaVending maquina = new MaquinaVending();
		
		assertEquals(maquina.setNumeroCeldas(4),4);
	
	}
	@Test (expected = AssertionError.class)
	public void testSetNumeroCeldasCero() {
		MaquinaVending maquina = new MaquinaVending();
		maquina.setNumeroCeldas(0);
	
	}

	@Test
	public void testSetProductos() {
		MaquinaVending maquina = new MaquinaVending();
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		maquina.setNumeroCeldas(2);
		
		assertArrayEquals(maquina.setProductos(productos),productos);

	}

	@Test (expected = AssertionError.class)
	public void testSetMasProductosQueCeldas() {
		MaquinaVending maquina = new MaquinaVending();
		Producto p1 = new Producto(4.0, "KitKat Blanco", "875555012767");
		Producto p2 = new Producto(4.5, "KitKat Negro", "123456789104");
		Producto[] productos = {p1,p2};
		maquina.setNumeroCeldas(1);
		maquina.setProductos(productos);

	}
	@Test
	public void testSetCantidades() {
		int [] cantidades ={3,0};
		MaquinaVending maquina = new MaquinaVending();
		maquina.setNumeroCeldas(2);
		maquina.setCantidadMaximaCelda(10);
		
		assertArrayEquals(maquina.setCantidades(cantidades),cantidades);
	}
	
	@Test (expected = AssertionError.class)
	public void testSetMasCantidadesQueCeldas() {
		int [] cantidades ={3,0,5};
		MaquinaVending maquina = new MaquinaVending();
		maquina.setNumeroCeldas(2);
		maquina.setCantidades(cantidades);
	}
	
	@Test (expected = AssertionError.class)
	public void testSetCantidadesAlgunaNegativa() {
		int [] cantidades ={3,-1};
		MaquinaVending maquina = new MaquinaVending();
		maquina.setNumeroCeldas(2);
		maquina.setCantidades(cantidades);
	}
	
	@Test (expected = AssertionError.class)
	public void testSetCantidadesAlgunaMayorQueCantidadMaxima() {
		int [] cantidades ={3,11};
		MaquinaVending maquina = new MaquinaVending();
		maquina.setNumeroCeldas(2);
		maquina.setCantidadMaximaCelda(10);
		maquina.setCantidades(cantidades);
	}

	@Test
	public void testSetCantidadMaximaCelda() {
		MaquinaVending maquina = new MaquinaVending();
		
		assertEquals(maquina.setCantidadMaximaCelda(1),1);
	}

	@Test(expected = AssertionError.class)
	public void testSetCantidadMaximaCeldaCero() {
		MaquinaVending maquina = new MaquinaVending();
		maquina.setCantidadMaximaCelda(0);
	}

}
