package sagreEdBadi.factories;

import java.math.BigDecimal;

import sagreEdBadi.beans.Articolo;

public interface IArticoliFactory {
	Articolo creaArticolo(String nome, BigDecimal prezzo);
}
