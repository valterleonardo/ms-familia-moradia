package ms.familia.moradia.interfaces;

import ms.familia.moradia.dict.TipoPessoas;

public interface Pretendente {

	public abstract void setNext(Pretendente nextInPretendente);
	public abstract boolean processar(TipoPessoas tipoPessoa);
}
