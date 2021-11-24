package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Subrayado implements Elemento {

	public List<Normal> getElementos() {
		return elementos;
	}

	public void setElementos(List<Normal> elementos) {
		this.elementos = elementos;
	}

	List<Normal> elementos;

	public Subrayado(List<Normal> elementos) {
		this.elementos = elementos;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}