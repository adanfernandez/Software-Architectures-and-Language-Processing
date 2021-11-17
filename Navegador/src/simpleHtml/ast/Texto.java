package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Texto implements Elemento {
	public String cadena;
	
	public Texto (String cadena) {
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
}
