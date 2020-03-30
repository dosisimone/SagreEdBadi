package sagreEdBadi.factories;

import sagreEdBadi.beans.Ordine;
import sagreEdBadi.beans.Tavolo;

public interface IOrdiniFactory {
	Ordine creaOrdine(String nome, Tavolo tavolo);
}
