package simpleCss.ast;

public class TextAlign implements Asignacion {
	TextAlignValor valor;

	public TextAlign(TextAlignValor valor) {
		super();
		this.valor = valor;
	}

	public TextAlignValor getValor() {
		return valor;
	}

	public void setValor(TextAlignValor valor) {
		this.valor = valor;
	}
}
