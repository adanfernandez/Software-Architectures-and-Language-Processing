package visitor;

import ast.*;

public interface Visitor {
	Object visit(Programa p, Object param);

	Object visit(Lectura r, Object param);

	Object visit(Asignacion r, Object param);

	Object visit(Escritura p, Object param);

	Object visit(Variable r, Object param);

	Object visit(ConstanteInt s, Object param);

	Object visit(Termino s, Object param);

	Object visit(Factor s, Object param);
}
