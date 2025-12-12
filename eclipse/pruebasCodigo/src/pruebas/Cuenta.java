package pruebas;

public class Cuenta
{

    //ATRIBUTOS

    private String numero;
    private double saldo;

    public Cuenta(String numero, double saldo) {
        this.setNumero(numero);
        this.setSaldo(saldo);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingresarDinero(double importe) {
        setSaldo(getSaldo() + importe);
    }

    public void extraerDinero(double importe) {
        if((saldo - importe)<0) {

            throw new java.lang.ArithmeticException("Saldo negativo.");

        }else {

            saldo = saldo - importe;

        }

    }

    public void mostrarCuenta() {

        System.out.println("Nº Cuenta: "+getNumero());
        System.out.println("Saldo: "+getSaldo()+ " €");

    }
	
}
