package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Italic implements FontStyleValor {
	@Override
	public String toString() {
		return "italic";
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
