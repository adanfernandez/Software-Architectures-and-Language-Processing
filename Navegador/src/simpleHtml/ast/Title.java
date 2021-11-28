package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Title implements AstHtml{

	public List<ContenidoTexto> getTextos() {
		return textos;
	}

	public void setTextos(List<ContenidoTexto> textos) {
		this.textos = textos;
	}

	List<ContenidoTexto> textos;
	
	public Title(List<ContenidoTexto> textos) {
		this.textos = textos;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
