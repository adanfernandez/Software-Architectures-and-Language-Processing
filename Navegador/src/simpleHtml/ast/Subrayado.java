package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Subrayado implements Elemento{

	Elemento elemento;
	
	public Subrayado (Elemento elemento) {
		this.elemento = elemento;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
