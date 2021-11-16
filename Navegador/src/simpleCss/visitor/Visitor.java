package simpleCss.visitor;

import simpleCss.ast.*;

public interface Visitor {
	Object visit(Program p, Object param);
	// Resto de métodos
	//...
}
