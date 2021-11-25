package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Blue implements ColorValor {
	@Override
	public String toString() {
		return "blue";
	}
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
