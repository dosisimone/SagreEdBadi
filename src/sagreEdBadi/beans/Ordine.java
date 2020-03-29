package sagreEdBadi.beans;

import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

public class Ordine {

	private String nome;
	private Map<Articolo, Integer> qtaArticoli;
	
	public Ordine() {
		nome = "ordine non valido";
		qtaArticoli = new HashMap<Articolo, Integer>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    public void addArticolo(Articolo articolo, int qta) {
        if (qta <= 0) {
            return;
        }

        Integer newQta = qta;
        Integer oldQta = qtaArticoli.get(articolo);
        if (oldQta != null)
        {
            newQta += oldQta;
        }
        qtaArticoli.put(articolo, newQta);
    }
    
    public void removeArticolo(Articolo articolo, int qta) {
        if (qta <= 0) {
            return;
        }

        Integer oldQta = qtaArticoli.get(articolo);
        if (oldQta == null)
        {
            // non esistono articoli come quello cercato nell'ordine
            return;            
        }
        Integer qtaToRemove = qta;
        Integer newQta = oldQta - qtaToRemove;
        if (newQta > 0)
        {
            qtaArticoli.put(articolo, newQta);
        }
        else 
        {
            qtaArticoli.remove(articolo);            
        }
    }
    
    public void clearArticoliOrdine() {
        qtaArticoli.clear();
    }	
    
    public BigDecimal getPrezzoTotale() {
    	BigDecimal totale = BigDecimal.ZERO;
    	for (Articolo articolo : qtaArticoli.keySet()) 
    	{
    		Integer qta = qtaArticoli.get(articolo);
    		totale.add(articolo.getPrezzo().multiply(new BigDecimal(qta)));
    	}
    	return totale;
    }

}
