package ms.familia.moradia.interfaces;

import ms.familia.moradia.dict.TipoPessoas;

public interface Dependente {

	public abstract void setNext(Dependente nextInDependente);
	public abstract boolean processar(TipoPessoas tipoPessoa);
}
