package parser;

import ast.*;
import java.util.*;

public class Parser {
	
	Lexicon lex;
	boolean errorSint = false;
	
	public Parser (Lexicon lex) {
		this.lex = lex;
	}
	
	public Ast parse () {
		return programa();
	}
	
	// Analizador sintáctico
	
	Ast programa () {
		Token tok = lex.getToken();
		if (tok.token != TokensId.M)
			errorSintactico("Se esperaba 'M', encontrado '"+tok.getLexeme()+"'", tok.getLine());
		tok = lex.getToken();
		if (tok.token != TokensId.LLA)
			errorSintactico("Se esperaba '{', encontrado '"+tok.getLexeme()+"'", tok.getLine());
		List<Sentencia> sentencias = bloque();
		tok = lex.getToken();
		if (tok.token != TokensId.LLC)
			errorSintactico("Se esperaba '}', encontrado '"+tok.getLexeme()+"'", tok.getLine());
		if (errorSint)
			return null;
		return new Programa (sentencias);
	}
	
	List<Sentencia> bloque () {
		List<Sentencia> sentencias = new ArrayList<Sentencia>();
		Sentencia sent;
		Token tok = lex.getToken();
		while ((tok.token == TokensId.R) || (tok.token == TokensId.W) || (tok.token == TokensId.VARIABLE)) {
			lex.returnLastToken();
			sent = sentencia();
			if (sent != null)
				sentencias.add(sent);
			tok = lex.getToken();
			if (tok.token != TokensId.PYC)
				errorSintactico("Se esperaba ';', encontrado '"+tok.getLexeme()+"'", tok.getLine());
			tok = lex.getToken();
		}
		lex.returnLastToken();
		if (errorSint)
			return null;		
		return sentencias;
	}
	
	Sentencia sentencia () {
		Sentencia sent;
		Token tok = lex.getToken();
		switch(tok.token) {
			case R:
				sent = lectura();
				break;
			case W:
				sent = escritura();
				break;
			case VARIABLE:
				lex.returnLastToken();
				sent = asignacion();
				break;
			default:
				sent = null; // Nunca va a llegar aquí, es sólo para evitar un warning
		}
		if (errorSint)
			return null;		
		return sent;
	}
	
	Asignacion asignacion () {
		Asignacion asig = null;
		Variable var = variable();
		Token tok = lex.getToken();
		if (tok.token != TokensId.EQ)
			errorSintactico("Se esperaba '=', encontrado '"+tok.getLexeme()+"'", tok.getLine());
		Expresion exp = expresion();
		if ((var != null) && (exp != null))
			asig = new Asignacion (var, exp);
		if (errorSint)
			return null;		
		return asig;
	}
	
	Expresion expresion () {
		Expresion ter1, ter2;
		ter1 = termino();
		Token tok = lex.getToken();
		while ((tok.token == TokensId.MAS) || (tok.token == TokensId.MENOS)) {
			ter2 = termino();
			if ((ter1 != null) && (ter2 != null))
			ter1 = new Termino(ter1, ter2, tok.getLexeme());
			tok = lex.getToken();
		}
		lex.returnLastToken();
		if (errorSint)
			return null;
		return ter1;
	}
	
	Expresion termino () {
		Expresion fac1, fac2;
		fac1 = factor();
		Token tok = lex.getToken();
		while ((tok.token == TokensId.MULT) || (tok.token == TokensId.DIV)) {
			fac2 = factor();
			if ((fac1 != null) && (fac2 != null))
			fac1 = new Factor(fac1, fac2, tok.getLexeme());
			tok = lex.getToken();
		}
		lex.returnLastToken();
		if (errorSint)
			return null;
		return fac1;
	}
	
	Expresion factor () {
		Token tok = lex.getToken();
		switch (tok.token) {
			case VARIABLE:
				lex.returnLastToken();
				Variable var = variable();
				return var;
			case CONSTANTE:
				lex.returnLastToken();
				ConstanteInt constant = constante();
				return constant;
			case PARABRE:
				Expresion exp = expresion();
				tok = lex.getToken();
				if (tok.token != TokensId.PARCIERRA)
					errorSintactico("Se esperaba ')', encontrado '"+tok.getLexeme()+"'", tok.getLine());
				return exp;
			default:
				errorSintactico("Se esperaba una variable, una constante o un '(', encontrado '"+tok.getLexeme()+"'", tok.getLine());
		}
		return null;
	}
	
	Escritura escritura () {
		Escritura escrit = null;
		Expresion exp = expresion();
		if (exp != null)
			escrit = new Escritura (exp);
		if (errorSint)
			return null;		
		return escrit;
	}
	
	Lectura lectura () {
		Variable var = variable(); 
		if (errorSint)
			return null;		
		return new Lectura(var); 
	}
	
	Variable variable () {
		// Variable podría ser un token o una producción del sintáctico.
		Token tok = lex.getToken();
		if (tok.getToken() != TokensId.VARIABLE)
			errorSintactico("Se esperaba una variable, encontrado '"+tok.getLexeme()+"'", tok.getLine());
		if (errorSint)
			return null;		
		return new Variable(tok.getLexeme()); 
	}
	
	ConstanteInt constante () {
		// COnstante podría ser un token o una producción del sintáctico.
		// Retorna un tipo COnstanteInt en lugar de simplemente constante para poder ampliar el
		// sintáctico en el futuro con más tipos
		Token tok = lex.getToken();
		if (tok.getToken() != TokensId.CONSTANTE)
			errorSintactico("Se esperaba una constante, encontrado '"+tok.getLexeme()+"'", tok.getLine());
		if (errorSint)
			return null;		
		return new ConstanteInt(tok.getLexeme()); 
		
	}
	
	//Gestión de Errores Sintáctico
	void errorSintactico (String e, int line) {
		errorSint = true;
		System.out.println("Error Sintáctico : "+e+" en la línea "+line);
	}
}
