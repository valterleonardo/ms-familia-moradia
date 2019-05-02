package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.QuantidadeDependentes;

public class Dependentes3 implements QuantidadeDependentes{

	@SuppressWarnings("unused")
	private QuantidadeDependentes nextInQtdeDep; 
	  
    public void setNext(QuantidadeDependentes c) 
    { 
    	nextInQtdeDep = c; 
    } 
  
    public Integer processar(Integer qtde) 
    { 
		/*Famílias com 3 ou mais dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 3 pontos*/
    	if (qtde >= 3)
    		return 3;
    	else 
    		return 0;    	
    }

}
