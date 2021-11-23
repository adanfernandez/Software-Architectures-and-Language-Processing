package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Subrayado implements Elemento {

	String cadena;

	public void setElementos(String cadena) {
		this.cadena = cadena;
	}

	public Subrayado(String cadena) {
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
