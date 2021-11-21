package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Link implements AstHtml {
	
	Href href;
	Rel rel;
	Type type;
	

	public Link(Href href, Rel rel, Type type) {
		super();
		this.href = href;
		this.rel = rel;
		this.type = type;
	}


	public Href getHref() {
		return href;
	}


	public void setHref(Href href) {
		this.href = href;
	}


	public Rel getRel() {
		return rel;
	}


	public void setRel(Rel rel) {
		this.rel = rel;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
