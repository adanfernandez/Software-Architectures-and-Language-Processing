package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class ContenidoTexto implements AstHtml {
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	String cadena;
	
	public ContenidoTexto (String cadena) {
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	
}
