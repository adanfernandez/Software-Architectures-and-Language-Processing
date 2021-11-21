package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Rel implements AstHtml {

	public Cadena getCadena() {
		return cadena;
	}
	public void setCadena(Cadena cadena) {
		this.cadena = cadena;
	}
	Cadena cadena;
	public Rel(Cadena cadena) {
		super();
		this.cadena = cadena;
	}
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
}
