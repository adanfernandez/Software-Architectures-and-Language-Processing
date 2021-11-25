package simpleCss.ast;

import simpleCss.visitor.Visitor;

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
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
	@Override
	public String toString() {
		return "font-size";
	}
}
