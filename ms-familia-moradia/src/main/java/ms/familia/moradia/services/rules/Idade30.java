package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.IdadePretendente;

public class Idade30 implements IdadePretendente{

	@SuppressWarnings("unused")
	private IdadePretendente nextInIdadePretendente; 
	  
    public void setNext(IdadePretendente c) 
    { 
    	nextInIdadePretendente = c; 
    } 
  
    public Integer processar(Integer idade) 
    { 
		/*Pretendente com idade abaixo de 30 anos - valendo 1 ponto*/
    	if (idade < 30)
    		return 1;
    	else 
    		return 0;
    } 
}
