package ms.familia.moradia.services.rules;

import ms.familia.moradia.dict.TipoPessoas;
import ms.familia.moradia.interfaces.Pretendente;

public class EhPretendente implements Pretendente {

	@SuppressWarnings("unused")
	private Pretendente netxInPretendente;
	
	@Override
	public void setNext(Pretendente c) {
		netxInPretendente = c;		
	}

	@Override
	public boolean processar(TipoPessoas tipoPessoa) {

		if(TipoPessoas.PRETENDENTE.equals(tipoPessoa)) {
			return true;
		} else {
			return false;
		}
	
	}

}
