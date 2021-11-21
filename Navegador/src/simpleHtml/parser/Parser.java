package simpleHtml.parser;

import java.util.List;

import simpleHtml.ast.*;
import java.util.*;

public class Parser {

	Lexicon lex;
	boolean errorSint = false;

	public Parser(Lexicon lex) {
		this.lex = lex;
	}

	// Gestión de Errores Sintáctico
	void errorSintactico(String e, int line) {
		errorSint = true;
		System.out.println("Error Sintáctico : " + e + " en la línea " + line);
	}

	public Programa parse() {
		Token token = lex.getToken();
		if (!token.getToken().equals(TokensId.HTMLI)) {
			errorSintactico("Se esperaba <html> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		Programa programa = new Programa(parseHead(), parseBody());
		token = lex.getToken();
		if (!token.getToken().equals(TokensId.HTMLC)) {
			errorSintactico("Se esperaba </html> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return programa;
	}

	public Head parseHead() {
		Token token = lex.getToken();
		if (!token.getToken().equals(TokensId.HEADI)) {
			errorSintactico("Se esperaba <head> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		Head head = new Head(parseTitle(), parseLink());
		token = lex.getToken();
		if (!token.getToken().equals(TokensId.HEADC)) {
			errorSintactico("Se esperaba </head> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return head;
	}

	public Body parseBody() {
		Token token = lex.getToken();
		if (!token.getToken().equals(TokensId.BODYI)) {
			errorSintactico("Se esperaba <body> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
		while ((token.token == TokensId.H1I) || (token.token == TokensId.H2I) || (token.token == TokensId.PI)) {
			Etiqueta etiqueta = obtenerEtiqueta(token);
			if (etiqueta != null)
				etiquetas.add(etiqueta);
			token = lex.getToken();
		}

		Body body = new Body(etiquetas);
		
		if (!token.getToken().equals(TokensId.BODYC)) {
			errorSintactico("Se esperaba </body> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return body;
	}

	private Etiqueta obtenerEtiqueta(Token token) {
		switch (token.token) {
		case H1I:
			H1 h1 = new H1(obtenerElemento());
			if (!lex.getActualToken().getToken().equals(TokensId.H1C))
				errorSintactico("Se esperaba '</h1>' y se ha obtenido " + lex.getActualToken().getLexeme(),
						lex.getActualToken().getLine());
			return h1;
		case H2I:
			H2 h2 = new H2(obtenerElemento());
			if (!lex.getActualToken().getToken().equals(TokensId.H2C))
				errorSintactico("Se esperaba '</h2>' y se ha obtenido " + lex.getActualToken().getLexeme(),
						lex.getActualToken().getLine());
			return h2;
		case PI:
			P p = new P(obtenerElemento());
			if (!lex.getActualToken().getToken().equals(TokensId.PC))
				errorSintactico("Se esperaba '</p>' y se ha obtenido " + lex.getActualToken().getLexeme(),
						lex.getActualToken().getLine());
			return p;
		default:
			errorSintactico("Se esperaba una etiqueta y se ha obtenido " + token.getLexeme(),
					token.getLine());
			return null;
		}
	}
	
	private List<Elemento> obtenerElemento(){
		Token tok = lex.getToken();
		
		List<Elemento> atributos = new ArrayList<Elemento>();
		while((tok.token == TokensId.TEXTO) || (tok.token == TokensId.CURSIVAI) || (tok.token == TokensId.NEGRITAI) 
				|| (tok.token == TokensId.UNDERLINEI)) {
			Elemento atributo = obtenerAtributoBody(tok);
			if(atributo != null)
				atributos.add(atributo);
			tok = lex.getToken();
		}
		
		return atributos;
	}
	
	private Elemento obtenerAtributoBody(Token tok) {
		switch (tok.getToken()) {
			case TEXTO:
				return new Texto(tok.lexeme);
			case CURSIVAI:
				Cursiva cursiva = new Cursiva(obtenerTextos());
				if(!lex.getActualToken().getToken().equals(TokensId.CURSIVAC))
					errorSintactico("Se esperaba '</i>' y se ha obtenido " + lex.getActualToken().getLexeme(), lex.getActualToken().getLine());
				return cursiva;
			case UNDERLINEI:
				Subrayado underline = new Subrayado(obtenerTextos());
				if(!lex.getActualToken().getToken().equals(TokensId.UNDERLINEC))
					errorSintactico("Se esperaba '</u>' y se ha obtenido " + lex.getActualToken().getLexeme(), lex.getActualToken().getLine());
				return underline;
			case NEGRITAI:
				Negrita negrita = new Negrita(obtenerTextos());
				if(!lex.getActualToken().getToken().equals(TokensId.NEGRITAC))
					errorSintactico("Se esperaba '</b>' y se ha obtenido " + lex.getActualToken().getLexeme(), lex.getActualToken().getLine());
				return negrita;
			default:
				errorSintactico("Se esperaba 'texto o <i> o <b> o <u>' y se ha obtenido " + tok.getLexeme(), tok.getLine());
				return null;
		}
	}
	
	private List<Texto> obtenerTextos() {
		List<Texto> textos = new ArrayList<Texto>();
		Token tok = lex.getToken();
		while(tok.getToken().equals(TokensId.TEXTO)) {
			Texto texto = new Texto(tok.lexeme);
			textos.add(texto);
			tok = lex.getToken();
		}
		return textos;
	}

	public Title parseTitle() {
		Token token = lex.getToken();
		if (!token.getToken().equals(TokensId.TITLEI)) {
			errorSintactico("Se esperaba <title> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		List<Texto> textos = new ArrayList<Texto>();
		while (token.getToken().equals(TokensId.TEXTO)) {
			textos.add(new Texto(token.getLexeme()));
			token = lex.getToken();
		}
		if (!token.getToken().equals(TokensId.TITLEC)) {
			errorSintactico("Se esperaba </title> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return new Title(textos);
	}

	public Link parseLink() {
		Token token = lex.getToken();
		if (!token.getToken().equals(TokensId.LINKI))
			errorSintactico("Se esperaba '<link' y se ha encontrado " + token.getLexeme(), token.getLine());

		token = lex.getToken();
		if (!token.getToken().equals(TokensId.HREFI)) {
			errorSintactico("Se esperaba <href> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		Href href = new Href(new Cadena(token.getLexeme()));

		token = lex.getToken();
		if (!token.getToken().equals(TokensId.RELI)) {
			errorSintactico("Se esperaba <rel> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		Rel rel = new Rel(new Cadena(token.getLexeme()));

		token = lex.getToken();
		if (!token.getToken().equals(TokensId.TYPEI)) {
			errorSintactico("Se esperaba <type> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		Type type = new Type(new Cadena(token.getLexeme()));

		token = lex.getToken();
		if (!token.getToken().equals(TokensId.CIERRE)) {
			errorSintactico("Se esperaba > y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		
		return new Link(href, rel, type);
	}

}
