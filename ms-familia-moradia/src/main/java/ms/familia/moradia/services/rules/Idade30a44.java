package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.IdadePretendente;

public class Idade30a44 implements IdadePretendente{

	private IdadePretendente nextInIdadePretendente; 
	  
    public void setNext(IdadePretendente c) 
    { 
    	nextInIdadePretendente = c; 
    } 
  
    public Integer processar(Integer idade) 
    { 
		/*Pretendente com idade de 30 à 44 anos - valendo 2 pontos*/
    	if (idade >= 30 && idade <= 44)
    		return 2;
    	else 
    		return nextInIdadePretendente.processar(idade);
    } 
}
