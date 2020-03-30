package sagreEdBadi.beans;

public class Tavolo {
	
	private int numero;
	private int numeroCoperti;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			return;
		}
		this.numero = numero;
	}

	public int getNumeroCoperti() {
		return numeroCoperti;
	}

	public void setNumeroCoperti(int numeroCoperti) {
		if (numeroCoperti <= 0) {
			return;
		}
		this.numeroCoperti = numeroCoperti;
	}

	@Override
	public String toString() {
		return "Tavolo [numero=" + numero + ", numeroCoperti=" + numeroCoperti + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + numeroCoperti;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (numero != other.numero)
			return false;
		if (numeroCoperti != other.numeroCoperti)
			return false;
		return true;
	}

}
