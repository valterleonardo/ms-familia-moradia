package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.QuantidadeDependentes;

public class Dependentes0 implements QuantidadeDependentes{

	private QuantidadeDependentes nextInQtdeDep; 
	  
    public void setNext(QuantidadeDependentes c) 
    { 
    	nextInQtdeDep = c; 
    } 
  
    public Integer processar(Integer qtde) 
    { 
		/*Famílias com nenhum dependente  (lembrando que dependentes maiores de 18 anos não contam) - valendo 0 pontos*/
    	if (qtde <= 0)
    		return 0;
    	else 
    		return nextInQtdeDep.processar(qtde);    	
    }

}
