package simpleHtml.ast;

import java.util.List;

import simpleHtml.visitor.Visitor;

public class Body implements AstHtml {

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	List<Etiqueta> etiquetas;
	
	public Body(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
