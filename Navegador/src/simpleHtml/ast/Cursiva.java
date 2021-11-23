package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Cursiva implements Elemento {

	String cadena;

	public void setElementos(String cadena) {
		this.cadena = cadena;
	}

	public Cursiva(String cadena) {
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
