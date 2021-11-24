package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class H1 implements Etiqueta{

	public List<Elemento> getElementos() {
		return elementos;
	}


	public void setElementos( List<Elemento>elementos) {
		this.elementos = elementos;
	}


	 List<Elemento> elementos;

	public H1(List<Elemento> elementos) {
		super();
		this.elementos = elementos;
	}
	

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
