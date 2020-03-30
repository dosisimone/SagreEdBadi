package sagreEdBadi.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Ordine {

	private long numero;
	private String nome;
	private Date time;
	private Tavolo tavolo;
	private Map<Articolo, Integer> qtaArticoli;
	
	public Ordine() {
		nome = "ordine non valido";
		qtaArticoli = new HashMap<Articolo, Integer>();
		time = new Date(System.currentTimeMillis());
	}
	
	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome == null || nome.isEmpty() || nome.isBlank()) {
			return;
		}
		this.nome = nome;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}
	
	public void setTavolo(Tavolo tavolo) {
		if (tavolo == null) {
			return;
		}
		this.tavolo = tavolo;
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
    	BigDecimal totale = new BigDecimal(0);
    	for (Articolo articolo : qtaArticoli.keySet()) 
    	{
    		Integer qta = qtaArticoli.get(articolo);
    		BigDecimal prezzoUnitarioBD = articolo.getPrezzo();
    		BigDecimal qtaBD = new BigDecimal(qta);
    		totale = totale.add(prezzoUnitarioBD.multiply(qtaBD));    		
    	}
    	return totale;
    }
    
    
	
    @Override
	public String toString() {
		return "Ordine [numero=" + numero + ", nome=" + nome + ", time=" + time + ", tavolo=" + tavolo
				+ ", qtaArticoli=" + qtaArticoli + ", getPrezzoTotale()=" + getPrezzoTotale() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numero ^ (numero >>> 32));
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}
    

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordine other = (Ordine) obj;
		if (numero != other.numero)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

}
