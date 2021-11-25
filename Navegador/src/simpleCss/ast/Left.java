package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Left implements TextAlignValor {
	@Override
	public String toString() {
		return "left";
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
