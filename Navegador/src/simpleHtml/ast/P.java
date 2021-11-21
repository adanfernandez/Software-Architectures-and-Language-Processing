package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class P implements Etiqueta {

	List<Elemento> elementos;

	public P(List<Elemento> elementos) {
		super();
		this.elementos = elementos;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
