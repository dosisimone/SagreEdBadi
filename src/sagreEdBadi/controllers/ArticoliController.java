package sagreEdBadi.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sagreEdBadi.beans.Articolo;

public class ArticoliController implements IArticoliController {

	private Set<Articolo> articoli;
	
	public ArticoliController() {
		articoli = new HashSet<Articolo>();
	}
	
	@Override
	public void aggiungiArticolo(Articolo articolo) 
	{		
		if (articolo == null) 
		{
			return;
		}		
		articoli.add(articolo);		
	}

	@Override
	public void rimuoviArticolo(Articolo articolo) 
	{		
		if (articolo == null) 
		{
			return;
		}		
		articoli.remove(articolo);		
	}

	@Override
	public Articolo[] getArticoli() 
	{
		Articolo[] articoliFiltrati = new Articolo[articoli.size()];
		return articoli.toArray(articoliFiltrati);
	}

	@Override
	public Articolo[] getArticoli(IFiltro<Articolo>[] filtri) {
		if (filtri == null || filtri.length == 0) {
			return getArticoli();
		}
		
		List<Articolo> listaArticoliFiltrati = new ArrayList<Articolo>();
		for (Articolo articolo : articoli) {
			boolean isArticoloOk = true;
			for (IFiltro<Articolo> filtro : filtri) {
				isArticoloOk |= filtro.isOk(articolo);
			}
			
			if (isArticoloOk) {
				listaArticoliFiltrati.add(articolo);
			}
		}
		
		Articolo[] ordiniFiltrati = new Articolo[listaArticoliFiltrati.size()];
		return listaArticoliFiltrati.toArray(ordiniFiltrati);
	}

}
