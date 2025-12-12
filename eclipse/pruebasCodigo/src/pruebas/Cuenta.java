package pruebas;

public class Cuenta {
	private String numero;
	private float saldo;
	
	public Cuenta(String numCta, float saldoCta) {
		setNumero(numCta);
		setSaldo(saldoCta);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void ingresarDinero(float importe) {
		saldo= saldo+importe;
	}
	
	public void extraerDinero(float importe) {
		if((saldo-importe)<0)
			throw new java.lang.ArithmeticException("Saldo negativo");
		else
			saldo = saldo - importe;
	}
	
	public void mostrarCuenta() {
		System.out.println("Nº Cuenta: "+getNumero());
		System.out.println("Saldo: "+getSaldo()+ " €");
	}
}