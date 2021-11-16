package main;

import java.io.*;

import visitor.*;
import ast.*;
import parser.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		FileReader filereader = new FileReader ("P001.ms01");
		
		// Léxico
		System.out.println("LEXICO\n");
		Lexicon lex = new Lexicon(filereader);
		listaTokens(lex);
		System.out.println("\nFIN LEXICO");
		
		// Sintáctico
		System.out.println("\nSINTÁCTICO\n");
		lex.reset();
		Parser parser = new Parser (lex);
		Ast ast = parser.parse();
		System.out.println("\nFIN SINTÁCTICO\n");
		
		// Visitor printVisitor
		System.out.println("\nVISITOR PRINT\n");
		if (ast != null) {
			PrintVisitor vprint = new PrintVisitor();
			ast.accept(vprint, null);
		}
		else
			System.out.println ("No se ha generado AST");
		System.out.println("\nFIN VISITOR PRINT\n");

		// Visitor GenCodeVisitor
		System.out.println("\nVISITOR GENCODE\n");
		if (ast != null) {
			GenCodeVisitor vgc = new GenCodeVisitor();
			ast.accept(vgc, null);
		}
		else
			System.out.println ("No se ha generado AST");
		System.out.println("\nFIN VISITOR GENCODE\n");

		// Visitor InterpreteVisitor
		System.out.println("\nVISITOR INTERPRETE\n");
		if (ast != null) {
			InterpreteVisitor vint = new InterpreteVisitor();
			ast.accept(vint, null);
		}
		else
			System.out.println ("No se ha generado AST");
		System.out.println("\nFIN VISITOR INTERPRETE\n");

	}
	
	//Auxiliares
	//Lista de Tokens
	static void listaTokens (Lexicon lex) {
		Token t = lex.getToken();
		while (t.getToken() != TokensId.EOF) {
			System.out.println(t.toString());
			t = lex.getToken();
		}
		System.out.println ("\nFin de fichero. \n"+t.toString());	
	}
}
