package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.QuantidadeDependentes;

public class Dependentes1a2 implements QuantidadeDependentes{

	private QuantidadeDependentes nextInQtdeDep; 
	  
    public void setNext(QuantidadeDependentes c) 
    { 
    	nextInQtdeDep = c; 
    } 
  
    public Integer processar(Integer qtde) 
    { 
		/*Famílias com 1 ou 2 dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 2 pontos*/
    	if (qtde >= 1 && qtde <= 2)
    		return 2;
    	else 
    		return nextInQtdeDep.processar(qtde);    	
    }

}
