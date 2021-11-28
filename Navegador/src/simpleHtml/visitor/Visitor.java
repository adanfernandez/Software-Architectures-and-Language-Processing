package simpleHtml.visitor;

import simpleHtml.ast.*;

public interface Visitor {
	Object visit(Programa p, Object param);
	Object visit(Head p, Object param);
	Object visit(Link p, Object param);
	Object visit(Href p, Object param);
	Object visit(Rel p, Object param);
	Object visit(Type type, Object param);
	Object visit(Cadena cadena, Object param);
	Object visit(Texto cadena, Object param);
	Object visit(Body body, Object param);
	Object visit(Title title, Object param);
	Object visit(H1 h1, Object param);
	Object visit(H2 h2, Object param);
	Object visit(P p, Object param);
	Object visit(Negrita negrita, Object param);
	Object visit(Cursiva cursiva, Object param);
	Object visit(Subrayado subrayado, Object param);
	Object visit(ContenidoTexto normal, Object param);
	Object visit(H3 h3, Object param);
}
