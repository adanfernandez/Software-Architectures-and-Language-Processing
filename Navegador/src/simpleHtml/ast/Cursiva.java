package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Cursiva implements Elemento {

	Elemento elemento;
	
	public Cursiva (Elemento elemento) {
		this.elemento = elemento;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
