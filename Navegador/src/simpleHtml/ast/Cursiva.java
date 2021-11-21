package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Cursiva implements Elemento {

	public List<Texto> getElementos() {
		return elementos;
	}

	public void setElementos(List<Texto> elementos) {
		this.elementos = elementos;
	}

	List<Texto> elementos;
	
	public Cursiva (List<Texto> elementos) {
		this.elementos = elementos;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
