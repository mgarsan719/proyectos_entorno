package act3;

public class Termostato
{

	private boolean encendido;
	private double temperaturaActual;
	private double temperaturaMin;
	private double temperaturaMax;

	public Termostato(double temperaturaMin, double temperaturaMax, double temperaturaInicial)
	{
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;

		// Encendido empieza apagado
		this.encendido = false;
		this.temperaturaActual = temperaturaInicial;
	}

	// Getters
	public boolean isEncendido()
	{
		return encendido;
	}

	public double getTemperaturaActual()
	{
		return temperaturaActual;
	}

	public double getTemperaturaMin()
	{
		return temperaturaMin;
	}

	public double getTemperaturaMax()
	{
		return temperaturaMax;
	}

	// Setters
	public void setEncendido(boolean encendido)
	{
		this.encendido = encendido;
	}

	public void setTemperaturaMin(double temperaturaMin)
	{
		// Si ponemos un mínimo inválido, no lo cambiamos
		if (temperaturaMin < this.temperaturaMax)
		{
			this.temperaturaMin = temperaturaMin;

			// Ajuste automático si la temperatura actual queda fuera de rango
			if (temperaturaActual > this.temperaturaMin)
			{
				temperaturaActual = this.temperaturaMin;
			}
		}
	}

	public void setTemperaturaMax(double temperaturaMax)
	{
		if (temperaturaMax > this.temperaturaMin)
		{
			this.temperaturaMax = temperaturaMax;

			if (temperaturaActual > this.temperaturaMax)
			{
				temperaturaActual = this.temperaturaMax;
			}
		}
	}

	public void setTemperaturaActual(double temperaturaActual)
	{
		if (temperaturaActual < temperaturaMin || temperaturaActual > temperaturaMax)
		{
			throw new IllegalArgumentException(
					"Temperatura fuera de rango (" + temperaturaMin + " - " + temperaturaMax + ").");
		}
		
		this.temperaturaActual = temperaturaActual;
	}

	// Enciende el termostato
	public void encender()
	{
		encendido = true;
	}

	// Apaga el termostato
	public void apagar()
	{
		encendido = false;
	}

	/**
	 * 3) Sube la temperatura en X grados. Lanza excepción si está apagado o si se
	 * pasa del máximo.
	 */
	public void subir(double grados)
	{
		if (!encendido)
		{
			throw new IllegalStateException("No se puede subir: el termostato está apagado.");
		}
		
		if (grados <= 0)
		{
			throw new IllegalArgumentException("Los grados deben ser > 0.");
		}
		
		double nueva = temperaturaActual + grados;
		
		if (nueva > temperaturaMax)
		{
			throw new IllegalStateException("No se puede subir tanto: se supera el máximo.");
		}
		
		temperaturaActual = nueva;
	}

	/**
	 * 4) Baja la temperatura en X grados. Lanza excepción si está apagado o si baja
	 * del mínimo.
	 */
	public void bajar(double grados)
	{
		if (!encendido)
		{
			throw new IllegalStateException("No se puede bajar: el termostato está apagado.");
		}
		
		if (grados <= 0)
		{
			throw new IllegalArgumentException("Los grados deben ser > 0.");
		}
		
		double nueva = temperaturaActual + grados;
		
		if (nueva < temperaturaMin)
		{
			throw new IllegalStateException("No se puede bajar tanto: se baja del mínimo.");
		}
		
		temperaturaActual = nueva;
	}
}
