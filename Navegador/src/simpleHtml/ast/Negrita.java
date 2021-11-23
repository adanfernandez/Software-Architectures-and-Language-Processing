package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Negrita implements Elemento {

	String cadena;

	public void setElementos(String cadena) {
		this.cadena = cadena;
	}

	public Negrita(String cadena) {
		this.cadena = cadena;
	}
	
	public String getCadena() {
		return cadena;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}


}
