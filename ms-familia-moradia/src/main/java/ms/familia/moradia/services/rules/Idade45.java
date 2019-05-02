package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.IdadePretendente;

public class Idade45 implements IdadePretendente{

	private IdadePretendente nextInIdadePretendente; 
	  
    public void setNext(IdadePretendente c) 
    { 
    	nextInIdadePretendente = c; 
    } 
  
    public Integer processar(Integer idade) 
    { 
		/*Pretendente com idade igual ou acima de 45 anos - valendo 3 pontos*/
    	if (idade >= 45)
    		return 3;
    	else 
    		return nextInIdadePretendente.processar(idade);
    } 
}
