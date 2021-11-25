package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Green implements ColorValor{
	@Override
	public String toString() {
		return "green";
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
