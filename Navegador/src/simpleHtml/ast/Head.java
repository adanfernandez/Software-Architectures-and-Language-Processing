package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Head implements AstHtml {
	
	Title title;
	Link link;
	
	public Head(Title title, Link link) {
		this.title = title;
		this.link = link;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
