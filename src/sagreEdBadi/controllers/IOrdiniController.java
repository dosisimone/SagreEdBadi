package sagreEdBadi.controllers;

import sagreEdBadi.beans.Ordine;

public interface IOrdiniController {
	void inserisciOrdine(Ordine ordine);
	void rimuoviOrdine(Ordine ordine);
	Ordine[] getOrdini();
	Ordine[] getOrdini(IFiltro<Ordine>[] filtri);
}
