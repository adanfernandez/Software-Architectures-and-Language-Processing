package simpleCss.ast;

import simpleCss.visitor.Visitor;

public class Size implements Valor {
	public String value;

	public Size(String value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
