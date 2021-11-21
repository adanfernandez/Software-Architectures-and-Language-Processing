package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Cadena implements AstHtml{
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String cadena;
	
	public Cadena (String cadena) {
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
}
