package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Title implements AstHtml{

	public List<Texto> getTextos() {
		return textos;
	}

	public void setTextos(List<Texto> textos) {
		this.textos = textos;
	}

	List<Texto> textos;
	
	public Title(List<Texto> textos) {
		this.textos = textos;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
