package sagreEdBadi.beans;

import java.math.BigDecimal;

public class Articolo {

	private long codice;
	private String nome;
	private BigDecimal prezzo;
	
	public Articolo() {
		codice = 0L;
		nome = "articolo non valido";
		prezzo = BigDecimal.ZERO;
	}

	public long getCodice() {
		return codice;
	}

	public void setCodice(long codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	

	@Override
	public String toString() {
		return "Articolo [codice=" + codice + ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codice ^ (codice >>> 32));
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
		Articolo other = (Articolo) obj;
		if (codice != other.codice)
			return false;
		return true;
	}	
	
}
