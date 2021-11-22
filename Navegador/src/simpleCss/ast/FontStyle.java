package simpleCss.ast;

public class FontStyle implements Asignacion {
	FontStyleValor valor;

	public FontStyle(FontStyleValor valor) {
		super();
		this.valor = valor;
	}

	public FontStyleValor getValor() {
		return valor;
	}

	public void setValor(FontStyleValor valor) {
		this.valor = valor;
	}
}
