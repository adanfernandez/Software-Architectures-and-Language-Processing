package simpleCss.ast;

public class FontSize implements Asignacion {
	Size valor;

	public FontSize(Size valor) {
		super();
		this.valor = valor;
	}

	public Size getValor() {
		return valor;
	}

	public void setValor(Size valor) {
		this.valor = valor;
	}
}
