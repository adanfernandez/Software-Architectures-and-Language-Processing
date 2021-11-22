package simpleCss.parser;

import simpleCss.ast.*;

public class ParserCss {
	
	LexiconCss lex;
	boolean errorSint = false;
	
	public ParserCss (LexiconCss lex) {
		this.lex = lex;
	}
	
	public Programa parse () {
		Programa programa = new Programa();
		TokenCss token = lex.getToken();
		/*if(!token.getToken().equals(TokensIdCss.H1) || !token.getToken().equals(TokensIdCss.H2) || !token.getToken().equals(TokensIdCss.P) ) {
			errorSintactico("Se esperaba h1, h2 o p y se ha obtenido " + token.getLexeme(), token.getLine());
		}*/
		
		while(token.getToken().equals(TokensIdCss.H1) || token.getToken().equals(TokensIdCss.H2) || token.getToken().equals(TokensIdCss.P)) {
			
			Campo campo = null;
			if(token.getToken().equals(TokensIdCss.H1)) {
				campo = new H1(null);
			} else if(token.getToken().equals(TokensIdCss.H2)) {
				campo = new H2(null);
			} else if(token.getToken().equals(TokensIdCss.P)) {
				campo = new P(null);
			}
			
			token = lex.getToken();
			if(!token.getToken().equals(TokensIdCss.LLAVE_INICIO)) {
				errorSintactico("Se esperaba { y se ha obtenido " + token.getLexeme(), token.getLine());
			}
			
			
			
			
			token = lex.getToken();
			Asignacion asignacion = null;
			
			
			while(token.getToken().equals(TokensIdCss.COLOR) || token.getToken().equals(TokensIdCss.TEXT_ALIGN) || token.getToken().equals(TokensIdCss.FONT_STYLE) || token.getToken().equals(TokensIdCss.FONT_SIZE)) {
				if(token.getToken().equals(TokensIdCss.COLOR)) {
					token = lex.getToken();
					if(!token.getToken().equals(TokensIdCss.DOS_PUNTOS)) {
						errorSintactico("Se esperaba : y se ha obtenido " + token.getLexeme(), token.getLine());
					}
					token = lex.getToken();
					ColorValor colorValue = null;
					if(token.getToken().equals(TokensIdCss.BLACK)) {
						colorValue = new Black();
					} else if(token.getToken().equals(TokensIdCss.GREEN)) {
						colorValue = new Green();
					} else if(token.getToken().equals(TokensIdCss.BLUE)) {
						colorValue = new Blue();
					} else {
						errorSintactico("Se esperaba un color y se ha obtenido " + token.getLexeme(), token.getLine());
					}
					asignacion = new Color(colorValue);
				} if(token.getToken().equals(TokensIdCss.FONT_SIZE)) {
					token = lex.getToken();
					if(!token.getToken().equals(TokensIdCss.DOS_PUNTOS)) {
						errorSintactico("Se esperaba : y se ha obtenido " + token.getLexeme(), token.getLine());
					}
					token = lex.getToken();
					Size size = new Size(token.getLexeme());
					asignacion = new FontSize(size);					
				} if(token.getToken().equals(TokensIdCss.TEXT_ALIGN)) {
					token = lex.getToken();
					if(!token.getToken().equals(TokensIdCss.DOS_PUNTOS)) {
						errorSintactico("Se esperaba : y se ha obtenido " + token.getLexeme(), token.getLine());
					}
					token = lex.getToken();
					TextAlignValor textAlignValor = null;
					if(token.getToken().equals(TokensIdCss.CENTER)) {
						textAlignValor = new Center();
					} else if(token.getToken().equals(TokensIdCss.RIGHT)) {
						textAlignValor = new Right();
					} else if(token.getToken().equals(TokensIdCss.LEFT)) {
						textAlignValor = new Left();
					} else {
						errorSintactico("Se esperaba un center, right o left y se ha obtenido " + token.getLexeme(), token.getLine());
					}
					asignacion = new TextAlign(textAlignValor);
				}  if(token.getToken().equals(TokensIdCss.FONT_STYLE)) {
					token = lex.getToken();
					if(!token.getToken().equals(TokensIdCss.DOS_PUNTOS)) {
						errorSintactico("Se esperaba : y se ha obtenido " + token.getLexeme(), token.getLine());
					}
					token = lex.getToken();
					FontStyleValor fontStyleValor = null;
					if(token.getToken().equals(TokensIdCss.ITALIC)) {
						fontStyleValor = new Italic();
					} else if(token.getToken().equals(TokensIdCss.NORMAL)) {
						fontStyleValor = new Normal();
					} else {
						errorSintactico("Se esperaba un italic o normal y se ha obtenido " + token.getLexeme(), token.getLine());
					}
					asignacion = new FontStyle(fontStyleValor);
				} 
				
				token = lex.getToken();
				if(!token.getToken().equals(TokensIdCss.PUNTO_COMA)) {
					errorSintactico("Se esperaba ; y se ha obtenido " + token.getLexeme(), token.getLine());
				}
				
				campo.setAsignacion(asignacion);
				programa.getAtributos().add(campo);
				token = lex.getToken();
			}
			if(!token.getToken().equals(TokensIdCss.LLAVE_FIN)) {
				errorSintactico("Se esperaba } y se ha obtenido " + token.getLexeme(), token.getLine());
			}
		}
		return programa;
	}

	
	void errorSintactico(String e, int line) {
		errorSint = true;
		System.out.println("Error Sintáctico : " + e + " en la línea " + line);
	}
}
