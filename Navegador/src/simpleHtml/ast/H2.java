package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class H2 implements Etiqueta {

	Elemento elemento;
	
	public H2(Elemento elemento) {
		super();
		this.elemento = elemento;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
