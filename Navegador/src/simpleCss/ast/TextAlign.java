package simpleCss.ast;

import simpleCss.visitor.Visitor;

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

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
	@Override
	public String toString() {
		return "text-align";
	}
}
