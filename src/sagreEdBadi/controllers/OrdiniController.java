package sagreEdBadi.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sagreEdBadi.beans.Ordine;

public class OrdiniController implements IOrdiniController {
	
	private Set<Ordine> ordini;
	
	public OrdiniController() {
		ordini = new HashSet<Ordine>();
	}

	@Override
	public void inserisciOrdine(Ordine ordine) {		
		if (ordine == null) {
			return;
		}		
		ordini.add(ordine);
	}
	
	@Override
	public void rimuoviOrdine(Ordine ordine) {		
		if (ordine == null) {
			return;
		}		
		ordini.remove(ordine);
	}

	@Override
	public Ordine[] getOrdini() {
		Ordine[] ordiniFiltrati = new Ordine[ordini.size()];
		return ordini.toArray(ordiniFiltrati);
	}

	@Override
	public Ordine[] getOrdini(IFiltro<Ordine>[] filtri) {
		if (filtri == null || filtri.length == 0) {
			return getOrdini();
		}
		
		List<Ordine> listaOrdiniFiltrati = new ArrayList<Ordine>();
		for (Ordine ordine : ordini) {
			boolean isOrdineOk = true;
			for (IFiltro<Ordine> filtro : filtri) {
				isOrdineOk |= filtro.isOk(ordine);
			}
			
			if (isOrdineOk) {
				listaOrdiniFiltrati.add(ordine);
			}
		}
		
		Ordine[] ordiniFiltrati = new Ordine[listaOrdiniFiltrati.size()];
		return listaOrdiniFiltrati.toArray(ordiniFiltrati);
	}

}
