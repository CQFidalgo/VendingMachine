package uva.inf.poo.Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import uva.inf.poo.Entrega2.Pack;
import uva.inf.poo.Entrega2.Producto;

public class PackTest {

	
	@Test
	public void testPackConArgumentosValidos() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		
		Pack pack = new Pack("Merienda","123",productos);
		
		assertEquals(pack.getNombre(),"Merienda");
		assertEquals(pack.getIdentificador(),"123");
		assertEquals(pack.getNumeroProductos(),2);
		assertArrayEquals(pack.DarProductosPack(),productos);
	}
	
	@Test(expected = AssertionError.class)
	public void testPackConNombreVacio(){
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		
		@SuppressWarnings("unused")
		Pack pack = new Pack("","123",productos);
	}
	
	@Test(expected = AssertionError.class)
	public void testPackConUnProducto(){
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto [] productos = {p1};
		
		@SuppressWarnings("unused")
		Pack pack = new Pack("Merienda","123",productos);
	}
	
	@Test(expected = AssertionError.class)
	public void testPackConIdentificadorVacio(){
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		
		@SuppressWarnings("unused")
		Pack pack = new Pack("Merienda","",productos);
	}
	
	@Test(expected = AssertionError.class)
	public void testPackConProductosRepetidos(){
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2,p2};
		
		@SuppressWarnings("unused")
		Pack pack = new Pack("Merienda","123",productos);
	}
	
	
	
	@Test
	public void testGetPrecio() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};		
		Pack pack = new Pack("Merienda","123",productos);
		
		assertEquals(pack.getPrecio(),0.8*(p1.getPrecio()+p2.getPrecio()),0.001);
	}



	@Test
	public void testIncluirProductoPackQueNoEsta() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};		
		Pack pack = new Pack("Merienda","123",productos);
		
		Producto p3 = new Producto("Manzana","823880024474",2.1);
		pack.incluirProductoPack(p3);
		
		assertEquals(pack.getNumeroProductos(),3);
		assertEquals(pack.DarProductosPack()[2],p3);
	}
	
	@Test (expected = AssertionError.class)
	public void testIncluirProductoPackQueEsta() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};		
		Pack pack = new Pack("Merienda","123",productos);
		
		Producto p3 = p2;
		pack.incluirProductoPack(p3);
	}

	@Test
	public void testQuitarProductoPackTamanoMayoQue2ProductoQueEsta() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto p3 = new Producto("Manzana","823880024474",2.1);
		Producto [] productos = {p1,p2,p3};
		Pack pack = new Pack("Merienda","123",productos);
		Producto [] nuevosProductos = {p2,p3};
		
		pack.quitarProductoPack(p1);
		
		assertEquals(pack.getNumeroProductos(),2);
		assertArrayEquals(pack.DarProductosPack(),nuevosProductos);
	}
	
	@Test (expected = AssertionError.class)
	public void testQuitarProductoPackQueNoEsta() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto p3 = new Producto("Manzana","823880024474",2.1);
		Producto p4 = new Producto("Gusanitos","123456789128",0.8);
		Producto [] productos = {p1,p2,p3};
		Pack pack = new Pack("Merienda","123",productos);
		
		pack.quitarProductoPack(p4);
	}

	
	@Test (expected = AssertionError.class)
	public void testQuitarProductoPackTamano2() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Pack pack = new Pack("Merienda","123",productos);
	
		pack.quitarProductoPack(p1);

	}
	@Test
	public void testGetNumeroProductos() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Pack pack = new Pack("Merienda","123",productos);
		
		assertEquals(pack.getNumeroProductos(),2);
	}

	@Test
	public void testDarProductosPack() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Pack pack = new Pack("Merienda","123",productos);
		
		assertArrayEquals(pack.DarProductosPack(),productos);
	}

	@Test
	public void testSaberProductoQueEsta() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Pack pack = new Pack("Merienda","123",productos);
		
		assertTrue(pack.saberProducto(p1));
	}
	
	@Test
	public void testSaberProductoQueNoEsta() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Pack pack = new Pack("Merienda","123",productos);
		Producto p3 = new Producto("Manzana","823880024474",2.1);
		
		assertFalse(pack.saberProducto(p3));
	}

	@Test
	public void testGetNombre() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Pack pack = new Pack("Merienda","123",productos);
		
		assertEquals(pack.getNombre(),"Merienda");
	}

	@Test
	public void testGetIdentificador() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Pack pack = new Pack("Merienda","123",productos);
		
		assertEquals(pack.getIdentificador(),"123");
	}

}
