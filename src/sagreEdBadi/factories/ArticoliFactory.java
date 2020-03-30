package sagreEdBadi.factories;

import java.math.BigDecimal;

import sagreEdBadi.beans.Articolo;

public class ArticoliFactory implements IArticoliFactory {

	private long prossimoCodiceArticolo = 0L;
	
	public ArticoliFactory() {
		this(0L);
	}
	
	public ArticoliFactory(long primoCodiceArticolo) {
		this.prossimoCodiceArticolo = primoCodiceArticolo;
	}
	
	@Override
	public Articolo creaArticolo(String nome, BigDecimal prezzo) {
		
		if (nome == null || nome.isEmpty() || nome.isBlank()) {
			return null;
		}
		
		if (prezzo.doubleValue() < 0.0) {
			return null;
		}
		
		Articolo articolo = new Articolo();
		articolo.setCodice(++prossimoCodiceArticolo);
		articolo.setNome(nome);
		articolo.setPrezzo(prezzo);
		return articolo;
	}

}
