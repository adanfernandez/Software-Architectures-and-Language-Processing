package visitor;

import java.io.*;
import java.util.*;

import ast.*;

public class InterpreteVisitor implements Visitor {
	public Object visit(Programa programa, Object param) {
		for (Sentencia sentencia : programa.sentencias)
			sentencia.accept(this, null);
		return null;
	}

	public Object visit(Lectura read, Object param) {
		int valor;
		System.out.print("Introduzca el valor para la variable " + read.var.name + ": ");
		try {
			valor = Integer.parseInt(consola.readLine());
		} catch (Exception e) {
			valor = 0;
		}
		memory.put(read.var.name, valor);
		return null;
	}

	public Object visit(Asignacion asigna, Object param) {
		int valor = (Integer) asigna.expr.accept(this, null);
		memory.put(asigna.variable.name, valor);
		return null;
	}

	public Object visit(Escritura print, Object param) {
		System.out.println(print.expr.accept(this, null));
		return null;
	}

	public Object visit(ConstanteInt cte, Object param) {
		return Integer.parseInt(cte.valor);
	}

	public Object visit(Variable var, Object param) {
		Integer valor = memory.get(var.name);
		if (valor == null)
			valor = 0;
		return valor;
	}

	public Object visit(Termino term, Object param) {
		if (term.operator.contentEquals("+"))
			return (Integer) term.left.accept(this, null) + (Integer) term.right.accept(this, null);
		else
			return (Integer) term.left.accept(this, null) - (Integer) term.right.accept(this, null);
	}

	public Object visit(Factor fact, Object param) {
		if (fact.operator.contentEquals("*"))
			return (Integer) fact.left.accept(this, null) * (Integer) fact.right.accept(this, null);
		else
			return (Integer) fact.left.accept(this, null) / (Integer) fact.right.accept(this, null);
	}

	private BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
	private Map<String, Integer> memory = new HashMap<String, Integer>();

}
