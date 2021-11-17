package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Href implements AstHtml {

	Cadena cadena;
	
	public Href(Cadena cadena) {
		super();
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
