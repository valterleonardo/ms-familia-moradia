package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.Renda;

public class Renda901a1500 implements Renda{

	private Renda nextInRenda; 
	  
    public void setNext(Renda c) 
    { 
    	nextInRenda = c; 
    } 
  
    public Integer processar(Long renda) 
    { 
		/*Renda total da família de 901 à 1500 reais - valendo 3 pontos*/
    	if (renda > 900 && renda <= 1500)
    		return 3;
    	else 
    		return nextInRenda.processar(renda);
    } 
}
