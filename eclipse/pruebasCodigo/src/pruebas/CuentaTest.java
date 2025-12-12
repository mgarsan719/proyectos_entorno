package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {
	
	private static Cuenta cuenta;
	
	@BeforeAll
	public static void nuevaCuenta() {
		cuenta = new Cuenta("ES567984135214657587", 100);
	}
	

	@Test
	void testGetSaldo() {
		//Cuenta cuenta1= new Cuenta("ES567984135214657587", 100);
		float saldo = cuenta.getSaldo();
		assertEquals(100,saldo);
	}
	
	@Test
	void testSetSaldo() {
		//Cuenta cuenta1= new Cuenta("ES567984135214657587", 100);
		cuenta.setSaldo(100);
		assertEquals(100,cuenta.getSaldo());
	}
	
	@Test
	void testIngresarDinero() {
		cuenta.ingresarDinero(400);
		assertEquals(500,cuenta.getSaldo());
	}

	@Test
	void testExtraerDinero() {
		try {
			//Cuenta cuenta = new Cuenta("ES567984135214657587", 100);
			cuenta.extraerDinero(120);
			fail("ERROR. Se debería haber lanzado una excepción");
		
		}
		catch(ArithmeticException ae) {
			//Prueba correcta
		}
	}
}