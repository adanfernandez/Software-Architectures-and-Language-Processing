package ast;

import visitor.*;

public class Escritura implements Sentencia {
    public Expresion expr;
    public Escritura(Expresion expr) {
        this.expr = expr;
    }
    
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}

