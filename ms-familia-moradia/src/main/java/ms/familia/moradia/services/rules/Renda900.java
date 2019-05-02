package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.Renda;

public class Renda900 implements Renda{

	private Renda nextInRenda; 
	  
    public void setNext(Renda c) 
    { 
    	nextInRenda = c; 
    } 
  
    public Integer processar(Long renda) 
    { 
		/*Renda total da família até 900 reais - valendo 5 pontos*/
    	if (renda <= 900)
    		return 5;
    	else 
    		return nextInRenda.processar(renda);
    } 
}
