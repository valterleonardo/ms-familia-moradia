package ms.familia.moradia.services.rules;

import ms.familia.moradia.dict.TipoPessoas;
import ms.familia.moradia.interfaces.Dependente;

public class EhDependente implements Dependente {

	@SuppressWarnings("unused")
	private Dependente netxInDependente;
	
	@Override
	public void setNext(Dependente c) {
		netxInDependente = c;		
	}

	@Override
	public boolean processar(TipoPessoas tipoPessoa) {

		if(TipoPessoas.DEPENDENTE.equals(tipoPessoa)) {
			return true;
		} else {
			return false;
		}
	
	}

}
