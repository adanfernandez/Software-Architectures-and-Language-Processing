package visitor;

import ast.*;

public class PrintVisitor implements Visitor {
	public Object visit(Programa programa, Object param) {
		System.out.println("M {");
		for (Sentencia sentencia:programa.sentencias)
			sentencia.accept(this, null);
		System.out.println("}");
		return null;
	}

	public Object visit(Lectura read, Object param) {
		System.out.print("R ");
		read.var.accept(this, null);
		System.out.println(";");
		return null;
	}

	public Object visit(Asignacion asigna, Object param) {
		asigna.variable.accept(this, null);
		System.out.print(" = ");
		asigna.expr.accept(this, null);
		System.out.println(";");
		return null;
	}

	public Object visit(Escritura print, Object param) {
		System.out.print("W ");
		print.expr.accept(this, null);
		System.out.println(";");
		return null;
	}

	public Object visit(ConstanteInt cte, Object param) {
		System.out.print(cte.valor);
		return null;
	}

	public Object visit(Variable refVar, Object param) {
		System.out.print(refVar.name);
		return null;
	}

	public Object visit(Termino term, Object param) {
		term.left.accept(this, null);
		System.out.print(" " + term.operator + " ");
		term.right.accept(this, null);
		return null;
	}

	public Object visit(Factor fact, Object param) {
		fact.left.accept(this, null);
		System.out.print(" " + fact.operator + " ");
		fact.right.accept(this, null);
		return null;
	}

}
