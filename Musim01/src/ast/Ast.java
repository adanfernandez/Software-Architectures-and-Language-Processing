package ast;

import visitor.*;

public interface Ast {
	Object accept(Visitor v, Object param);
}
