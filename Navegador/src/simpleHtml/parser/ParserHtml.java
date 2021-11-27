package simpleHtml.parser;

import java.util.List;

import simpleHtml.ast.*;
import java.util.*;

public class ParserHtml {

	LexiconHtml lex;
	boolean errorSint = false;

	public ParserHtml(LexiconHtml lex) {
		this.lex = lex;
	}

	// Gestión de Errores Sintáctico
	void errorSintactico(String e, int line) {
		errorSint = true;
		System.out.println("Error Sintáctico : " + e + " en la línea " + line);
	}

	public Programa parse() {
		TokenHtml token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.HTMLI)) {
			errorSintactico("Se esperaba <html> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		Programa programa = new Programa(parseHead(), parseBody());
		token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.HTMLC)) {
			errorSintactico("Se esperaba </html> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return programa;
	}

	public Head parseHead() {
		TokenHtml token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.HEADI)) {
			errorSintactico("Se esperaba <head> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		Head head = new Head(parseTitle(), parseLink());
		token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.HEADC)) {
			errorSintactico("Se esperaba </head> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return head;
	}

	public Body parseBody() {
		TokenHtml token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.BODYI)) {
			errorSintactico("Se esperaba <body> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
		while ((token.token == TokensIdHtml.H1I) || (token.token == TokensIdHtml.H2I) || (token.token == TokensIdHtml.H3I) || (token.token == TokensIdHtml.PI)) {
			Etiqueta etiqueta = obtenerEtiqueta(token);
			if (etiqueta != null)
				etiquetas.add(etiqueta);
			token = lex.getToken();
		}

		Body body = new Body(etiquetas);
		
		if (!token.getToken().equals(TokensIdHtml.BODYC)) {
			errorSintactico("Se esperaba </body> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return body;
	}

	private Etiqueta obtenerEtiqueta(TokenHtml token) {
		switch (token.token) {
		case H1I:
			H1 h1 = new H1(obtenerElemento());
			if (!lex.getActualToken().getToken().equals(TokensIdHtml.H1C))
				errorSintactico("Se esperaba '</h1>' y se ha obtenido " + lex.getActualToken().getLexeme(),
						lex.getActualToken().getLine());
			return h1;
		case H2I:
			H2 h2 = new H2(obtenerElemento());
			if (!lex.getActualToken().getToken().equals(TokensIdHtml.H2C))
				errorSintactico("Se esperaba '</h2>' y se ha obtenido " + lex.getActualToken().getLexeme(),
						lex.getActualToken().getLine());
			return h2;
		case H3I:
			H3 h3 = new H3(obtenerElemento());
			if (!lex.getActualToken().getToken().equals(TokensIdHtml.H3C))
				errorSintactico("Se esperaba '</h3>' y se ha obtenido " + lex.getActualToken().getLexeme(),
						lex.getActualToken().getLine());
			return h3;
		case PI:
			P p = new P(obtenerElemento());
			if (!lex.getActualToken().getToken().equals(TokensIdHtml.PC))
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
		TokenHtml tok = lex.getToken();
		
		List<Elemento> atributos = new ArrayList<Elemento>();
		while((tok.token == TokensIdHtml.TEXTO) || (tok.token == TokensIdHtml.CURSIVAI) || (tok.token == TokensIdHtml.NEGRITAI) 
				|| (tok.token == TokensIdHtml.UNDERLINEI)) {
			Elemento atributo = obtenerAtributoBody(tok);
			
			if(tok.token == TokensIdHtml.TEXTO) {
				atributo = new Texto(obtenerTextos());
			}
			
			if(atributo != null)
				atributos.add(atributo);
			
			if(tok.token == TokensIdHtml.TEXTO) {
				tok = lex.getActualToken();
			} else {
				tok = lex.getToken();
			}
		}
		
		return atributos;
	}
	
	private Elemento obtenerAtributoBody(TokenHtml tok) {
		switch (tok.getToken()) {
			case TEXTO:
				return null;
			case CURSIVAI:
				Cursiva cursiva = new Cursiva(obtenerTextos());
				if(!lex.getActualToken().getToken().equals(TokensIdHtml.CURSIVAC))
					errorSintactico("Se esperaba '</i>' y se ha obtenido " + lex.getActualToken().getLexeme(), lex.getActualToken().getLine());
				return cursiva;
			case UNDERLINEI:
				lex.getToken();
				Subrayado underline = new Subrayado(obtenerTextos());
				if(!lex.getActualToken().getToken().equals(TokensIdHtml.UNDERLINEC))
					errorSintactico("Se esperaba '</u>' y se ha obtenido " + lex.getActualToken().getLexeme(), lex.getActualToken().getLine());
				return underline;
			case NEGRITAI:
				lex.getToken();
				Negrita negrita = new Negrita(obtenerTextos());
				if(!lex.getActualToken().getToken().equals(TokensIdHtml.NEGRITAC))
					errorSintactico("Se esperaba '</b>' y se ha obtenido " + lex.getActualToken().getLexeme(), lex.getActualToken().getLine());
				return negrita;
			default:
				errorSintactico("Se esperaba 'texto o <i> o <b> o <u>' y se ha obtenido " + tok.getLexeme(), tok.getLine());
				return null;
		}
	}
	
	private List<Normal> obtenerTextos() {
		List<Normal> textos = new ArrayList<Normal>();
		TokenHtml tok = lex.getActualToken();
		if(!tok.getToken().equals(TokensIdHtml.TEXTO)) {
			tok = lex.getToken();
		}
		while(tok.getToken().equals(TokensIdHtml.TEXTO)) {
			Normal texto = new Normal(tok.lexeme);
			textos.add(texto);
			tok = lex.getToken();
		}
		return textos;
	}

	public Title parseTitle() {
		TokenHtml token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.TITLEI)) {
			errorSintactico("Se esperaba <title> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		List<Normal> textos = new ArrayList<Normal>();
		while (token.getToken().equals(TokensIdHtml.TEXTO)) {
			Normal normal = new Normal(token.getLexeme());
			textos.add(normal);
			token = lex.getToken();
		}
		if (!token.getToken().equals(TokensIdHtml.TITLEC)) {
			errorSintactico("Se esperaba </title> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		return new Title(textos);
	}

	public Link parseLink() {
		TokenHtml token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.LINKI))
			errorSintactico("Se esperaba '<link' y se ha encontrado " + token.getLexeme(), token.getLine());

		token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.HREFI)) {
			errorSintactico("Se esperaba <href> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		Href href = new Href(new Cadena(token.getLexeme()));

		token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.RELI)) {
			errorSintactico("Se esperaba <rel> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		Rel rel = new Rel(new Cadena(token.getLexeme()));

		token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.TYPEI)) {
			errorSintactico("Se esperaba <type> y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		token = lex.getToken();
		Type type = new Type(new Cadena(token.getLexeme()));

		token = lex.getToken();
		if (!token.getToken().equals(TokensIdHtml.CIERRE)) {
			errorSintactico("Se esperaba > y se ha obtenido " + token.getLexeme(), token.getLine());
		}
		
		return new Link(href, rel, type);
	}

}
