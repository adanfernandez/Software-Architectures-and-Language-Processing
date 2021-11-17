package simpleHtml.parser;

import java.util.List;

import simpleHtml.ast.*;
import java.util.*;

public class Parser {
	
	Lexicon lex;
	boolean errorSint = false;
	
	public Parser (Lexicon lex) {
		this.lex = lex;
	}
	
	public AstHtml parse () {
		return null;
	}
	

	//Gestión de Errores Sintáctico
	void errorSintactico (String e, int line) {
		errorSint = true;
		System.out.println("Error Sintáctico : "+e+" en la línea "+line);
	}
}
