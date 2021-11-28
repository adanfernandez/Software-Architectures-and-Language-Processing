package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Subrayado implements Elemento {

	public List<ContenidoTexto> getElementos() {
		return elementos;
	}

	public void setElementos(List<ContenidoTexto> elementos) {
		this.elementos = elementos;
	}

	List<ContenidoTexto> elementos;

	public Subrayado(List<ContenidoTexto> elementos) {
		this.elementos = elementos;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}