package simpleCss.visitor;

import simpleCss.ast.*;

public interface Visitor {
	Object visit(Black p, Object param);
	Object visit(Blue p, Object param);
	Object visit(Center p, Object param);
	Object visit(Color p, Object param);
	Object visit(FontSize p, Object param);
	Object visit(FontStyle p, Object param);
	Object visit(Green p, Object param);
	Object visit(H1 p, Object param);
	Object visit(H2 p, Object param);
	Object visit(Italic p, Object param);
	Object visit(Left p, Object param);
	Object visit(Normal p, Object param);
	Object visit(P p, Object param);
	Object visit(ProgramaCss p, Object param);
	Object visit(Right p, Object param);
	Object visit(Size p, Object param);
	Object visit(TextAlign p, Object param);
}
