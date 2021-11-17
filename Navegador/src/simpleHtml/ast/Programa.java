package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Programa implements AstHtml {
	
	Head head;
	Body body;
	
	public Programa(Head head, Body body) {
		this.head = head;
		this.body = body;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
