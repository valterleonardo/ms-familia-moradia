package ms.familia.moradia.interfaces;

public interface IdadeDependente {

	public abstract void setNext(IdadeDependente nextInIdadeDependente);
	public abstract boolean processar(Integer idade);
}
