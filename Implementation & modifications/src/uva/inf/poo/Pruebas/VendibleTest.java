package uva.inf.poo.Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import uva.inf.poo.Entrega2.Pack;
import uva.inf.poo.Entrega2.Producto;
import uva.inf.poo.Entrega2.Vendible;

//Clase de pruebas para probar los objetos Producto y PAck polimorficamente desde entidades de tipo Vendible, probando los metodos
//implementados en la clase Vendible
public class VendibleTest {


	@Test
	public void testGetNombreProducto() {
		Vendible v = new Producto("KitKat","875555012767",3.5);
		assertEquals(v.getNombre(),"KitKat");
	}
	
	@Test
	public void testGetNombrePack() {
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Vendible v = new Pack("Merienda","123",productos);
		
		assertEquals(v.getNombre(),"Merienda");
	}
	

	@Test
	public void testGetIdentificadorProducto() {
		Vendible v = new Producto("KitKat","875555012767",3.5);
		assertEquals(v.getIdentificador(),"875555012767");
	}
	
	@Test
	public void testGetIdentificadorPack(){
		Producto p1 = new Producto("KitKat","875555012767",3.5);
		Producto p2 = new Producto("Agua", "123456789104",1.0);
		Producto [] productos = {p1,p2};
		Vendible v = new Pack("Merienda","123",productos);
		
		assertEquals(v.getIdentificador(),"123");
	}

}
