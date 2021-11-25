package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Normal implements FontStyleValor {
	@Override
	public String toString() {
		return "normal";
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
