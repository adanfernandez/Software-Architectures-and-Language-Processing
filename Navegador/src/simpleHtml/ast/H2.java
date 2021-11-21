package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class H2 implements Etiqueta {

	List<Elemento> elementos;

	public H2(List<Elemento> elementos) {
		super();
		this.elementos = elementos;
	}
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
