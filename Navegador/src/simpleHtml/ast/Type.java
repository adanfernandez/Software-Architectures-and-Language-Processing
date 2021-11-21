package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Type implements AstHtml {
	public Cadena getCadena() {
		return cadena;
	}

	public void setCadena(Cadena cadena) {
		this.cadena = cadena;
	}

	public Cadena cadena;
	
	public Type(Cadena cadena) {
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
