package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class P implements Etiqueta {

	Elemento elemento;

	public P(Elemento elemento) {
		super();
		this.elemento = elemento;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
