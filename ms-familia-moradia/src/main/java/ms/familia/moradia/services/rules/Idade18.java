package ms.familia.moradia.services.rules;

import ms.familia.moradia.interfaces.IdadeDependente;

public class Idade18 implements IdadeDependente{

	@SuppressWarnings("unused")
	private IdadeDependente nextInIdadeDependente; 
	  
    public void setNext(IdadeDependente c) 
    { 
    	nextInIdadeDependente = c; 
    } 
  
    public boolean processar(Integer idade) 
    { 
		/*Pessoa maior de 18 anos*/
    	if (idade < 18)
    		return true;
    	else 
    		return false;
    	
    } 
}
