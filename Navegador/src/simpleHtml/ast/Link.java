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


	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
