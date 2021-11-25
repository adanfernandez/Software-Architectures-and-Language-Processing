package simpleCss.ast;

import simpleCss.visitor.Visitor;

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
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
	@Override
	public String toString() {
		return "color";
	}
}
