package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Title implements AstHtml{

	public List<Normal> getTextos() {
		return textos;
	}

	public void setTextos(List<Normal> textos) {
		this.textos = textos;
	}

	List<Normal> textos;
	
	public Title(List<Normal> textos) {
		this.textos = textos;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
