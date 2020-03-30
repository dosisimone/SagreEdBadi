package sagreEdBadi.factories;

import java.util.Date;

import sagreEdBadi.beans.Ordine;
import sagreEdBadi.beans.Tavolo;

public class OrdiniFactory implements IOrdiniFactory {

	private long prossimoNumeroOrdine = 0L;
	
	public OrdiniFactory() {
		this(0L);
	}
	
	public OrdiniFactory(long primoNumeroOrdine) {
		this.prossimoNumeroOrdine = primoNumeroOrdine;
	}
	
	@Override
	public Ordine creaOrdine(String nome, Tavolo tavolo) {
		
		if (nome == null || nome.isEmpty() || nome.isBlank()) {
			return null;
		}
		
		if (tavolo == null) {
			return null;
		}
		
		Ordine ordine = new Ordine();
		ordine.setNumero(++prossimoNumeroOrdine);
		ordine.setNome(nome);
		ordine.setTavolo(tavolo);
		ordine.setTime(new Date(System.currentTimeMillis()));
		return ordine;
	}

}
