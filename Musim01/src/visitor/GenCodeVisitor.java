package visitor;

import ast.*;

public class GenCodeVisitor  implements Visitor {
	public Object visit(Programa programa, Object param) {
		for (Sentencia sentencia:programa.sentencias)
			sentencia.accept(this, null);
		return null;
	}

	public Object visit(Lectura read, Object param) {
		read.var.accept(this, "Izq");
		System.out.println("input\nstore");
		return null;
	}

	public Object visit(Asignacion asigna, Object param) {
		asigna.variable.accept(this, "Izq");
		asigna.expr.accept(this, null);
		System.out.println("store");
		return null;
	}

	public Object visit(Escritura print, Object param) {
		print.expr.accept(this, null);
		System.out.println("output");
		return null;
	}

	public Object visit(ConstanteInt cte, Object param) {
		System.out.println("pushc " + cte.valor);
		return null;
	}

	public Object visit(Variable refVar, Object param) {
		System.out.println("pushv "+refVar.name);
		if ((String) param != "Izq")
			System.out.println("load");
		return null;
	}

	public Object visit(Termino term, Object param) {
		term.left.accept(this, null);
		term.right.accept(this, null);
		if (term.operator.equals("+"))
			System.out.println("add");
		else
			System.out.println("sub");
		return null;
	}

	public Object visit(Factor fact, Object param) {
		fact.left.accept(this, null);
		fact.right.accept(this, null);
		if (fact.operator.equals("*"))
			System.out.println("mul");
		else
			System.out.println("div");
		return null;
	}

}

