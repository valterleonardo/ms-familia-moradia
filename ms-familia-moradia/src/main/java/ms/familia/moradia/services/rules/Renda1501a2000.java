package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.Renda;

public class Renda1501a2000 implements Renda{

	@SuppressWarnings("unused")
	private Renda nextInRenda; 
	  
    public void setNext(Renda c) 
    { 
    	nextInRenda = c; 
    } 
  
    public Integer processar(Long renda) 
    { 
		/*Renda total da família de 1501 à 2000 reais - valendo 1 ponto*/
    	if (renda > 1500 && renda <= 2000)
    		return 1;
    	else 
    		return 0;
    } 
}
