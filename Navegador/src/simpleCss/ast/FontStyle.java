package simpleCss.ast;

public class FontStyle implements Asignacion {
	Valor valor;

	public FontStyle(Valor valor) {
		super();
		this.valor = valor;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}
}
