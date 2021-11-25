package simpleCss.ast;

import simpleCss.visitor.Visitor;

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
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
	@Override
	public String toString() {
		return "font-style";
	}
}
