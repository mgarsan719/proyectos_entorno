package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {

    private Cuenta cuenta;

    @BeforeEach
    public void nuevaCuenta() {

        this.cuenta = new Cuenta("ES6475893745", 100);

    }


    @Test
    void testGetSaldo() {
        // Cuenta cuenta1 = new Cuenta("ES6475893745", 100);
        double saldo = cuenta.getSaldo();
        assertEquals(100, saldo);
    }

    @Test
    void testSetSaldo() {
        // Cuenta cuenta1 = new Cuenta("ES6475893745", 100);
        cuenta.setSaldo(200);
        assertEquals(200, 200);
    }

    @Test
    void testIngresarDinero() {
        fail("Not yet implemented");
    }

    @Test
    void testExtraerDinero() {
        try {

            Cuenta cuenta1 = new Cuenta("ES6475893745", 100);
            cuenta1.extraerDinero(90);
            fail("ERROR. Se debería haber lanzado una excepción.");

        }catch(ArithmeticException ae) {

            //Prueba correcta

        }
    }

    @Test
    void testMostrarCuenta() {
        fail("Not yet implemented");
    }

}