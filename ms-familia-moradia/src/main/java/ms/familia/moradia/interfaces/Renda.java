package ms.familia.moradia.interfaces;

public interface Renda {

	public abstract void setNext(Renda nextInDependentes);
	public abstract Integer processar(Long renda);
}
