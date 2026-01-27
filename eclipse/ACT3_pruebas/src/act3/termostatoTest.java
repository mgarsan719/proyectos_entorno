package act3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermostatoTest
{

	private Termostato t1;

	@BeforeEach
	public void Termostato()
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
		double tempIni = t1.getTemperaturaActual();
		assertEquals(20, tempIni);
	}

	@Test
	void test_getTemperaturaMin()
	{
		double tempMin = t1.getTemperaturaMin();
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
		t1.setTemperaturaMin(31);
		assertEquals(10, t1.getTemperaturaMin());

	}

	@Test
	void test_setTemperaturaMin3()
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
		t1.setTemperaturaMax(9);
		assertEquals(30, t1.getTemperaturaMax());

	}

	@Test
	void test_setTemperaturaMax3()
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
		} catch (IllegalArgumentException ae)
		{
			// Prueba correcta
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

		} catch (IllegalArgumentException ae)
		{
			// Prueba correcta
		}
	}

	@Test
	void test_encender()
	{
		t1.encender();
		assertEquals(true, t1.isEncendido());
	}

	@Test
	void test_apagar()
	{
		t1.apagar();
		assertEquals(false, t1.isEncendido());
	}

	@Test
	void test_subir1()
	{
		try
		{
			t1.subir(5);

			fail();
		} catch (IllegalStateException ae)
		{
			// Prueba correcta
		}
	}

	@Test
	void test_subir2()
	{
		try
		{
			t1.encender();
			t1.subir(-5);

			fail();
		} catch (IllegalArgumentException ae)
		{
			// Prueba correcta
		}
	}

	@Test
	void test_subir3()
	{
		try
		{
			t1.encender();
			t1.subir(15);

			fail();
		} catch (IllegalStateException ae)
		{
			// Prueba correcta
		}
	}

	@Test
	void test_subir4()
	{
		t1.encender();

		t1.subir(5);
		assertEquals(25, t1.getTemperaturaActual());
	}

	@Test
	void test_bajar1()
	{
		try
		{
			t1.bajar(5);

			fail();
		} catch (IllegalStateException ae)
		{
			// Prueba correcta
		}
	}

	@Test
	void test_bajar2()
	{
		try
		{
			t1.encender();
			t1.bajar(-5);

			fail();
		} catch (IllegalArgumentException ae)
		{
			// Prueba correcta
		}
	}

	@Test
	void test_bajar3()
	{
		try
		{
			t1.encender();
			t1.bajar(15);

			fail();
		} catch (IllegalStateException ae)
		{
			// Prueba correcta
		}
	}

	@Test
	void test_bajar4()
	{
		t1.encender();
		t1.bajar(5);
		assertEquals(15, t1.getTemperaturaActual());
	}

	// pruebas actividad 2
	@Test
	void test_setTemperaturaMinAct2()
	{
		t1.setTemperaturaMin(18);
		assertEquals(18, t1.getTemperaturaMin());
	}

	@Test
	void test1Ejercicio2()
	{

		Termostato t3 = new Termostato(10, 30, 20);
		
		// 1. Modificar la temperatura mínima a 18 grados
		t3.setTemperaturaMin(18);
		assertEquals(18, t3.getTemperaturaMin());
		assertEquals(20, t3.getTemperaturaActual());

		// 2. Modificar la temperatura mínima a 22 grados
		t3.setTemperaturaMin(22);
		assertEquals(22, t3.getTemperaturaMin());
		assertEquals(22, t3.getTemperaturaActual());

		// 3. Bajar 3 grados
		try
		{
			t3.encender();
			t3.bajar(3);
			fail();
		} 
		
		catch (IllegalStateException e)
		{
			// Prueba correcta
		}

		// 4. Bajar 15 grados
		try 
		{
	        t3.encender();
			t3.bajar(15);
	        fail();
	    } 
		
		catch (IllegalStateException e) 
		{
	        // Prueba correcta
	    }	
	}

}