package sagreEdBadi.controllers;

import sagreEdBadi.beans.Articolo;

public interface IArticoliController {
	void aggiungiArticolo(Articolo articolo);
	void rimuoviArticolo(Articolo articolo);
	Articolo getArticolo(long codice);
}
