package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Texto implements Elemento {
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String cadena;
	
	public Texto (String cadena) {
		this.cadena = cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	
}
