package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Normal implements AstHtml {
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String cadena;
	
	public Normal (String cadena) {
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	
}
