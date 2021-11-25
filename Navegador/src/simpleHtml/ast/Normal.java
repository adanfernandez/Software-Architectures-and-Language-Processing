package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Normal implements AstHtml {
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	String cadena;
	
	public Normal (String cadena) {
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	
}
