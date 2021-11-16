package ast;

import visitor.*;

public class Lectura implements Sentencia {
    public Variable var;
    public Lectura(Variable var) {
        this.var = var;
    }
    
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
