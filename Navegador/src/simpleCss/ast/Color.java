package simpleCss.ast;

public class Color implements Asignacion {
	ColorValor valor;

	public Color(ColorValor valor) {
		super();
		this.valor = valor;
	}

	public ColorValor getValor() {
		return valor;
	}

	public void setValor(ColorValor valor) {
		this.valor = valor;
	}
}
