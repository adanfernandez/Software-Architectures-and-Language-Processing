package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Black implements ColorValor{

	@Override
	public String toString() {
		return "black";
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
