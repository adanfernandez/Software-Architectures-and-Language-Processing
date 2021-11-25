package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Center implements TextAlignValor {
	@Override
	public String toString() {
		return "center";
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
