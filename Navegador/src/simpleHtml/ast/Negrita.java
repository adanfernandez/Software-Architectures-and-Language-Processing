package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Negrita implements Elemento {

	Elemento elemento;
	
	public Negrita (Elemento elemento) {
		this.elemento = elemento;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
