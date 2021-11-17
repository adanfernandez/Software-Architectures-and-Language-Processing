package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Link implements AstHtml {
	
	Href href;
	Rel rel;
	Type type;
	

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
