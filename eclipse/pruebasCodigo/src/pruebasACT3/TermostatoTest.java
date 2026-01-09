package pruebasACT3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermostatoTest
{

	private static Termostato t1;
	
	@BeforeEach
	public static void Termostato() 
	{
		t1 = new Termostato(10, 30, 20);
	}
	
	@Test
	void test_isEncendido() 
	{
		boolean encendido = t1.isEncendido();
		assertEquals(false, encendido);
	}
	
	@Test
	void test_getTemperaturaActual() 
	{
		double tempIni= t1.getTemperaturaActual();
		assertEquals(20, tempIni);
	}
	
	@Test
	void test_getTemperaturaMin() 
	{
		double tempMin= t1.getTemperaturaMin();
		assertEquals(10, tempMin);
	}
	
	@Test
	void test_getTemperaturaMax() 
	{
		double tempMax = t1.getTemperaturaMax();
		assertEquals(30, tempMax);
	}
	
	@Test
	void test_setEncendido() 
	{
		t1.setEncendido(true);
		assertEquals(true, t1.isEncendido());
	}
	
	@Test
	void test_setTemperaturaMin1() 
	{
		t1.setTemperaturaMin(5);
		assertEquals(5, t1.getTemperaturaMin());
		
		assertEquals(20, t1.getTemperaturaActual());
	}
	
	@Test
	void test_setTemperaturaMin2() 
	{
		t1.setTemperaturaMin(25);
		assertEquals(25, t1.getTemperaturaMin());
		
		assertEquals(25, t1.getTemperaturaActual());
	}

	
	@Test
	void test_setTemperaturaMax1() 
	{
		t1.setTemperaturaMax(40);
		assertEquals(40, t1.getTemperaturaMax());
		
		assertEquals(20, t1.getTemperaturaActual());
	}
	
	@Test
	void test_setTemperaturaMax2() 
	{
		t1.setTemperaturaMax(19);
		assertEquals(19, t1.getTemperaturaMax());
		
		assertEquals(19, t1.getTemperaturaActual());
	}
	
	@Test
	void test_setTemperaturaActual1() 
	{
		t1.setTemperaturaActual(25);
		assertEquals(25, t1.getTemperaturaActual());
	}
	
	@Test
	void test_setTemperaturaActual2()
	{
		try 
		{
			t1.setTemperaturaActual(5);
			assertEquals(5, t1.getTemperaturaActual());
			
			fail();
		}
		catch(ArithmeticException ae)
		{
			//Prueba correcta
		}
	}
	
	@Test
	void test_setTemperaturaActual3()
	{
		try 
		{
			t1.setTemperaturaActual(40);
			assertEquals(40, t1.getTemperaturaActual());
			
			fail();

		}
		catch(ArithmeticException ae)
		{
			// Prueba correcta
		}
	}
	
	
	
	
	
//	@Test
//	void testSetTemperaturaMin() 
//	{
//		t1.setTemperaturaMin(18);
//		assertEquals(18, t1.getTemperaturaMin());
//	}
	
	
}
