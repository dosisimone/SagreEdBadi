package sagreEdBadi.beans;

import java.math.BigDecimal;

public class Articolo {

	public String nome;
	public BigDecimal prezzo;
	
	public Articolo() {
		nome = "articolo non valido";
		prezzo = BigDecimal.ZERO;
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
	
}
