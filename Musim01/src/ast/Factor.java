package ast;

import visitor.*;

public class Factor implements Expresion {
	public Expresion left, right;
	public String operator;

	public Factor(Expresion left, Expresion right, String operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
