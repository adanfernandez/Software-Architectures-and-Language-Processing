package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Subrayado implements Elemento {

	List<Texto> elementos;

	public Subrayado(List<Texto> elementos) {
		this.elementos = elementos;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
