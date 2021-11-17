package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class H1 implements Etiqueta{

	Elemento elemento;
	
	public H1(Elemento elemento) {
		super();
		this.elemento = elemento;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
