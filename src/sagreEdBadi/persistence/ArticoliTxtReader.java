package sagreEdBadi.persistence;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import sagreEdBadi.beans.Articolo;

public class ArticoliTxtReader implements IArticoliReader {

	private String path;
	
	public ArticoliTxtReader(String path) {
		File file = new File(path);
		if (file.exists() && !file.isDirectory()) {
			this.path = path;
		}
	}
	
	@Override
	public Articolo[] read() {
		
		List<Articolo> listArticoli = new ArrayList<Articolo>();
		
		try 
		{
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
		
			String delimiters = ";";
			
			String line = "";
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	StringTokenizer strTokenizer = new StringTokenizer(line, delimiters);
	        	Articolo articolo = new Articolo();	 
	        	
	        	if (!strTokenizer.hasMoreTokens()) {
	        		break;
	        	}       	     
	        	String firstToken = strTokenizer.nextToken();
	        	firstToken = firstToken.trim();
	        	articolo.setNome(firstToken);
	        	
	        	if (!strTokenizer.hasMoreTokens()) {
	        		break;
	        	}
	        	String secondToken = strTokenizer.nextToken();
	        	secondToken = secondToken.trim();
	        	BigDecimal prezzo = new BigDecimal(secondToken);
	        	articolo.setPrezzo(prezzo);
	        	
	        	listArticoli.add(articolo);
	        }
	        
	        bufferedReader.close();
		} 
		catch (FileNotFoundException fileNotFoundException) 
		{
			
		}
		catch (IOException ioException) 
		{
			
		}	
		
		Articolo[] articoli = new Articolo[listArticoli.size()];
		return listArticoli.toArray(articoli);
	}

}
